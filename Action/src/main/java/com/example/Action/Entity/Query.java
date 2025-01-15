package com.example.Action.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class Query {
    private Long queryId;
    private Long childReviewId;
    private String caseRefNo;
    private String assignedTo;
    private String status;
    private String queryDescription;
    private String response;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

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

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }



    public String getQueryDescription() {
        return queryDescription;
    }

    public void setQueryDescription(String queryDescription) {
        this.queryDescription = queryDescription;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Long getChildReviewId() {
        return childReviewId;
    }

    public void setChildReviewId(Long childReviewId) {
        this.childReviewId = childReviewId;
    }
}
