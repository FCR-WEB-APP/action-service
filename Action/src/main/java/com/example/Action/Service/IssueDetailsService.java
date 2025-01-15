package com.example.Action.Service;

import com.example.Action.Dao.IssueDetailsDAO;
import com.example.Action.Entity.IssueDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class IssueDetailsService {
    @Autowired
    private IssueDetailsDAO issueDetailsDAO;

    @Autowired

    @Qualifier("queryServiceWebClient")
    private WebClient webClient;

    public int createIssueDetails(IssueDetails issueDetails) {
        return issueDetailsDAO.createIssueDetails(issueDetails);
    }

    public IssueDetails getIssueDetailsByIdFromQueryService(Long issueId) {
        System.out.println("12345");
        return webClient.get()
                .uri("http://localhost:1001/api/issue-details/{issueId}", issueId)  // Using placeholder for path variable
                .retrieve()
                .bodyToMono(IssueDetails.class)
                .block();
    }


}

