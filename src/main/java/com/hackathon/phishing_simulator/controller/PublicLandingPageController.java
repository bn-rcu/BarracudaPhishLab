package com.hackathon.phishing_simulator.controller;

import com.hackathon.phishing_simulator.entity.LandingPage;
import com.hackathon.phishing_simulator.repository.LandingPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/landing")
public class PublicLandingPageController {

    @Autowired
    private LandingPageRepository landingPageRepository;

    @GetMapping("/{id}")
    public ResponseEntity<String> getLandingPageContent(@PathVariable Long id) {
        return landingPageRepository.findById(id)
                .map(lp -> ResponseEntity.ok(lp.getHtmlContent()))
                .orElse(ResponseEntity.notFound().build());
    }
}
