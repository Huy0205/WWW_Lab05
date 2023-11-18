package vn.edu.iuh.fit.lab05.backend.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.lab05.backend.models.Job;
import vn.edu.iuh.fit.lab05.backend.models.Skill;

import java.io.Serializable;

@Getter
@Setter
public class JobSkillPK implements Serializable {
    private Job job;
    private Skill skill;
}
