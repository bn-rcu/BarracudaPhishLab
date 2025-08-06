package com.hackathon.phishing_simulator.controller;

import com.hackathon.phishing_simulator.entity.Campaign;
import com.hackathon.phishing_simulator.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping
    public Campaign create(@RequestBody Campaign campaign) {
        return campaignService.createAndSend(campaign);
    }

    @GetMapping
    public List<Campaign> getAll() {
        return campaignService.getAll();
    }
}
