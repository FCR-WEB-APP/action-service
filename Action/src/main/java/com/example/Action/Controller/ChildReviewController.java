package com.example.Action.Controller;

import com.example.Action.Entity.ChildReview;
import com.example.Action.Service.ChildReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/childReview")
public class ChildReviewController {
    private final ChildReviewService childReviewService;

    public ChildReviewController(ChildReviewService childReviewService) {
        this.childReviewService = childReviewService;
    }

    @Operation(summary = "Add ChildReview",
            description = "Add ChildReview.")
    @ApiResponse(responseCode = "200", description = "Successfully Added ChildReview")
    @ApiResponse(responseCode = "400", description = " fail to added ChildReview")
    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('Sr.CreditReviewer', 'CreditReviewer')")
    public ChildReview addReview(@RequestBody ChildReview childReview) {
        return childReviewService.addReview(childReview);
    }
}