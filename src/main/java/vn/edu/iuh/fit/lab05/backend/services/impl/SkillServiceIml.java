package vn.edu.iuh.fit.lab05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Skill;
import vn.edu.iuh.fit.lab05.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.lab05.backend.services.SkillService;

@Service
public class SkillServiceIml implements SkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skill add(Skill skill) {
        return skillRepository.save(skill);
    }
}
