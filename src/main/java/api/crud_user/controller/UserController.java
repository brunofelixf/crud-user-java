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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("user")
public class UserController {

    @Autowired
    private UserRepository repository;
    @PostMapping
    @Transactional
    public void addUser (@RequestBody @Valid UserRegisterData userData){
        repository.save(new UserModel(userData));
    }

    @GetMapping
    public Page<UserDataList> getUser(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        return repository.findAll(pagination).map(UserDataList::new);
    }

    //@PatchMapping
    //public void updateUser (@RequestBody @Valid UserUpdateData userData){}
}
