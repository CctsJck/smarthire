package com.smarthire.project.controller;


import com.smarthire.project.model.dto.Recruiter.RecruiterRequest;
import com.smarthire.project.model.dto.Recruiter.RecruiterResponse;
import com.smarthire.project.model.dto.Recruiter.RecruiterResponseEmail;
import com.smarthire.project.model.dto.Recruiter.RecruiterUpdateRequest;
import com.smarthire.project.service.RecruiterService.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;


    @PostMapping("/")
    public ResponseEntity<RecruiterResponse> createAccount(@RequestBody RecruiterRequest recruiterRequest){
        return new ResponseEntity<>(recruiterService.createAccount(recruiterRequest), HttpStatus.OK);
    }

    @PostMapping("/confirmation/{confirmationToken}")
    public ResponseEntity confirmMail (@PathVariable String confirmationToken){

        recruiterService.confirmToken(confirmationToken);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<RecruiterResponse> update(@RequestBody RecruiterUpdateRequest recruiterUpdateRequest){
        return new ResponseEntity<>(recruiterService.update(recruiterUpdateRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruiterResponse> getRecruiterById(@PathVariable Long id){
        return new ResponseEntity<>(recruiterService.findByIdResponse(id), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<RecruiterResponseEmail> getRecruiterByMail(@PathVariable String email){
        return new ResponseEntity<>(recruiterService.findByMail(email),HttpStatus.OK);
    }

    /*@GetMapping("/")
    public ResponseEntity<List<RecruiterResponse>> getAllRecruiters(){
        return new ResponseEntity<>()
    }*/
}
