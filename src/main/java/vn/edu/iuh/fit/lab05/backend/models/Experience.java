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
@Table(name = "experience")
public class Experience {
    @Id
    @Column(name = "exp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String role;
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;
    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;
    @Column(name = "work_desc", columnDefinition = "varchar(400)", nullable = false)
    private String workDescription;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @ManyToOne
    @JoinColumn
    private Company company;
}
