package api.crud_user.models;

import api.crud_user.models.adress.Address;
import api.crud_user.models.data.UserRegisterData;
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
}
