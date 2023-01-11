package api.crud_user.services;

import api.crud_user.models.User;
import api.crud_user.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User userSaved(User userData) {
        return repository.save(userData);
    }

    public User findUser(User userData) {
        return repository.findById(userData.getId()).get();
    }
}
