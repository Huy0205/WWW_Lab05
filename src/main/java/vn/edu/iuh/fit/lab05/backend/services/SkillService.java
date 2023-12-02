package vn.edu.iuh.fit.lab05.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Skill;

@Service
public interface SkillService {
    public Skill add(Skill skill);
}
