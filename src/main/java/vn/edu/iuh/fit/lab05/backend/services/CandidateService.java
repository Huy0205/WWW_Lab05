package vn.edu.iuh.fit.lab05.backend.services;

import org.springframework.data.domain.Page;
import vn.edu.iuh.fit.lab05.backend.models.Candidate;

import java.util.List;

public interface CandidateService {
    public List<Candidate> getAll();

    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);

    public Candidate finCandidateByPhone(String phone);

    public Candidate add(Candidate candidate);
}
