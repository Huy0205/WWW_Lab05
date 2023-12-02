package vn.edu.iuh.fit.lab05.backend.services.impl;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Address;
import vn.edu.iuh.fit.lab05.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.lab05.backend.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findAddressExist(Address address) {
        return addressRepository.findAddressByNumberAndStreetAndCityAndCountryAndZipcode(address.getNumber(), address.getStreet(), address.getCity(), address.getCountry(), address.getZipcode());
    }
}
