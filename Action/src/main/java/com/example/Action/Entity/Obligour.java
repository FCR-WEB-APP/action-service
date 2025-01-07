package com.example.Action.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Obligour {

        private Long obligourId;
        private Long caseRefNo;
        private String divisionName;
        private Long cifId;
        private Long premId;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;
        private String assignTo;
        private String status;

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
    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getObligourId() {
        return obligourId;
    }

    public void setObligourId(Long obligourId) {
        this.obligourId = obligourId;
    }

    public Long getCaseRefNo() {
        return caseRefNo;
    }

    public void setCaseRefNo(Long caseRefNo) {
        this.caseRefNo = caseRefNo;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Long getCifId() {
        return cifId;
    }

    public void setCifId(Long cifId) {
        this.cifId = cifId;
    }

    public Long getPremId() {
        return premId;
    }

    public void setPremId(Long premId) {
        this.premId = premId;
    }


}
