package com.smarthire.project.repository;

import com.smarthire.project.model.entity.Candidate;
import com.smarthire.project.model.entity.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvRepository extends JpaRepository<Cv,Long> {

    Cv findByCandidate(Candidate candidate);
}
