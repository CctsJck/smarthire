package com.smarthire.project.repository;

import com.smarthire.project.model.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<Recruiter,Long> {

    Recruiter findByUsername(String user);



}
