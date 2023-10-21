package com.smarthire.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smarthire.project.model.dto.Cv.CvRequest;
import com.smarthire.project.model.dto.Cv.CvResponse;
import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;
import com.smarthire.project.service.CvService.CvService;
import com.smarthire.project.service.ResultService.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/cv")
public class CvController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CvService cvService;

    @PostMapping("/{candidate}")
    public ResponseEntity<CvResponse> uploadFile(
            @PathVariable Long candidate,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        /*String url = "http://127.0.0.1:8000/uploadpdffile/";

        log.info("Contenido" + file.getOriginalFilename());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        File tempFile = convertMultipartFileToFile(file);

        log.info(tempFile.getName());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(tempFile));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<CvRequest> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, CvRequest.class);
        CvRequest cv = response.getBody();
        log.info(cv.getHabilidades().toString());
        tempFile.delete();
        return new ResponseEntity<>(cvService.create(cv,candidate), HttpStatus.OK);*/
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        File file1 = convertMultipartFileToFile(file);
        FileSystemResource value = new FileSystemResource(file1);
        map.add("file", value);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =  restTemplate.exchange("http://20.124.60.170/uploadpdffile", HttpMethod.POST, requestEntity, String.class);
        CvRequest cvRequest = new CvRequest();
        cvRequest.setCv(response.getBody());
        log.info(response.getBody());
        return new ResponseEntity<>(cvService.create(cvRequest,candidate), HttpStatus.OK);
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File tempFile = File.createTempFile("temp", ".pdf");
        multipartFile.transferTo(tempFile);
        return tempFile;
    }

    @GetMapping("/{candidate}")
    public ResponseEntity<CvResponse> getCVByCandidate(@PathVariable Long candidate){
        return new ResponseEntity<>(cvService.getByCandidate(candidate),HttpStatus.OK);
    }

}
