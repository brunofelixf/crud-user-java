package api.crud_user.service;

import api.crud_user.model.UserModel;
import api.crud_user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserModel userSaved(UserModel userModelData) {
        return userRepository.save(userModelData);
    }

    public Optional<UserModel> findUser(UserModel userModelData) {
        return userRepository.findById(userModelData.getId());
    }
}
