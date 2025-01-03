package com.example.Action.Controller;

import com.example.Action.Entity.CaseDetails;
import com.example.Action.Service.CaseDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CaseDetailsController {

    private final CaseDetailsService caseDetailsService;

    public CaseDetailsController(CaseDetailsService caseDetailsService) {
        this.caseDetailsService = caseDetailsService;
    }

    @PostMapping("/addcasedetails")
    public ResponseEntity<Map<String,Object>> addcasedetails(@RequestBody CaseDetails caseDetails){
        try{
            Map<String,Object> res = caseDetailsService.addcasedetails(caseDetails);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/update/{case_ref_no}")
    public ResponseEntity<Map<String,Object>> updateCaseDetails(
            @PathVariable("case_ref_no") Long case_ref_no,
            @RequestBody CaseDetails caseDetails) {
        try{
               Map<String,Object> res = caseDetailsService.updateCaseDetails(case_ref_no, caseDetails);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
