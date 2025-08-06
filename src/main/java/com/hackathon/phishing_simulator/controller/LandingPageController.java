package com.hackathon.phishing_simulator.controller;

import com.hackathon.phishing_simulator.dto.LandingPageDTO;
import com.hackathon.phishing_simulator.entity.LandingPage;
import com.hackathon.phishing_simulator.service.LandingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/landing-pages")
public class LandingPageController {
    @Autowired
    private LandingPageService service;

    @GetMapping
    public List<LandingPageDTO> getAll() {
        return service.getAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<LandingPageDTO> getById(@PathVariable Long id) {
        return service.getById(id).map(this::toDTO);
    }

    @PostMapping
    public LandingPageDTO create(@RequestBody LandingPageDTO dto) {
        LandingPage entity = toEntity(dto);
        return toDTO(service.create(entity));
    }

    @PutMapping("/{id}")
    public LandingPageDTO update(@PathVariable Long id, @RequestBody LandingPageDTO dto) {
        LandingPage entity = toEntity(dto);
        return Optional.ofNullable(service.update(id, entity)).map(this::toDTO).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private LandingPageDTO toDTO(LandingPage entity) {
        LandingPageDTO dto = new LandingPageDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setHtmlContent(entity.getHtmlContent());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }
    private LandingPage toEntity(LandingPageDTO dto) {
        LandingPage entity = new LandingPage();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setHtmlContent(dto.getHtmlContent());
        entity.setCreatedDate(dto.getCreatedDate());
        return entity;
    }
}
