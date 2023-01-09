package api.crud_user.services;

import api.crud_user.models.UserModel;
import api.crud_user.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserModel userSaved(UserModel userData) {
        return repository.save(userData);
    }

    public UserModel findUser(UserModel userData) {
        return repository.findById(userData.getId()).get();
    }
}
