package vn.edu.iuh.fit.lab05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05.backend.models.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
