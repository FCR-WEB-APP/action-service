package com.example.Action.Controller;

import com.example.Action.Entity.IssueDetails;
import com.example.Action.Service.IssueDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/issue-details")
public class IssueDetailsController {
    @Autowired
    private IssueDetailsService issueDetailsService;

    @PostMapping
    public ResponseEntity<String> createIssueDetails(@RequestBody IssueDetails issueDetails) {
        int rowsInserted = issueDetailsService.createIssueDetails(issueDetails);
        return new ResponseEntity<>(rowsInserted > 0 ? "IssueDetails created successfully" : "Failed to create IssueDetails", HttpStatus.OK);
    }
}
