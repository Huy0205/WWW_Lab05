package vn.edu.iuh.fit.lab05.backend.services;

import org.springframework.data.domain.Page;
import vn.edu.iuh.fit.lab05.backend.models.Candidate;

public interface CandidateService {
    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);

    public Candidate add(Candidate candidate);
}
