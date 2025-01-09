package com.example.Action.Entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class IssueTrack {

    private Long trackIssueId;

        private Long issueId;  // Use only the issueId instead of the entire IssueDetails object

    private String caseRefNo;

    private String issueDescription;

    private String status;

    private String activityLevel;

    private String actions;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String assignedTo;

    private String wrsResponse;

    private String rmsResponse;

    // Getters and Setters


    public Long getTrackIssueId() {
        return trackIssueId;
    }

    public void setTrackIssueId(Long trackIssueId) {
        this.trackIssueId = trackIssueId;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getCaseRefNo() {
        return caseRefNo;
    }

    public void setCaseRefNo(String caseRefNo) {
        this.caseRefNo = caseRefNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getWrsResponse() {
        return wrsResponse;
    }

    public void setWrsResponse(String wrsResponse) {
        this.wrsResponse = wrsResponse;
    }

    public String getRmsResponse() {
        return rmsResponse;
    }

    public void setRmsResponse(String rmsResponse) {
        this.rmsResponse = rmsResponse;
    }
}
