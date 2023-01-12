package api.crud_user.controller;

import api.crud_user.DTO.user.UserListDto;
import api.crud_user.DTO.user.UserRegisterDto;
import api.crud_user.DTO.user.UserUpdateDto;
import api.crud_user.model.AddressModel;
import api.crud_user.model.UserModel;
import api.crud_user.repository.UserRepository;
import api.crud_user.service.AddressService;
import api.crud_user.service.UserService;
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
@CrossOrigin(origins = "*", maxAge = 3600)
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
    public ResponseEntity<UserModel> addUser (@RequestBody @Valid UserRegisterDto userData){
        UserModel userModel = userService.userSaved(new UserModel(userData));
        AddressModel addressModel = addressService.addressSaved(new AddressModel(userData.address()));
        //addressModel.setUserModel(userModel);
        userModel.setAddressModels(Collections.singletonList(addressModel));
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }

    @GetMapping
    public ResponseEntity<Page<UserListDto>> getUsers(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        return ResponseEntity.status(HttpStatus.OK).body( repository.findAll(pagination).map(UserListDto::new) );
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") Long id){
        Optional<UserListDto> userDataListOptional = repository.findById(id).map(UserListDto::new);
        return userDataListOptional.<ResponseEntity<Object>>
                map(userListDto -> ResponseEntity.status(HttpStatus.OK).body(userListDto))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Usuário não encontrado"));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<Optional<UserListDto>> updateUser (@RequestBody @Valid UserUpdateDto userData){
        UserModel userModel = repository.getReferenceById(userData.id());
        userModel.update(userData);
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(userData.id()).map(UserListDto::new));

    }
}
