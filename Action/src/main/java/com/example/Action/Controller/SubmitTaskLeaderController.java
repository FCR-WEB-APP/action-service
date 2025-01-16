package com.example.Action.Controller;

import com.example.Action.Dto.SpocSubmitCRTask;
import com.example.Action.Dto.SpocSubmitTask;
import com.example.Action.Dto.SubmitTaskLeader;
import com.example.Action.Service.SubmitTaskLeaderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SubmitTaskLeaderController {

    private final SubmitTaskLeaderService submitTaskLeaderService;

    public SubmitTaskLeaderController(SubmitTaskLeaderService submitTaskLeaderService) {
        this.submitTaskLeaderService = submitTaskLeaderService;
    }

    @PostMapping("/SubmitTaskLeader")
    public ResponseEntity<Map<String,Object>>submitTaskLeader(@RequestBody SubmitTaskLeader submitTaskLeader){
        try{
            Map<String,Object> res = submitTaskLeaderService.submitTaskLeader(submitTaskLeader);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message","unable to submit","error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/ScrToCR")
    public ResponseEntity<Map<String,Object>>submitTaskSpoc(@RequestBody SpocSubmitTask spocSubmitTask){
        try{
            Map<String,Object> res = submitTaskLeaderService.submitTaskSpoc(spocSubmitTask);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message","unable to submit","error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/SpocSubmitCRTask")
    public ResponseEntity<Map<String,Object>>spocSubmitCRTask(@RequestBody SpocSubmitCRTask spocSubmitCRTask){
        try{
            Map<String,Object> res = submitTaskLeaderService.spocSubmitCRTask(spocSubmitCRTask);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message","unable to submit","error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }


}
