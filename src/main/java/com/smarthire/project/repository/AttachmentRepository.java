package com.smarthire.project.repository;

import com.smarthire.project.model.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Long> {
}
