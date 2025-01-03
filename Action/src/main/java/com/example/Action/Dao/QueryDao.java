package com.example.Action.Dao;


import com.example.Action.Entity.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QueryDao {
    private final JdbcTemplate jdbcTemplate1;

    public QueryDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }


    public int addQuery(Query query) {
        String sql = "Insert Into Query (Query_Id,Child_Id,Query_Description,Response) values(?,?,?,?)";
        return jdbcTemplate1.update(sql, query.getQueryId(), query.getChildId(), query.getQueryDescription(), query.getResponse());
    }

    public int deleteQuery(Long queryId) {
        String sql = "DELETE FROM Query WHERE query_Id = ?";
        return jdbcTemplate1.update(sql, queryId);
    }
}
