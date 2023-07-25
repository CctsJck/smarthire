package com.smarthire.project.controller;

import com.smarthire.project.model.dto.Candidate.CandidateRequest;
import com.smarthire.project.model.dto.Candidate.CandidateResponse;
import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecruiterResponse;
import com.smarthire.project.service.CandidateService.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    @PostMapping("/")
    public ResponseEntity<CandidateResponse> createCandidate(@RequestBody CandidateRequest candidateRequest){
        return new ResponseEntity<CandidateResponse>(candidateService.createCandidate(candidateRequest), HttpStatus.OK);
    }

    @PostMapping("/submit")//ver video para submitear un file
}
