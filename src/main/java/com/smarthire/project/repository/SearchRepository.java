package com.smarthire.project.repository;

import com.smarthire.project.model.entity.Recruiter;
import com.smarthire.project.model.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepository extends JpaRepository<Search, Long> {

    List<Search> findByRecruiter(Recruiter recruiter);

}
