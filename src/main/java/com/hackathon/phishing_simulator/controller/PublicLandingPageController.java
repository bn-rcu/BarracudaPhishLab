package com.hackathon.phishing_simulator.controller;

import com.hackathon.phishing_simulator.entity.LandingPage;
import com.hackathon.phishing_simulator.repository.LandingPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/public/landing")
public class PublicLandingPageController {

    @Autowired
    private LandingPageRepository landingPageRepository;

    private static final ConcurrentHashMap<Long, AtomicInteger> landingPageClicks = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    public ResponseEntity<String> getLandingPageContent(@PathVariable Long id) {
        // Increment click counter in a thread-safe way
        landingPageClicks.compute(id, (key, value) -> value == null ? new AtomicInteger(1) : new AtomicInteger(value.incrementAndGet()));
        return landingPageRepository.findById(id)
                .map(lp -> ResponseEntity.ok(lp.getHtmlContent()))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint to get click count for a landing page
    @GetMapping("/{id}/clicks")
    public ResponseEntity<Integer> getLandingPageClicks(@PathVariable Long id) {
        AtomicInteger count = landingPageClicks.get(id);
        return ResponseEntity.ok(count != null ? count.get() : 0);
    }
}
