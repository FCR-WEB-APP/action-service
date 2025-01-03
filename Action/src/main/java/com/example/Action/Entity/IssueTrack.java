package com.example.Action.Entity;

import java.sql.Timestamp;

public class IssueTrack {

    private int trackIssueId;

    private int issueId;  // Use only the issueId instead of the entire IssueDetails object

    private String issueDescription;

    private String caseRefNo;

    private String status;

    private int activeLevel;

    private String action;

    private Timestamp createdDate;

    private Timestamp updatedDate;

    private String assignedTo;

    private String responseWRS;

    private String rmsResponse;

    // Getters and Setters

    public int getActiveLevel() {
        return activeLevel;
    }

    public void setActiveLevel(int activeLevel) {
        this.activeLevel = activeLevel;
    }

    public int getTrackIssueId() {
        return trackIssueId;
    }

    public void setTrackIssueId(int trackIssueId) {
        this.trackIssueId = trackIssueId;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getResponseWRS() {
        return responseWRS;
    }

    public void setResponseWRS(String responseWRS) {
        this.responseWRS = responseWRS;
    }

    public String getRmsResponse() {
        return rmsResponse;
    }

    public void setRmsResponse(String rmsResponse) {
        this.rmsResponse = rmsResponse;
    }

}
