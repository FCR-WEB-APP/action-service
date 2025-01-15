package com.example.Action.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpocSubmitTask {
    private String caseRefNo;
    private Long obligourId;
    private Long issueId;
    private Long issueTrackId;
    private String status;
    private String actions;
    private String assignedTo;
    private String activityLevel;
    private LocalDateTime updatedDate;

    public String getCaseRefNo() {
        return caseRefNo;
    }

    public void setCaseRefNo(String caseRefNo) {
        this.caseRefNo = caseRefNo;
    }

    public Long getObligourId() {
        return obligourId;
    }

    public void setObligourId(Long obligourId) {
        this.obligourId = obligourId;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public Long getIssueTrackId() {
        return issueTrackId;
    }

    public void setIssueTrackId(Long issueTrackId) {
        this.issueTrackId = issueTrackId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
