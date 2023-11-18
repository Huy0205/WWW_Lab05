package vn.edu.iuh.fit.lab05.backend.models;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "com_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String number;
    @Column(columnDefinition = "varchar(150)", nullable = false)
    private String street;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String city;
    @Column(columnDefinition = "varchar(20)", nullable = false)
    private CountryCode country;
    @Column(columnDefinition = "varchar(7)", nullable = false)
    private String zipcode;

    public Address(String number, String street, String city, CountryCode country, String zipcode) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }
}
