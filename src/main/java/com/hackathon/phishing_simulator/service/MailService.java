package com.hackathon.phishing_simulator.service;

import com.hackathon.phishing_simulator.dto.SampleMailRequestDTO;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSampleMail(SampleMailRequestDTO request) {
        try {
            System.out.println("Sending mail to: " + request.getRecipient());
            System.out.println("Subject: " + request.getSubject());
            System.out.println("Body: " + request.getBody());
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(request.getRecipient());
            helper.setSubject(request.getSubject());
            helper.setText(request.getBody(), true); // true = HTML
            mailSender.send(mimeMessage);
            System.out.println("Mail sent to: " + request.getRecipient());
        } catch (Exception e) {
            System.out.println("Error sending mail: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
