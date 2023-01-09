package api.crud_user.models.dto;

import api.crud_user.models.UserModel;

import java.time.LocalDate;

public record UserDataList(
        String name,
        LocalDate birthday,
        Long id,
        java.util.List<api.crud_user.models.adress.Address> address) {
    public UserDataList(UserModel user) {
        this(user.getName(), user.getBirthday(), user.getId(), user.getAddress() );
    }
}
