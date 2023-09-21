package com.smarthire.project.repository;

import com.smarthire.project.model.entity.Question;
import com.smarthire.project.model.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result,Long> {

    List<Result> findByQuestion(Question question);
}
