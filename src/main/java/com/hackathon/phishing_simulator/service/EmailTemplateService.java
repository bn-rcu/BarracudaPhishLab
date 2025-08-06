package com.hackathon.phishing_simulator.service;

import com.hackathon.phishing_simulator.entity.EmailTemplate;
import com.hackathon.phishing_simulator.repository.EmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmailTemplateService {
    @Autowired
    private EmailTemplateRepository repository;

    public List<EmailTemplate> getAll() {
        return repository.findAll();
    }

    public Optional<EmailTemplate> getById(Long id) {
        return repository.findById(id);
    }

    public EmailTemplate create(EmailTemplate template) {
        template.setCreatedDate(LocalDateTime.now());
        return repository.save(template);
    }

    public EmailTemplate update(Long id, EmailTemplate template) {
        return repository.findById(id).map(existing -> {
            existing.setName(template.getName());
            existing.setHtmlContent(template.getHtmlContent());
            existing.setSubject(template.getSubject());
            return repository.save(existing);
        }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
