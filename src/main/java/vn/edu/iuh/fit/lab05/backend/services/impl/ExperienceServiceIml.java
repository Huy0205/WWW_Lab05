package vn.edu.iuh.fit.lab05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Experience;
import vn.edu.iuh.fit.lab05.backend.repositories.ExperienceRepository;
import vn.edu.iuh.fit.lab05.backend.services.ExperienceService;

@Service
public class ExperienceServiceIml implements ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public Experience add(Experience experience) {
        return experienceRepository.save(experience);
    }
}
