package com.smarthire.project.controller;

import com.smarthire.project.model.dto.Cv.CvRequest;
import com.smarthire.project.model.dto.Cv.CvResponse;
import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.dto.Result.ResultResponse;
import com.smarthire.project.service.CvService.CvService;
import com.smarthire.project.service.ResultService.ResultService;
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
        String url = "http://127.0.0.1:8000/uploadfile/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        File tempFile = convertMultipartFileToFile(file);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(tempFile));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<CvRequest> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, CvRequest.class);
        CvRequest cv = response.getBody();
        tempFile.delete();
        return new ResponseEntity<>(cvService.create(cv,candidate), HttpStatus.OK);
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File tempFile = File.createTempFile("temp", ".mp4");
        multipartFile.transferTo(tempFile);
        return tempFile;
    }

}
