package com.hackathon.phishing_simulator.repository;

import com.hackathon.phishing_simulator.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
