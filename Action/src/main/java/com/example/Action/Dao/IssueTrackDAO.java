package com.example.Action.Dao;

import com.example.Action.Entity.IssueDetails;
import com.example.Action.Entity.IssueTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class IssueTrackDAO {
    private final JdbcTemplate jdbcTemplate1;

    public IssueTrackDAO(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public int createIssueTrack(IssueTrack issueTrack) {
        LocalDate date = LocalDate.now();
        String sql = "INSERT INTO issuetrack (track_issue_id, issue_id, case_ref_no, issue_description, status, activity_level, actions, created_date, updated_date, assigned_to, wrs_response, rms_response) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate1.update(sql,
                issueTrack.getTrackIssueId(),
                issueTrack.getIssueId(),
                issueTrack.getCaseRefNo(),
                issueTrack.getIssueDescription(),
                issueTrack.getStatus(),
                issueTrack.getActivityLevel(),
                issueTrack.getActions(),
                date,date,
                issueTrack.getAssignedTo(),
                issueTrack.getWrsResponse(),
                issueTrack.getRmsResponse());
    }

}

