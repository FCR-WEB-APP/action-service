package com.example.Action.Controller;

import com.example.Action.Entity.GroupAndDivision;
import com.example.Action.Service.GroupAndDivisionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/GroupAndDivison")
public class GroupAndDivisionController {

    private final GroupAndDivisionService groupAndDivisionService;

    public GroupAndDivisionController(GroupAndDivisionService groupAndDivisionService) {
        this.groupAndDivisionService = groupAndDivisionService;
    }

    @Operation(summary = "AddGroupAndDivision",
            description = "AddGroupAndDivision.")
    @ApiResponse(responseCode = "200", description = "Successfully AddGroupAndDivision")
    @ApiResponse(responseCode = "400", description = " fail to AddGroupAndDivision")
    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('Sr.CreditReviewer', 'CreditReviewer')")
    public ResponseEntity<Map<String, Object>> addGpAndDv(@RequestBody GroupAndDivision groupAndDivision) {
        try {
            Map<String, Object> res = groupAndDivisionService.addGpAndDv(groupAndDivision);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "deletebyGroupname",
            description = "deletebyGroupname.")
    @ApiResponse(responseCode = "200", description = "Successfully deletebyGroupname")
    @ApiResponse(responseCode = "400", description = " fail to deletebyGroupname")
    @DeleteMapping("/delete/groupname/{groupname}")
    @PreAuthorize("hasAnyAuthority('Sr.CreditReviewer', 'CreditReviewer')")
    public ResponseEntity<Map<String, Object>> deletebyGroupname(@PathVariable("groupname") String groupname) {
        try {
            Map<String, Object> res = groupAndDivisionService.deletebyGroupname(groupname);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to delete", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "deletebyDivisionname",
            description = "deletebyDivisionname.")
    @ApiResponse(responseCode = "200", description = "Successfully deletebyDivisionname")
    @ApiResponse(responseCode = "400", description = " fail to deletebyDivisionname")
    @DeleteMapping("/delete/divisionname/{divisionname}")
    @PreAuthorize("hasAnyAuthority('Sr.CreditReviewer', 'CreditReviewer')")
    public ResponseEntity<Map<String, Object>> deletebyDivisionname(@PathVariable("divisionname") String divisionName) {
        try {
            Map<String, Object> res = groupAndDivisionService.deletebyDivisionname(divisionName);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to delete", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "deletebySpocname",
            description = "deletebySpocname.")
    @ApiResponse(responseCode = "200", description = "Successfully deletebySpocname")
    @ApiResponse(responseCode = "400", description = " fail to deletebySpocname")
    @DeleteMapping("/delete/spocname/{spocname}")
    @PreAuthorize("hasAnyAuthority('Sr.CreditReviewer', 'CreditReviewer')")
    public ResponseEntity<Map<String, Object>> deletebySpocname(@PathVariable("spocname") String spocName) {
        try {
            Map<String, Object> res = groupAndDivisionService.deletebySpocname(spocName);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to delete", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "updateGroupAndDivision",
            description = "updateGroupAndDivision.")
    @ApiResponse(responseCode = "200", description = "Successfully updateGroupAndDivision")
    @ApiResponse(responseCode = "400", description = " fail to updateGroupAndDivision")
    @PutMapping("/update/{sequenceId}")
    @PreAuthorize("hasAnyAuthority('Sr.CreditReviewer', 'CreditReviewer','Spoc','HeadOfFcr')")
    public ResponseEntity<Map<String ,Object>> updateGroupAndDivision(@PathVariable("sequenceId") Long sequenceId, @RequestBody GroupAndDivision groupAndDivision){
        try{
            Map<String,Object> res = groupAndDivisionService.updateGroupAndDivision(sequenceId,groupAndDivision);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



}

