package com.smarthire.project.controller;

import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;
import com.smarthire.project.service.ResultService.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/result")
public class ResultController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResultService resultService;

    /*@PostMapping("/{candidate}/{question}}")
    public ResponseEntity<ResultResponse> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long candidate,@PathVariable Long question){

        String url  = "";
        ResultRequest resultRequest = restTemplate.getForObject(url, ResultRequest.class);
        return new ResponseEntity<ResultResponse>(resultService.createResult(resultRequest,candidate,question), HttpStatus.OK);
    }*/






}
