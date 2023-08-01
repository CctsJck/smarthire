package com.smarthire.project.controller;

import com.smarthire.project.model.dto.Result.ResultRequest;
import com.smarthire.project.model.entity.Attachment;
import com.smarthire.project.service.AttachmentService.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/answer")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public ResponseEntity<ResultResponse> uploadFile(@RequestParam("file")MultipartFile file){

        String url  = ""
        ResultRequest  resultRequest = restTemplate.getForObject(url, ResultRequest.class);
        return Res
    }
}
