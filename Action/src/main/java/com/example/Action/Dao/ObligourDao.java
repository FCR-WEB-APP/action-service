package com.example.Action.Dao;

import com.example.Action.Entity.Obligour;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


@Repository
public class ObligourDao {
    private final JdbcTemplate jdbcTemplate1;

    public ObligourDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public int addObligour(Obligour obligour) {
        LocalDateTime date = LocalDateTime.now();
        String sql = "Insert Into Obligour (obligour_id,case_ref_no,division_name,cif_id,prem_id,created_date,updated_date,assigned_to,status,activity_level,actions) values(?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate1.update(sql, obligour.getObligourId(), obligour.getCaseRefNo(), obligour.getDivisionName(), obligour.getCifId(), obligour.getPremId(), date,date,obligour.getAssignedTo(),obligour.getStatus(),obligour.getActivityLevel(),obligour.getActions());

    }
}