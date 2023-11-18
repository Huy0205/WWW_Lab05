package vn.edu.iuh.fit.lab05.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @Column(name = "can_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "full_name", columnDefinition = "varchar(255)", nullable = false)
    private String fullName;
    private LocalDate dob;
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phone;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String email;
    @ManyToOne
    @JoinColumn
    private Address address;

    public Candidate(String fullName, LocalDate dob, String phone, String email, Address address) {
        this.fullName = fullName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
