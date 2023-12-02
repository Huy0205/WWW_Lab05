package vn.edu.iuh.fit.lab05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Job;
import vn.edu.iuh.fit.lab05.backend.repositories.JobRepository;
import vn.edu.iuh.fit.lab05.backend.services.JobService;

import java.util.List;

@Service
public class JobServiceIml implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job add(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Page<Job> getSuggestJob(long canID, int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return jobRepository.getSuggestJob(canID, pageRequest);
    }
}
