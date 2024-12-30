package com.example.Action.Controller;

import com.example.Action.Entity.Comments;
import com.example.Action.Service.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String,Object>> addComments(@RequestBody Comments comments){
        try{
            Map<String,Object> res = commentsService.addComments(comments);
            return new ResponseEntity<>(res, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("Message","somethings went wrong","Error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

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
