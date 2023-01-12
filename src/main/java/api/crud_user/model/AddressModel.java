package api.crud_user.model;

import api.crud_user.DTO.adress.AddressRegisterDto;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 100)
    private String street;
    @Column(nullable = false, length = 8)
    private String zip;
    @Column(nullable = false, length = 4)
    private String number;
    @Column(nullable = false, length = 30)
    private String city;
    @Column(nullable = false)
    private Boolean principal;
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private UserModel userModel;

    public AddressModel(AddressRegisterDto address) {
        this.street = address.street();
        this.zip = address.zip();
        this.number = address.number();
        this.city = address.city();
        this.principal = address.principal();
    }

    public void updateAddress(AddressRegisterDto address) {
        if(address.street()!= null) {
            this.street = address.street();
        }
        if(address.zip()!= null) {
            this.zip = address.zip();
        }
        if(address.number()!= null) {
           this.number = address.number();
        }
        if(address.city()!= null) {
            this.city = address.city();
        }
        if(address.principal()!= null) {
            this.principal = address.principal();
        }
    }
}
