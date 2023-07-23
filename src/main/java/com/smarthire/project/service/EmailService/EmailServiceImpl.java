package com.smarthire.project.service.EmailService;

import com.smarthire.project.exception.EmailNotSendException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
@Transactional
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendEmail(String destination, String subject, String content) {
        this.sendEmailTool(destination,subject,content);
    }


    private void sendEmailTool(String email, String subject,String textMessage) {
        new Thread(() -> {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            try {
                helper.setTo(email);
                helper.setText(textMessage, true);
                helper.setSubject(subject);
                javaMailSender.send(message);
            } catch (MessagingException e) {
                throw new EmailNotSendException("No se pudo enviar el correo");
            }
        }).start();
    }
}
