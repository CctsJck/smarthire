package com.smarthire.project.service.AttachmentService;

import com.smarthire.project.model.entity.Attachment;
import com.smarthire.project.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Attachment saveAttachment(MultipartFile file) {
        String fileName = file.getOriginalFilename();

    }
}
