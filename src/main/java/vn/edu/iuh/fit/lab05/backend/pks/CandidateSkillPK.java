package vn.edu.iuh.fit.lab05.backend.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.lab05.backend.models.Candidate;
import vn.edu.iuh.fit.lab05.backend.models.Skill;

import java.io.Serializable;

@Getter
@Setter
public class CandidateSkillPK implements Serializable {
    private Candidate candidate;
    private Skill skill;
}
