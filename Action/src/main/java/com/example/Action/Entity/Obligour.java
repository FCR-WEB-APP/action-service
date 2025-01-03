package com.example.Action.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Obligour {

        private Long obligourId;
        private Long caseRefNo;
        private String divisionName;
        private Long cifId;
        private Long premId;
        private String action ;
        private Date in_Time;
        private Date out_Time;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getIn_Time() {
        return in_Time;
    }

    public void setIn_Time(Date in_Time) {
        this.in_Time = in_Time;
    }

    public Date getOut_Time() {
        return out_Time;
    }

    public void setOut_Time(Date out_Time) {
        this.out_Time = out_Time;
    }
}
