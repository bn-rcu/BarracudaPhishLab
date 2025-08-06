package com.hackathon.phishing_simulator.repository;

import com.hackathon.phishing_simulator.entity.LandingPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandingPageRepository extends JpaRepository<LandingPage, Long> {
}
