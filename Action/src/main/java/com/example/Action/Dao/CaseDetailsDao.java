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
       String sql = "INSERT INTO casedetails (case_ref_no,group_name, division_name, activity_level, status, assigned_to, created_date, updated_date,planing,field_work,actions)" +
               "VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
        jdbcTemplate1.update(sql,
                caseDetails.getCaseRefNo(),
                caseDetails.getGroupName(),
                caseDetails.getDivisionName(),
                caseDetails.getActivityLevel(),
                caseDetails.getStatus(),
                caseDetails.getAssignedTo(),
                date,
                date,caseDetails.getPlaning(),caseDetails.getFieldWork(),
                 caseDetails.getActions());
        return caseDetails;
    }


    public  CaseDetails updateCaseDetails(String case_ref_no, CaseDetails caseDetails) {
        LocalDateTime date = LocalDateTime.now();
        String sql = "UPDATE casedetails SET activity_level = ?, assigned_to = ?, status = ?, updated_date = ? WHERE case_ref_no = ?";
        jdbcTemplate1.update(sql,
                caseDetails.getActivityLevel(),
                caseDetails.getAssignedTo(),
                caseDetails.getStatus(),
                date,
                case_ref_no);

        CaseDetails caseDetails1 = new CaseDetails();
        caseDetails1.setCaseRefNo(case_ref_no);
        caseDetails1.setGroupName(caseDetails.getGroupName());
        caseDetails1.setDivisionName(caseDetails.getGroupName());
        caseDetails1.setActivityLevel(caseDetails.getActivityLevel());
        caseDetails1.setStatus(caseDetails.getStatus());
        caseDetails1.setAssignedTo(caseDetails.getAssignedTo());
        caseDetails1.setCreatedDate(date);
        caseDetails1.setUpdatedDate(date);
        caseDetails1.setPlaning(caseDetails.getPlaning());
        caseDetails1.setFieldWork(caseDetails.getFieldWork());
        caseDetails1.setActions(caseDetails.getActions());
        return caseDetails1;
    }

}