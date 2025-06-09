package xyz.catuns.recruiter_to_vendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.catuns.recruiter_to_vendor.entities.Candidate;


public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
