package com.example.Action.Controller;

import com.example.Action.Entity.ChildReview;
import com.example.Action.Service.ChildReviewService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/childReview")
public class ChildReviewController {
    private final ChildReviewService childReviewService;

    public ChildReviewController(ChildReviewService childReviewService) {
        this.childReviewService = childReviewService;
    }

    @PostMapping("/add")
    public ChildReview addReview(@RequestBody ChildReview childReview) {
        return childReviewService.addReview(childReview);
    }
}