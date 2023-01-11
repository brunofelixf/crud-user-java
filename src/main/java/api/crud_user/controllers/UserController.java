package api.crud_user.controllers;

import api.crud_user.dto.user.UserDataList;
import api.crud_user.dto.user.UserRegisterData;
import api.crud_user.dto.user.UserUpdateData;
import api.crud_user.models.Address;
import api.crud_user.models.User;
import api.crud_user.repositories.UserRepository;
import api.crud_user.services.AddressService;
import api.crud_user.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;


@RestController
@RequestMapping ("user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @PostMapping
    @Transactional
    public ResponseEntity<User> addUser (@RequestBody @Valid UserRegisterData userData){
        User user = userService.userSaved(new User(userData));
        Address address = addressService.addressSaved(new Address(userData.address()));
        //address.setUser(user);
        user.setAddress(Collections.singletonList(address));
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity<Page<UserDataList>> getUsers(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        return ResponseEntity.status(HttpStatus.OK).body( repository.findAll(pagination).map(UserDataList::new) );
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") Long id){
        Optional<UserDataList> userDataListOptional = repository.findById(id).map(UserDataList::new);
        return userDataListOptional.<ResponseEntity<Object>>
                map(userDataList -> ResponseEntity.status(HttpStatus.OK).body(userDataList))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Usuário não encontrado"));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<Optional<UserDataList>> updateUser (@RequestBody @Valid UserUpdateData userData){
        User user = repository.getReferenceById(userData.id());
        user.update(userData);
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(userData.id()).map(UserDataList::new));

    }
}
