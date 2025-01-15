package com.example.Action.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
public class ChildReview {
    private Long obligourId;
    private Long childReviewId;
    private String assignedTo;
    private String caseRefNo;
    private String status;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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

    public Long getObligourId() {
        return obligourId;
    }

    public void setObligourId(Long obligourId) {
        this.obligourId = obligourId;
    }

    public Long getChildReviewId() {
        return childReviewId;
    }

    public void setChildReviewId(Long childReviewId) {
        this.childReviewId = childReviewId;
    }

}
