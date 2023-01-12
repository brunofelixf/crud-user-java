package api.crud_user.model;

import api.crud_user.DTO.user.UserRegisterDto;
import api.crud_user.DTO.user.UserUpdateDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "users")
@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private LocalDate birthday;
    @OneToMany
    private List<AddressModel> addressModels;

    public UserModel(UserRegisterDto userData) {
        this.name = userData.name();
        this.birthday = userData.birthday();
    }

    public void update(UserUpdateDto data) {

        if (data.name()!= null) {
            this.name = data.name();
        }
        if(data.birthday()!= null) {
            this.birthday = data.birthday();
        }
        //

    }
}
