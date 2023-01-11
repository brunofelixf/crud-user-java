package api.crud_user.dto.user;

import api.crud_user.models.User;

import java.time.LocalDate;

public record UserDataList(
        String name,
        LocalDate birthday,
        Long id,
        java.util.List<api.crud_user.models.Address> address) {
    public UserDataList(User user) {
        this(user.getName(), user.getBirthday(), user.getId(), user.getAddress() );
    }
}
