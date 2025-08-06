package com.hackathon.phishing_simulator.service;

import com.hackathon.phishing_simulator.dto.SampleMailRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class MailServiceTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private MailService mailService;

    public MailServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendSampleMail() {
        System.out.println("Starting testSendSampleMail...");
        SampleMailRequestDTO request = new SampleMailRequestDTO();
        request.setRecipient("prashanthpj17@gmail.com");
        request.setSubject("Test Subject");
        request.setBody("Test Body");
        System.out.println("Mail request created: " + request.getRecipient() + ", " + request.getSubject());

        doNothing().when(javaMailSender).send(any(SimpleMailMessage.class));
        System.out.println("Mocked JavaMailSender.send() method.");

        mailService.sendSampleMail(request);
        System.out.println("Called mailService.sendSampleMail().");

        verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));
        System.out.println("Verified JavaMailSender.send() was called once.");
    }
}
