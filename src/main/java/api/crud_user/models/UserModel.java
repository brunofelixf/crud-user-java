package api.crud_user.models;

import api.crud_user.models.adress.Address;
import api.crud_user.models.dto.UserRegisterData;
import api.crud_user.models.dto.UserUpdateData;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "users")
@Entity(name = "user")
@Getter
@Setter
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
    private List<Address> address;

    public UserModel(UserRegisterData userData) {
        this.name = userData.name();
        this.birthday = userData.birthday();
    }

    public void update(UserUpdateData data) {

        if (data.name()!= null) {
            this.name = data.name();
        }
        if(data.birthday()!= null) {
            this.birthday = data.birthday();
        }
        //

    }
}
