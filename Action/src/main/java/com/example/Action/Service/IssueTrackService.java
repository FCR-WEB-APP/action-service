package com.example.Action.Service;

import com.example.Action.Dao.IssueTrackDAO;
import com.example.Action.Entity.IssueDetails;
import com.example.Action.Entity.IssueTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueTrackService {

    @Autowired
    private IssueTrackDAO issueTrackDAO;

    @Autowired
    private IssueDetailsService issueDetailsService;

    public void createIssueTrack(IssueTrack issueTrack) {

        issueTrackDAO.createIssueTrack(issueTrack);
    }


}
