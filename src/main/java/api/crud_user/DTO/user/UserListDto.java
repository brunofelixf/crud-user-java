package api.crud_user.DTO.user;

import api.crud_user.model.AddressModel;
import api.crud_user.model.UserModel;

import java.time.LocalDate;

public record UserListDto(
        String name,
        LocalDate birthday,
        Long id,
        java.util.List<AddressModel> addressModels) {
    public UserListDto(UserModel userModel) {
        this(userModel.getName(), userModel.getBirthday(), userModel.getId(), userModel.getAddressModels() );
    }
}
