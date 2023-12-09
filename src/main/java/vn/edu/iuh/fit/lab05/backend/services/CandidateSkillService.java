package vn.edu.iuh.fit.lab05.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.CandidateSkill;

@Service
public interface CandidateSkillService {
    public CandidateSkill add(CandidateSkill candidateSkill);

    public void deleteAllByCandidateId(long candidate_id);
}
