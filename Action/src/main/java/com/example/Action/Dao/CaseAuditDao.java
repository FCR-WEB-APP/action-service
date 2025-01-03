package com.example.Action.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CaseAuditDao {

    private final JdbcTemplate jdbcTemplate1;

    public CaseAuditDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }
    public List<Map<String, Object>> getAllCaseAudits() {
        String sql = "SELECT * FROM CaseAudit";
        return jdbcTemplate1.queryForList(sql);
    }

    public Map<String, Object> getCaseAuditByCaseRefNo(String caseRefNo) {
        String sql = "SELECT * FROM CaseAudit WHERE CaseRefNo = ?";
        return jdbcTemplate1.queryForMap(sql, caseRefNo);
    }
}

