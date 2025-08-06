package com.hackathon.phishing_simulator.repository;

import com.hackathon.phishing_simulator.entity.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
}
