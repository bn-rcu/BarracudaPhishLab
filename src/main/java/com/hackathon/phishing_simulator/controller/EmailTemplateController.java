package com.hackathon.phishing_simulator.controller;

import com.hackathon.phishing_simulator.dto.EmailTemplateDTO;
import com.hackathon.phishing_simulator.entity.EmailTemplate;
import com.hackathon.phishing_simulator.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/email-templates")
public class EmailTemplateController {
    @Autowired
    private EmailTemplateService service;

    @GetMapping
    public List<EmailTemplateDTO> getAll() {
        return service.getAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<EmailTemplateDTO> getById(@PathVariable Long id) {
        return service.getById(id).map(this::toDTO);
    }

    @PostMapping
    public EmailTemplateDTO create(@RequestBody EmailTemplateDTO dto) {
        EmailTemplate entity = toEntity(dto);
        return toDTO(service.create(entity));
    }

    @PutMapping("/{id}")
    public EmailTemplateDTO update(@PathVariable Long id, @RequestBody EmailTemplateDTO dto) {
        EmailTemplate entity = toEntity(dto);
        return Optional.ofNullable(service.update(id, entity)).map(this::toDTO).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private EmailTemplateDTO toDTO(EmailTemplate entity) {
        EmailTemplateDTO dto = new EmailTemplateDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setHtmlContent(entity.getHtmlContent());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setSubject(entity.getSubject());
        return dto;
    }
    private EmailTemplate toEntity(EmailTemplateDTO dto) {
        EmailTemplate entity = new EmailTemplate();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setHtmlContent(dto.getHtmlContent());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setSubject(dto.getSubject());
        return entity;
    }
}
