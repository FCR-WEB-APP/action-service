package com.example.Action.Controller;

import com.example.Action.Entity.Comments;
import com.example.Action.Service.CommentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/comments")
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @Operation(summary = "Add Comments",
            description = "Add Comments.")
    @ApiResponse(responseCode = "200", description = "Successfully Added Comments")
    @ApiResponse(responseCode = "400", description = " fail to added Comments")
    @PostMapping("/add")
    public ResponseEntity<Map<String,Object>> addComments(@RequestBody Comments comments){
        try{
            Map<String,Object> res = commentsService.addComments(comments);
            return new ResponseEntity<>(res, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("Message","somethings went wrong","Error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "updateComments",
            description = "updateComments.")
    @ApiResponse(responseCode = "200", description = "Successfully updateComments")
    @ApiResponse(responseCode = "400", description = " fail to updateComments")
    @PutMapping("/update/{comment_Id}/{case_Ref_No}")
    public ResponseEntity<Map<String,Object>> updateComments
            (@PathVariable("comment_Id") Long commentId,@PathVariable("case_Ref_No")Long caseRefNo,@RequestBody Comments comments){

        try{
            Map<String,Object> res = commentsService.updateComments(commentId,caseRefNo,comments);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("Message","somethings went wrong","Error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "deleteComments",
            description = "deleteComments.")
    @ApiResponse(responseCode = "200", description = "Successfully deleteComments")
    @ApiResponse(responseCode = "400", description = " fail to deleteComments")
    @DeleteMapping("/delete/{comment_Id}/{case_Ref_No}")
    public ResponseEntity<Map<String,Object>> deleteComments
            (@PathVariable("comment_Id") Long commentId,@PathVariable("case_Ref_No")Long caseRefNo){

        try{
            Map<String,Object> res = commentsService.deleteComments(commentId,caseRefNo);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("Message","somethings went wrong","Error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

}
