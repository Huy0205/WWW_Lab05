package vn.edu.iuh.fit.lab05.backend.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "job")
public class Job {
    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "job_name", columnDefinition = "varchar(255)", nullable = false)
    private String name;
    @Column(name = "job_desc", columnDefinition = "varchar(2000)", nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn
    private Company company;
}
