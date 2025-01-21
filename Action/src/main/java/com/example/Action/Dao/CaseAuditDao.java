package com.example.Action.Dao;

import com.example.Action.Entity.CaseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public class CaseAuditDao {

    private final JdbcTemplate jdbcTemplate1;

    public CaseAuditDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public void addCaseAudit(CaseDetails caseDetails,String username) {

        String sql = "insert into case_audit (case_ref_no,actions,created_by,updated_by,action_by,activity_level) values (?,?,?,?,?,?)";

        jdbcTemplate1.update(sql,caseDetails.getCaseRefNo(),caseDetails.getActions(),username,username,username,caseDetails.getActivityLevel());
    }
}

