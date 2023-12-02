package vn.edu.iuh.fit.lab05.backend.repositories;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05.backend.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    public Address findAddressByNumberAndStreetAndCityAndCountryAndZipcode(String number, String street, String city, CountryCode country, String zipcode);
}
