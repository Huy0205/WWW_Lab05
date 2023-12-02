package vn.edu.iuh.fit.lab05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Candidate;
import vn.edu.iuh.fit.lab05.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.lab05.backend.services.CandidateService;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }

    @Override
    public Candidate finCandidateByPhone(String phone) {
        return candidateRepository.findCandidateByPhone(phone);
    }

    @Override
    public Candidate add(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
}
