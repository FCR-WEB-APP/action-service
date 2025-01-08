package com.example.Action.Service;

import com.example.Action.Dao.CommentsDao;
import com.example.Action.Entity.Comments;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommentsService {

    private final CommentsDao commentsDao;

    public CommentsService(CommentsDao commentsDao) {
        this.commentsDao = commentsDao;
    }


    public Map<String, Object> addComments(Comments comments) {
        Comments comments1 = commentsDao.addComments(comments);
        return Map.of(
                "status", HttpStatus.CREATED.value(),
                "message","successfully created",
                "data",comments1
        );
    }

    public Map<String, Object> updateComments(Long commentId, String caseRefNo,Comments comments) {
        Comments comments1 = commentsDao.updateComments(commentId,caseRefNo,comments);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "message","successfully updated",
                "data",comments1
        );
    }

    public Map<String, Object> deleteComments(Long commentId, String caseRefNo) {
        String res = commentsDao.deleteComments(commentId,caseRefNo);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "message","successfully deleted",
                "data",res
        );

    }
}
