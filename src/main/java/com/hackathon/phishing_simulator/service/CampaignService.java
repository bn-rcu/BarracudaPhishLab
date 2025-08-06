package com.hackathon.phishing_simulator.service;

import com.hackathon.phishing_simulator.entity.Campaign;
import com.hackathon.phishing_simulator.entity.EmailTemplate;
import com.hackathon.phishing_simulator.repository.CampaignRepository;
import com.hackathon.phishing_simulator.repository.EmailTemplateRepository;
import com.hackathon.phishing_simulator.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private EmailTemplateRepository emailTemplateRepository;
    @Autowired
    private MailService mailService;

    public Campaign createAndSend(Campaign campaign) {
        campaign.setCreatedDate(LocalDateTime.now());
        Campaign saved = campaignRepository.save(campaign);
        // Send emails
        EmailTemplate template = emailTemplateRepository.findById(campaign.getEmailTemplateId()).orElse(null);
        if (template != null) {
            String[] users = campaign.getTargetUsers().split(",");
            for (String user : users) {
                mailService.sendSampleMail(
                    new com.hackathon.phishing_simulator.dto.SampleMailRequestDTO(
                        user.trim(),
                        template.getSubject(),
                        template.getHtmlContent()
                    )
                );
            }
        }
        return saved;
    }
    public List<Campaign> getAll() {
        return campaignRepository.findAll();
    }
}
