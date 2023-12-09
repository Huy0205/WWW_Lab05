package vn.edu.iuh.fit.lab05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.CandidateSkill;
import vn.edu.iuh.fit.lab05.backend.pks.CandidateSkillPK;
import vn.edu.iuh.fit.lab05.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.lab05.backend.services.CandidateSkillService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateSkillServiceIml implements CandidateSkillService {
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Override
    public CandidateSkill add(CandidateSkill candidateSkill) {
        return candidateSkillRepository.save(candidateSkill);
    }

    @Override
    public void deleteAllByCandidateId(long candidate_id) {
        ArrayList<CandidateSkill> candidateSkills = (ArrayList<CandidateSkill>) candidateSkillRepository.findCandidateSkillByCandidate_Id(candidate_id);
        candidateSkillRepository.deleteAll(candidateSkills);
    }
}
