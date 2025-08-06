package com.hackathon.phishing_simulator.controller;

import com.hackathon.phishing_simulator.dto.SampleMailRequestDTO;
import com.hackathon.phishing_simulator.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping("/sample")
    public String sendSampleMail(@RequestBody SampleMailRequestDTO request) {
        mailService.sendSampleMail(request);
        return "Sample mail sent successfully";
    }
}
