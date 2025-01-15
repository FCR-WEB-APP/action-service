package com.example.Action.Dao;

import com.example.Action.Entity.ChildReview;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class ChildReviewDao {
private final JdbcTemplate jdbcTemplate1;

    public ChildReviewDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }


    public int addReview(ChildReview childReview) {
        LocalDateTime date = LocalDateTime.now();
        String sql = "Insert Into Child_Review (obligour_id,child_review_id,assign_to,case_ref_no,status,created_by,updated_by,created_date,updated_date) values(?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate1.update(sql, childReview.getObligourId(), childReview.getChildReviewId(), childReview.getAssignedTo(),childReview.getCaseRefNo(),childReview.getStatus(),childReview.getCreatedBy(),childReview.getUpdatedBy(),date,date);

    }
}