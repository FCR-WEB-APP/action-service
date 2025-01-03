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
        String sql = "Insert Into Query (Query_Id,Child_Id,Query_Description,Response,Case_Ref_No,Assign_To,Status,Created_Date,Updated_Date) values(?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate1.update(sql, query.getQueryId(), query.getChildId(), query.getQueryDescription(), query.getResponse(),query.getAssignTo(),query.getCaseRefNo(),query.getStatus(),date,date);
    }

    public int deleteQuery(Long queryId) {
        String sql = "DELETE FROM Query WHERE query_Id = ?";
        return jdbcTemplate1.update(sql, queryId);
    }
}
