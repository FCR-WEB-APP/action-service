package com.example.Action.Dao;

import com.example.Action.Entity.Obligour;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ObligourDao {
    private final JdbcTemplate jdbcTemplate1;

    public ObligourDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }


    public int addObligour(Obligour obligour) {
        String sql = "Insert Into Obligour (OBLIGOUR_ID,CASE_REF_NO,Division_Name,CIF_ID,PREM_ID,ACTION,IN_TIME,OUT_TIME) values(?,?,?,?,?,?,?,?)";
        return jdbcTemplate1.update(sql, obligour.getObligourId(), obligour.getCaseRefNo(), obligour.getDivisionName(), obligour.getCifId(), obligour.getPremId(), obligour.getAction(), obligour.getIn_Time(), obligour.getOut_Time());
    }
}