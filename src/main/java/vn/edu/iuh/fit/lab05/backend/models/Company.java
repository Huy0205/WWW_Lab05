package vn.edu.iuh.fit.lab05.backend.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "add_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "comp_name", columnDefinition = "varchar(255)", nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String email;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String phone;
    @Column(columnDefinition = "varchar(2000)", nullable = false)
    private String about;
    @Column(name = "web_url",columnDefinition = "varchar(255)", nullable = false)
    private String webURL;
    @ManyToOne
    @JoinColumn
    private Address address;

    public Company(String name, String email, String phone, String about, String webURL, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.webURL = webURL;
        this.address = address;
    }
}
