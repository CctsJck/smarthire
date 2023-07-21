package com.smarthire.project.repository;

import com.smarthire.project.model.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecruiterRepository extends JpaRepository<Recruiter,Long> {

    Recruiter findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    Optional<Recruiter> findByEmail (String email);



}
