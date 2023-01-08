package api.crud_user.controller;

import api.crud_user.models.dto.UserDataList;
import api.crud_user.models.dto.UserRegisterData;
import api.crud_user.models.dto.UserUpdateData;
import api.crud_user.repositories.UserRepository;
import api.crud_user.models.UserModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping ("user")
public class UserController {

    @Autowired
    private UserRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<UserModel> addUser (@RequestBody @Valid UserRegisterData userData){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(new UserModel(userData)));
    }

    @GetMapping
    public ResponseEntity<Page<UserDataList>> getUsers(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        return ResponseEntity.status(HttpStatus.OK).body( repository.findAll(pagination).map(UserDataList::new) );
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id){
        Optional<UserDataList> userDataListOptional = repository.findById(id).map(UserDataList::new);
        return userDataListOptional.<ResponseEntity<Object>>
                map(userDataList -> ResponseEntity.status(HttpStatus.OK).body(userDataList))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Usuário não encontrado"));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<Optional<UserDataList>> updateUser (@RequestBody @Valid UserUpdateData userData){
        UserModel user = repository.getReferenceById(userData.id());
        user.update(userData);
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(userData.id()).map(UserDataList::new));

    }
}
