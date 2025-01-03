package com.example.Action.Service;

import com.example.Action.Dao.ChildReviewDao;
import com.example.Action.Entity.ChildReview;
import org.springframework.stereotype.Service;

@Service
public class ChildReviewService {

    private final ChildReviewDao childReviewDao;

    public ChildReviewService(ChildReviewDao childReviewDao){
        this.childReviewDao=childReviewDao;
    }
    public ChildReview addReview(ChildReview childReview) {
        int rows = childReviewDao.addReview(childReview);
        if (rows > 0) {
            return childReview;
        } else {
            throw new RuntimeException("Failed to Add Child Review");        }
    }


}