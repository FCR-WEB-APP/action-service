package com.example.Action.Dao;


import com.example.Action.Entity.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class QueryDao {
    private final JdbcTemplate jdbcTemplate1;

    public QueryDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }


    public int addQuery(Query query) {
        LocalDateTime date = LocalDateTime.now();
        String sql = "Insert Into Query (query_id,child_review_id,query_description,response,case_ref_no,assign_to,status,created_date,updated_date) values(?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate1.update(sql, query.getQueryId(), query.getChildId(), query.getQueryDescription(), query.getResponse(),query.getAssignTo(),query.getCaseRefNo(),query.getStatus(),date,date);
    }

    public int deleteQuery(Long queryId) {
        String sql = "DELETE FROM Query WHERE query_id = ?";
        return jdbcTemplate1.update(sql, queryId);
    }
}
