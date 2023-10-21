package com.smarthire.project.controller;

import com.smarthire.project.model.dto.Result.ResultFilterResponse;
import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;
import com.smarthire.project.service.ResultService.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;

// ...

@RestController
@RequestMapping("/result")
@Slf4j
public class ResultController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ResultService resultService;

    /*@PostMapping("/{candidate}/{question}")
    public ResponseEntity<ResultResponse> uploadFile(
            @PathVariable Long candidate,
            @PathVariable Long question,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        String url = "http://127.0.0.1:8000/uploadfile/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        File tempFile = convertMultipartFileToFile(file);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(tempFile));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<ResultRequest> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ResultRequest.class);
        ResultRequest result = response.getBody();
        tempFile.delete();
        return new ResponseEntity<>(resultService.createResult(result,candidate,question), HttpStatus.OK);
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File tempFile = File.createTempFile("temp", ".mp4");
        multipartFile.transferTo(tempFile);
        return tempFile;
    }*/


    @PostMapping("/{candidate}/{question}")
    public ResponseEntity<ResultResponse> getAnswer(
            @PathVariable Long candidate,
            @PathVariable Long question,
            @RequestBody List<ResultRequest> answer){
        String url = "http://20.124.60.170/uploadResult";

        log.info(String.valueOf(answer.get(0).getHappy()));

        HttpEntity<List<ResultRequest>> resultRequest = new HttpEntity<>(answer);

        //log.info(resultRequest.getBody().toString());

        ResponseEntity<ResultRequest> response = restTemplate.exchange(url, HttpMethod.POST, resultRequest, ResultRequest.class);
        ResultRequest result = response.getBody();
        log.info(result.getHappy().toString());
        return new ResponseEntity<>(resultService.createResult(result,candidate,question),HttpStatus.OK);
    }


    @GetMapping("/filter/{question}")
    public ResponseEntity<List<ResultFilterResponse>> getAllAnswers(@PathVariable Long question){
        return new ResponseEntity<>(resultService.filterResults(question),HttpStatus.OK);
    }

    @GetMapping("/test")
    public String testBack() {
    return "Funciona";
    }
}
