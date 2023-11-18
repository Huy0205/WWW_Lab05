package vn.edu.iuh.fit.lab05.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.lab05.backend.pks.CandidateSkillPK;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "candidate_skill")
@IdClass(CandidateSkillPK.class)
public class CandidateSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Column(name = "skill_level", columnDefinition = "tinyint(4)", nullable = false)
    private byte level;
    @Column(name = "more_infos", columnDefinition = "varchar(1000)", nullable = false)
    private String moreInfos;
}
