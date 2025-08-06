package com.hackathon.phishing_simulator.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String targetUsers; // comma separated emails
    private Long emailTemplateId;
    private Long landingPageId;
    private LocalDateTime createdDate;
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getTargetUsers() { return targetUsers; }
    public void setTargetUsers(String targetUsers) { this.targetUsers = targetUsers; }
    public Long getEmailTemplateId() { return emailTemplateId; }
    public void setEmailTemplateId(Long emailTemplateId) { this.emailTemplateId = emailTemplateId; }
    public Long getLandingPageId() { return landingPageId; }
    public void setLandingPageId(Long landingPageId) { this.landingPageId = landingPageId; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
}
