package com.hackathon.phishing_simulator.service;

import com.hackathon.phishing_simulator.repository.CampaignRepository;
import com.hackathon.phishing_simulator.repository.EmailTemplateRepository;
import com.hackathon.phishing_simulator.repository.LandingPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private EmailTemplateRepository emailTemplateRepository;
    @Autowired
    private LandingPageRepository landingPageRepository;

    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("campaignCount", campaignRepository.count());
        stats.put("templateCount", emailTemplateRepository.count());
        stats.put("landingPageCount", landingPageRepository.count());
        // Add more stats as needed
        return stats;
    }
}
