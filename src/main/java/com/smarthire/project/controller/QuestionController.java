package com.smarthire.project.controller;

import com.smarthire.project.model.dto.Question.QuestionRequest;
import com.smarthire.project.model.dto.Question.QuestionResponse;
import com.smarthire.project.model.dto.Question.QuestionUpdateRequest;
import com.smarthire.project.service.QuestionService.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService ;

    @PostMapping("/")
    public ResponseEntity save(@RequestBody List<QuestionRequest> questionRequestList){
        questionService.save(questionRequestList);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<QuestionResponse> update(@RequestBody QuestionUpdateRequest questionUpdateRequest){
        return new ResponseEntity<>(questionService.update(questionUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteQuestionById(@PathVariable Long id) {
        questionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
