package com.example.Action.Dao;

import com.example.Action.Entity.Comments;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class CommentsDao {

    private final JdbcTemplate jdbcTemplate1;

    public CommentsDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public Comments addComments(Comments comments) {
        LocalDateTime date = LocalDateTime.now();
        String sql = "insert into comments (case_Ref_No,comments,commented_By,actions,created_Date,updated_Date)Values(?,?,?,?,?,?)";
        jdbcTemplate1.update(sql,comments.getCaseRefNo(),comments.getComments(),
                              comments.getCommentedBy(),comments.getActions(),date,date);
        return comments;

    }

    public Comments updateComments(Long commentId, Long caseRefNo,Comments comments) {
        LocalDateTime date = LocalDateTime.now();
        String sql = "update comments SET comments = ? ,commented_By = ?,actions = ?,updated_Date = ? where comment_Id = ? And case_Ref_No = ?";
        jdbcTemplate1.update(sql,comments.getComments(),comments.getCommentedBy(),comments.getActions(),
                date,commentId,caseRefNo);
        return  comments;

    }

    public String deleteComments(Long commentId, Long caseRefNo) {
        String sql = "delete from comments where comment_Id = ? And case_Ref_No = ?";
        jdbcTemplate1.update(sql,commentId,caseRefNo);
        return "successfully deleted";
    }
}
