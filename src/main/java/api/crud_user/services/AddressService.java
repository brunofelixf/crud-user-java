package api.crud_user.services;

import api.crud_user.models.adress.Address;
import api.crud_user.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository repository;
    private AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public Address addressSaved(Address address) {
        return repository.save(address);
    }
}
