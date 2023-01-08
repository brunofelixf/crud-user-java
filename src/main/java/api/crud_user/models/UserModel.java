package api.crud_user.models;

import api.crud_user.models.adress.Address;
import api.crud_user.models.dto.UserRegisterData;
import api.crud_user.models.dto.UserUpdateData;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserModel {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private LocalDate birthday;
    @Embedded
    private Address address;

    public UserModel(UserRegisterData userData) {
        this.name = userData.name();
        this.birthday = userData.birthday();
        this.address = new Address(userData.address());
    }

    public void update(UserUpdateData data) {

        if (data.name()!= null) {
            this.name = data.name();
        }
        if(data.birthday()!= null) {
            this.birthday = data.birthday();
        }
        if(data.address()!= null) {
            this.address.updateAddress(data.address());
        }

    }
}
