package api.crud_user.models.adress;

import api.crud_user.models.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Embeddable
public class Address {

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
    private UserModel user;

    public Address(AddressData address) {
        this.street = address.street();
        this.zip = address.zip();
        this.number = address.number();
        this.city = address.city();
        this.principal = address.principal();
    }

    public void updateAddress(AddressData address) {
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
