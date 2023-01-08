package api.crud_user.models.adress;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(nullable = false, length = 100)
    private String street;
    @Column(nullable = false, length = 8)
    private String zip;
    @Column(nullable = false, length = 4)
    private String number;
    @Column(nullable = false, length = 30)
    private String city;

    public Address(AddressData address) {
        this.street = address.street();
        this.zip = address.zip();
        this.number = address.number();
        this.city = address.city();
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
    }
}
