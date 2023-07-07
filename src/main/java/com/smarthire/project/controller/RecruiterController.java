package com.smarthire.project.controller;


import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecuiterResponse;
import com.smarthire.project.service.RecruiterService.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;


    @PostMapping("/")
    public ResponseEntity<RecuiterResponse> createAccount(@RequestBody RecruiterRequest recruiterRequest){
        return new ResponseEntity<>(recruiterService.createAccount(recruiterRequest), HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<RecuiterResponse> update(@RequestBody RecruiterRequest recruiterRequest){
        return new ResponseEntity<>(recruiterService.update(recruiterRequest), HttpStatus.OK);
    }
}
