package com.example.Action.Dao;

import com.example.Action.Dto.SpocSubmitCRTask;
import com.example.Action.Dto.SpocSubmitTask;
import com.example.Action.Dto.SubmitTaskLeader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class SubmitTaskLeaderDao {

    private final JdbcTemplate jdbcTemplate1;

    public SubmitTaskLeaderDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public SubmitTaskLeader submitTaskLeader(SubmitTaskLeader submitTaskLeader) {
        LocalDateTime date = LocalDateTime.now();
        String sql = "update casedetails set case_ref_no = ? ,status = ?,actions = ?,assigned_to= ?,activity_level = ? ,updated_date = ? ,planing = ? , field_work = ? where case_ref_no = ?";

        // Handle "approve" action
        if ((submitTaskLeader.getAssignedTo() == null || submitTaskLeader.getAssignedTo().isEmpty()) && StringUtils.equalsIgnoreCase(submitTaskLeader.getActions(), "approve")) {
            jdbcTemplate1.update(sql, submitTaskLeader.getCaseRefNo(),
                    submitTaskLeader.getStatus(), submitTaskLeader.getActions(), submitTaskLeader.getAssignedTo(),
                    submitTaskLeader.getActivityLevel(), date, "Complete",
                    submitTaskLeader.getFieldWork(),
                    submitTaskLeader.getCaseRefNo());
        }
        // Handle "reject" action
        else if ((submitTaskLeader.getAssignedTo() == null || submitTaskLeader.getAssignedTo().isEmpty()) && StringUtils.equalsIgnoreCase(submitTaskLeader.getActions(), "reject")) {
            jdbcTemplate1.update(sql, submitTaskLeader.getCaseRefNo(),
                    submitTaskLeader.getStatus(), submitTaskLeader.getActions(), submitTaskLeader.getAssignedTo(),
                    submitTaskLeader.getActivityLevel(), date, "InProgress",
                    submitTaskLeader.getFieldWork(),
                    submitTaskLeader.getCaseRefNo());
        }
        // Handle case where "assignedTo" is empty or null
        else if (submitTaskLeader.getAssignedTo() == null || submitTaskLeader.getAssignedTo().isEmpty()) {
            jdbcTemplate1.update(sql, submitTaskLeader.getCaseRefNo(),
                    submitTaskLeader.getStatus(), submitTaskLeader.getActions(), submitTaskLeader.getAssignedTo(),
                    submitTaskLeader.getActivityLevel(), date, submitTaskLeader.getPlaning(),
                    submitTaskLeader.getFieldWork(), submitTaskLeader.getCaseRefNo());
        }
        // Handle case where "assignedTo" is not empty
        else if (submitTaskLeader.getAssignedTo() != null && !submitTaskLeader.getAssignedTo().isEmpty()) {
            jdbcTemplate1.update(sql, submitTaskLeader.getCaseRefNo(),
                    submitTaskLeader.getStatus(), submitTaskLeader.getActions(), submitTaskLeader.getAssignedTo(),
                    submitTaskLeader.getActivityLevel(), date, submitTaskLeader.getPlaning(),
                    submitTaskLeader.getFieldWork(), submitTaskLeader.getCaseRefNo());
        }

        return submitTaskLeader;
    }

    public SpocSubmitTask submitTaskSpoc(SpocSubmitTask spocSubmitTask) {
        LocalDateTime date = LocalDateTime.now();
        if (spocSubmitTask.getObligourId() != null) {
            String sql = "UPDATE obligour SET case_ref_no = ?, status = ?, actions = ?, assigned_to = ?, activity_level = ?, obligour_id = ?, updated_date = ? WHERE case_ref_no = ?";
            jdbcTemplate1.update(sql,
                    spocSubmitTask.getCaseRefNo(),
                    spocSubmitTask.getStatus(),
                    spocSubmitTask.getActions(),
                    spocSubmitTask.getAssignedTo(),
                    spocSubmitTask.getActivityLevel(),
                    spocSubmitTask.getObligourId(),
                    date,
                    spocSubmitTask.getCaseRefNo());
        } else if (spocSubmitTask.getIssueId() != null) {
            String sql = "UPDATE issuedetails SET case_ref_no = ?, status = ?, actions = ?, assigned_to = ?, activity_level = ?, issue_id = ?, updated_date = ? WHERE case_ref_no = ?";
            jdbcTemplate1.update(sql,
                    spocSubmitTask.getCaseRefNo(),
                    spocSubmitTask.getStatus(),
                    spocSubmitTask.getActions(),
                    spocSubmitTask.getAssignedTo(),
                    spocSubmitTask.getActivityLevel(),
                    spocSubmitTask.getIssueId(),
                    date,
                    spocSubmitTask.getCaseRefNo());

            String sql2 = "UPDATE issuetrack SET track_issue_id = ?, updated_date = ? WHERE case_ref_no = ? AND issue_id = ?";
            jdbcTemplate1.update(sql2,
                    spocSubmitTask.getIssueTrackId(),
                    date,
                    spocSubmitTask.getCaseRefNo(),
                    spocSubmitTask.getIssueId());
        }
        return spocSubmitTask;
    }

    public SpocSubmitCRTask spocSubmitCRTask(SpocSubmitCRTask spocSubmitCRTask) {

    }
}
