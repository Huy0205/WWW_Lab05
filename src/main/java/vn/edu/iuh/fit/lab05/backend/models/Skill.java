package vn.edu.iuh.fit.lab05.backend.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @Column(name = "skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "skill_name", columnDefinition = "varchar(150)", nullable = false)
    private String name;
    @Column(name = "skill_type", nullable = false)
    private byte type;
    @Column(name = "skill_desc", columnDefinition = "varchar(300)", nullable = false)
    private String description;

    public Skill(String name, byte type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }
}
