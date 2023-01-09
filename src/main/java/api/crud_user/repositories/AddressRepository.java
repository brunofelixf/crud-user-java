package api.crud_user.repositories;

import api.crud_user.models.UserModel;
import api.crud_user.models.adress.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
