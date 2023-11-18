package vn.edu.iuh.fit.lab05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05.backend.models.JobSkill;
import vn.edu.iuh.fit.lab05.backend.pks.JobSkillPK;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillPK> {
}
