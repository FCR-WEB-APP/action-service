package com.example.Action.Controller;

import com.example.Action.Entity.CaseDetails;
//import com.example.Action.ExternalService.ValidTokenWebClient;
import com.example.Action.Service.CaseDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class CaseDetailsController {

    private final CaseDetailsService caseDetailsService;

    public CaseDetailsController(CaseDetailsService caseDetailsService) {
        this.caseDetailsService = caseDetailsService;

    }

    @Operation(summary = "Add CaseDetails",
            description = "Add caseDetails.")
    @ApiResponse(responseCode = "200", description = "Successfully Added CaseDetails")
    @ApiResponse(responseCode = "400", description = " fail to add")
    @PostMapping("/addcasedetails")
    @PreAuthorize("hasAnyAuthority('Sr.CreditReviewer', 'CreditReviewer')")
    public ResponseEntity<Map<String,Object>> addcasedetails(@RequestBody CaseDetails caseDetails ){
        try{
            Map<String,Object> res = caseDetailsService.addcasedetails(caseDetails);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @Operation(summary = "update CaseDetails",
            description = "update caseDetails.")
    @ApiResponse(responseCode = "200", description = "Successfully update CseDetails")
    @ApiResponse(responseCode = "400", description = " fail to update")
    @PutMapping("/update/{case_ref_no}")
    @PreAuthorize("hasAnyAuthority('Sr.CreditReviewer', 'CreditReviewer','Spoc','HeadOfFcr')")
    public ResponseEntity<Map<String,Object>> updateCaseDetails(
            @PathVariable("case_ref_no") String case_ref_no,
            @RequestBody CaseDetails caseDetails) {
        try{
               Map<String,Object> res = caseDetailsService.updateCaseDetails(case_ref_no, caseDetails);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
