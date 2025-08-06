package com.hackathon.phishing_simulator.dto;

import java.time.LocalDateTime;

public class EmailTemplateDTO {
    private Long id;
    private String name;
    private String htmlContent;
    private LocalDateTime createdDate;
    private String subject;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getHtmlContent() { return htmlContent; }
    public void setHtmlContent(String htmlContent) { this.htmlContent = htmlContent; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}
