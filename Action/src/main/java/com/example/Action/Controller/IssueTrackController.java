package com.example.Action.Controller;

import com.example.Action.Entity.IssueDetails;
import com.example.Action.Entity.IssueTrack;
import com.example.Action.Service.IssueDetailsService;
import com.example.Action.Service.IssueTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/issue-track")
public class IssueTrackController {
    @Autowired
    private IssueTrackService issueTrackService;

    @Autowired
    private IssueDetailsService issueDetailsService;


    @PostMapping("/create")
    public ResponseEntity<String> createIssueTrack(@RequestBody IssueTrack issueTrack) {
        // Fetch IssueDetails from Query Service using WebClient
        //IssueDetails issueDetails = issueDetailsService.getIssueDetailsByIdFromQueryService(issueId);

//        if (issueDetails == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Issue ID does not exist in Query Service");
//        }

        issueTrackService.createIssueTrack(issueTrack);
        return ResponseEntity.ok("IssueTrack Created Successfully");
    }


}

