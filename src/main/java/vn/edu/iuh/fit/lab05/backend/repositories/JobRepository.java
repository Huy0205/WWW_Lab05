package vn.edu.iuh.fit.lab05.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05.backend.models.Job;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("""
            SELECT js.job FROM JobSkill js
            INNER JOIN CandidateSkill cs ON js.skill.id = cs.skill.id
            WHERE cs.candidate.id = :canID""")
    public Page<Job> getSuggestJob(long canID, Pageable pageable);
}
