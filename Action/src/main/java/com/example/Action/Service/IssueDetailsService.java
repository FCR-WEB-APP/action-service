package com.example.Action.Service;

import com.example.Action.Dao.IssueDetailsDAO;
import com.example.Action.Entity.IssueDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IssueDetailsService {
    @Autowired
    private IssueDetailsDAO issueDetailsDAO;

    @Autowired
    private WebClient webClient;
    public int createIssueDetails(IssueDetails issueDetails) {
        return issueDetailsDAO.createIssueDetails(issueDetails);
    }



    public IssueDetails getIssueDetailsByIdFromQueryService(int issueId) {
        return webClient.get()
                .uri("/api/issue-details/{issueId}", issueId)
                .retrieve()
                .bodyToMono(IssueDetails.class)
                .block();
    }
}

