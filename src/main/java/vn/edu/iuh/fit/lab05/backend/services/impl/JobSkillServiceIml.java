package vn.edu.iuh.fit.lab05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.JobSkill;
import vn.edu.iuh.fit.lab05.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.lab05.backend.services.JobSkillService;

@Service
public class JobSkillServiceIml implements JobSkillService {
    @Autowired
    private JobSkillRepository jobSkillRepository;

    @Override
    public JobSkill add(JobSkill jobSkill) {
        return jobSkillRepository.save(jobSkill);
    }
}
