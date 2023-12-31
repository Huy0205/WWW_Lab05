package vn.edu.iuh.fit.lab05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05.backend.models.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
