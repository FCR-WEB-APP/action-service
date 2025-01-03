package com.example.Action.Dao;

import com.example.Action.Entity.IssueDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class IssueDetailsDAO {
    private final JdbcTemplate jdbcTemplate1;

    public IssueDetailsDAO(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public IssueDetails getIssueDetailsById(int issueId) {
        String sql = "SELECT * FROM ISSUEDETAILS WHERE ISSUEID = ?";
        return jdbcTemplate1.queryForObject(sql, new Object[]{issueId}, (rs, rowNum) -> {
            IssueDetails issueDetails = new IssueDetails();
            issueDetails.setIssueId(rs.getInt("ISSUEID"));
            issueDetails.setStatus(rs.getString("STATUS"));
            issueDetails.setAction(rs.getString("ACTION"));
            issueDetails.setCreatedDate(rs.getTimestamp("CREATEDDATE"));
            issueDetails.setUpdatedDate(rs.getTimestamp("UPDATEDDATE"));
            return issueDetails;
        });
    }

    public int createIssueDetails(IssueDetails issueDetails) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        if (issueDetails.getCreatedDate() == null) {
            issueDetails.setCreatedDate(currentTimestamp);
        }
        if (issueDetails.getUpdatedDate() == null) {
            issueDetails.setUpdatedDate(currentTimestamp);
        }

        String sql = "INSERT INTO ISSUEDETAILS (ISSUEID, STATUS, ACTION, CREATEDDATE, UPDATEDDATE) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate1.update(sql,
                issueDetails.getIssueId(),
                issueDetails.getStatus(),
                issueDetails.getAction(),
                issueDetails.getCreatedDate(),
                issueDetails.getUpdatedDate());
    }
}
