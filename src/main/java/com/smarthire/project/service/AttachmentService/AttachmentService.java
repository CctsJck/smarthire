package com.smarthire.project.service.AttachmentService;

import com.smarthire.project.model.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {

    Attachment saveAttachment(MultipartFile file);
}
