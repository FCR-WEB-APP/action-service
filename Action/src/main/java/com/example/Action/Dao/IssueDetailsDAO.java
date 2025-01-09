package com.example.Action.Dao;

import com.example.Action.Entity.IssueDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository
public class IssueDetailsDAO {
    private final JdbcTemplate jdbcTemplate1;

    public IssueDetailsDAO(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public IssueDetails getIssueDetailsById(int issueId) {


        String sql = "SELECT * FROM ISSUEDETAILS WHERE issue_id = ?";
        return jdbcTemplate1.queryForObject(sql, new Object[]{issueId}, (rs, rowNum) -> {
            IssueDetails issueDetails = new IssueDetails();
            issueDetails.setIssueId(rs.getLong("issue_id"));
            issueDetails.setStatus(rs.getString("status"));
            issueDetails.setActions(rs.getString("actions"));
            Timestamp createdTimestamp = rs.getTimestamp("created_date");
            Timestamp updatedTimestamp = rs.getTimestamp("updated_date");

            if (createdTimestamp != null) {
                issueDetails.setCreatedDate(createdTimestamp.toLocalDateTime());
            }

            if (updatedTimestamp != null) {
                issueDetails.setUpdatedDate(updatedTimestamp.toLocalDateTime());
            }

            return issueDetails;
        });
    }

    public int createIssueDetails(IssueDetails issueDetails) {
        LocalDateTime dateTime = LocalDateTime.now();
        if (issueDetails.getCreatedDate() == null) {
            issueDetails.setCreatedDate(dateTime);
        }
        if (issueDetails.getUpdatedDate() == null) {
            issueDetails.setUpdatedDate(dateTime);
        }

        String sql = "INSERT INTO ISSUEDETAILS (issue_id, status, actions, created_date, updated_date) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate1.update(sql,
                issueDetails.getIssueId(),
                issueDetails.getStatus(),
                issueDetails.getActions(),
                issueDetails.getCreatedDate(),
                issueDetails.getUpdatedDate());
    }
}
