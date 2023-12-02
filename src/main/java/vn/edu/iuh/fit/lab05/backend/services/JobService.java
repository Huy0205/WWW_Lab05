package vn.edu.iuh.fit.lab05.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Job;

import java.util.List;

@Service
public interface JobService {
    public Job add(Job job);

    public Page<Job> getSuggestJob(long canID, int pageNo, int pageSize);
}
