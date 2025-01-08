package com.example.Action.Dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UrlStoreDao {

    private final JdbcTemplate jdbcTemplate1;

    public UrlStoreDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }


    public void saveApiUrl(String url, String httpMethod) {
        String sql = "INSERT INTO urlstore (api_url, api_method) VALUES (?, ?)";
        jdbcTemplate1.update(sql, url, httpMethod);
    }
}
