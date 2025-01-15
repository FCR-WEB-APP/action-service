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
public class SubmitTaskLeader {

    private String caseRefNo;
    private String status;
    private String actions;
    private String assignedTo;
    private String activityLevel;
    private LocalDateTime updatedDate;
    private String fieldWork;
    private String planing;

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

    public String getFieldWork() {
        return fieldWork;
    }

    public void setFieldWork(String fieldWork) {
        this.fieldWork = fieldWork;
    }

    public String getPlaning() {
        return planing;
    }

    public void setPlaning(String planing) {
        this.planing = planing;
    }
}
