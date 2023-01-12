package api.crud_user.DTO.user;

import api.crud_user.model.AddressModel;
import api.crud_user.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class UserListDto {
    private final String name;
    private final LocalDate birthday;
    private final Long id;
    private final List<AddressModel> addressModels;


    public UserListDto(UserModel userModel) {
        this(userModel.getName(), userModel.getBirthday(), userModel.getId(), userModel.getAddressModels());
    }

}
