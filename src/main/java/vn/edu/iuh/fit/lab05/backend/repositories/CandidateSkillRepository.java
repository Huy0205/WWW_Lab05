package vn.edu.iuh.fit.lab05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05.backend.models.Candidate;
import vn.edu.iuh.fit.lab05.backend.models.CandidateSkill;
import vn.edu.iuh.fit.lab05.backend.models.Skill;
import vn.edu.iuh.fit.lab05.backend.pks.CandidateSkillPK;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillPK> {
    public List<CandidateSkill> findCandidateSkillByCandidate_Id(long candidate_id);
}
