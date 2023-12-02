package vn.edu.iuh.fit.lab05.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Experience;

@Service
public interface ExperienceService {
    public Experience add(Experience experience);

}
