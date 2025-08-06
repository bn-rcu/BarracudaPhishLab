package com.hackathon.phishing_simulator.service;

import com.hackathon.phishing_simulator.entity.LandingPage;
import com.hackathon.phishing_simulator.repository.LandingPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LandingPageService {
    @Autowired
    private LandingPageRepository repository;

    public List<LandingPage> getAll() {
        return repository.findAll();
    }

    public Optional<LandingPage> getById(Long id) {
        return repository.findById(id);
    }

    public LandingPage create(LandingPage page) {
        page.setCreatedDate(LocalDateTime.now());
        return repository.save(page);
    }

    public LandingPage update(Long id, LandingPage page) {
        return repository.findById(id).map(existing -> {
            existing.setName(page.getName());
            existing.setHtmlContent(page.getHtmlContent());
            return repository.save(existing);
        }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
