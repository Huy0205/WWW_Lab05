package vn.edu.iuh.fit.lab05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.CandidateSkill;
import vn.edu.iuh.fit.lab05.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.lab05.backend.services.CandidateSkillService;

@Service
public class CandidateSkillServiceIml implements CandidateSkillService {
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Override
    public CandidateSkill add(CandidateSkill candidateSkill) {
        return candidateSkillRepository.save(candidateSkill);
    }
}
