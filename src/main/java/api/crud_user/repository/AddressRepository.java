package api.crud_user.repository;

import api.crud_user.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<AddressModel, Long> {
}
