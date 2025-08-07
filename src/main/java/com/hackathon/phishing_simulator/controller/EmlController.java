package com.hackathon.phishing_simulator.controller;

import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/api/eml")
public class EmlController {

    @PostMapping(value = "/extract-html", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> extractHtml(@RequestParam("file") MultipartFile file) {
        Map<String, String> result = new HashMap<>();
        try (InputStream is = file.getInputStream()) {
            Session session = Session.getDefaultInstance(new Properties());
            MimeMessage message = new MimeMessage(session, is);
            Object content = message.getContent();
            String html = extractHtmlFromContent(content);
            result.put("htmlContent", html != null ? html : "");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.put("htmlContent", "");
            return ResponseEntity.ok(result);
        }
    }

    private String extractHtmlFromContent(Object content) throws Exception {
        if (content instanceof String) {
            String str = (String) content;
            if (str.trim().startsWith("<!DOCTYPE html") || str.trim().startsWith("<html")) {
                return str;
            }
        } else if (content instanceof jakarta.mail.Multipart) {
            jakarta.mail.Multipart multipart = (jakarta.mail.Multipart) content;
            for (int i = 0; i < multipart.getCount(); i++) {
                var part = multipart.getBodyPart(i);
                if (part.isMimeType("text/html")) {
                    return (String) part.getContent();
                }
            }
        }
        return null;
    }
}