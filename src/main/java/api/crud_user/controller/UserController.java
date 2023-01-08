package api.crud_user.controller;

import api.crud_user.models.dto.UserRegisterData;
import api.crud_user.repositories.UserRepository;
import api.crud_user.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("user")
public class UserController {

    @Autowired
    private UserRepository repository;
    @PostMapping
    public void addUser (@RequestBody @Valid UserRegisterData userData){
        repository.save(new UserModel(userData));
    }
}
