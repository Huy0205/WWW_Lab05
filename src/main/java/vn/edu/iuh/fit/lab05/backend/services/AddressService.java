package vn.edu.iuh.fit.lab05.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Address;

@Service
public interface AddressService {
    public Address add(Address address);
}
