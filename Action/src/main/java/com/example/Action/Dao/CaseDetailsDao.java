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
        String sql = "insert into casedetails(groupname,divisionname,primeid,activitylevel,status,assignedto,createdDate,updatedDate) values (?,?,?,?,?,?,?,?)";
        jdbcTemplate1.update(sql,
                caseDetails.getGroupName(),
                caseDetails.getDivisionName(),
                caseDetails.getPrimeId(),
                caseDetails.getActivityLevel(),
                caseDetails.getStatus(),
                caseDetails.getAssignedTo(),
                date,
                date);
        return caseDetails;
    }


    public  CaseDetails updateCaseDetails(int case_ref_no, CaseDetails caseDetails) {
        LocalDateTime date = LocalDateTime.now();
        String sql = "UPDATE casedetails SET activitylevel = ?, assignedto = ?, status = ?, updatedDate = ? WHERE case_ref_no = ?";
        jdbcTemplate1.update(sql,
                caseDetails.getActivityLevel(),
                caseDetails.getAssignedTo(),
                caseDetails.getStatus(),
                date,
                case_ref_no);
        return caseDetails;
    }

}