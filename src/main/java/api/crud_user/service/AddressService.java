package api.crud_user.service;

import api.crud_user.model.AddressModel;
import api.crud_user.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public AddressModel addressSaved(AddressModel addressModel) {
        return addressRepository.save(addressModel);
    }
}
