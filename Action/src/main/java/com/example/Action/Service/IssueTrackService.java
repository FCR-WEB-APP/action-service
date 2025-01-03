package com.example.Action.Service;

import com.example.Action.Dao.IssueTrackDAO;
import com.example.Action.Entity.IssueTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueTrackService {

    @Autowired
    private IssueTrackDAO issueTrackDAO;

    @Autowired
    private IssueDetailsService issueDetailsService;

    public void createIssueTrack(IssueTrack issueTrack, int issueId) {
        // Ensure the TRACKISSUEID is generated/set properly before insertion
        int trackIssueId = generateTrackIssueId(); // You can implement this method

        issueTrack.setTrackIssueId(trackIssueId); // Set the generated ID

        // Set the issueId and other necessary fields
        issueTrack.setIssueId(issueId);

        // Additional setup for issueTrack
        issueTrack.setIssueDescription("Description...");
        issueTrack.setCaseRefNo("CASE12345");

        // Call DAO to persist the IssueTrack
        issueTrackDAO.createIssueTrack(issueTrack);
    }

    private int generateTrackIssueId() {
        // Example method to generate the TRACKISSUEID (e.g., using a sequence or fetching the max ID)
        // You can use a database sequence or other logic to generate the ID
        return 1000; // Replace this with actual generation logic
    }

}
