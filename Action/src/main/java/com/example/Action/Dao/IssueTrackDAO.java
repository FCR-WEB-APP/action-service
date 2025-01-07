package com.example.Action.Dao;

import com.example.Action.Entity.IssueTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IssueTrackDAO {
    private final JdbcTemplate jdbcTemplate1;

    public IssueTrackDAO(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public int createIssueTrack(IssueTrack issueTrack) {
        String sql = "INSERT INTO ISSUETRACK (TRACKISSUEID, ISSUEID, ISSUEDESCRIPTION, CASEREFNO, STATUS, ACTIVELEVEL, ACTION, CREATEDDATE, UPDATEDDATE, ASSIGNEDTO, RESPONSEWRS, RMSRESPONSE) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate1.update(sql,
                issueTrack.getIssueId(),
                issueTrack.getTrackIssueId(),
                issueTrack.getIssueDescription(),
                issueTrack.getCaseRefNo(),
                issueTrack.getStatus(),
                issueTrack.getActiveLevel(),
                issueTrack.getAction(),
                issueTrack.getCreatedDate(),
                issueTrack.getUpdatedDate(),
                issueTrack.getAssignedTo(),
                issueTrack.getResponseWRS(),
                issueTrack.getRmsResponse());
    }

}

