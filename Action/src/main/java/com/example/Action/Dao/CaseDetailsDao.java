package com.example.Action.Dao;

import com.example.Action.Configuration.JdbcTemplateConfig;
import com.example.Action.Entity.CaseDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class CaseDetailsDao {

    private final JdbcTemplate jdbcTemplate1;

    public CaseDetailsDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }


    public CaseDetails addcasedetails(CaseDetails caseDetails) {
        LocalDateTime date = LocalDateTime.now();
       String sql = "INSERT INTO casedetails (group_Name, division_Name, activity_level, status, assigned_To, created_Date, updated_Date,planing,field_Work)" +
               "VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
        jdbcTemplate1.update(sql,
                caseDetails.getGroupName(),
                caseDetails.getDivisionName(),
                caseDetails.getActivityLevel(),
                caseDetails.getStatus(),
                caseDetails.getAssignedTo(),
                date,
                date,caseDetails.getPlaning(),caseDetails.getFieldWork());
        return caseDetails;
    }


    public  CaseDetails updateCaseDetails(Long case_ref_no, CaseDetails caseDetails) {
        LocalDateTime date = LocalDateTime.now();
        String sql = "UPDATE casedetails SET activity_Level = ?, assigned_To = ?, status = ?, updated_Date = ? WHERE case_Ref_No = ?";
        jdbcTemplate1.update(sql,
                caseDetails.getActivityLevel(),
                caseDetails.getAssignedTo(),
                caseDetails.getStatus(),
                date,
                case_ref_no);

        CaseDetails caseDetails1 = new CaseDetails();
        caseDetails1.setCaseRefNo(case_ref_no);
      //  caseDetails1.setGroupName(caseDetails.getGroupName());
       // caseDetails1.setDivisionName(caseDetails.getGroupName());
        caseDetails1.setActivityLevel(caseDetails.getActivityLevel());
        caseDetails1.setStatus(caseDetails.getStatus());
        caseDetails1.setAssignedTo(caseDetails.getAssignedTo());
        caseDetails1.setCreatedDate(date);
        caseDetails1.setUpdatedDate(date);
        caseDetails1.setPlaning(caseDetails.getPlaning());
        caseDetails1.setFieldWork(caseDetails.getFieldWork());
        return caseDetails1;
    }

}