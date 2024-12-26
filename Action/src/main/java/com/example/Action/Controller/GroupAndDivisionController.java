package com.example.Action.Controller;

import com.example.Action.Entity.GroupAndDivision;
import com.example.Action.Service.GroupAndDivisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/GroupAndDivison")
public class GroupAndDivisionController {

    private final GroupAndDivisionService groupAndDivisionService;

    public GroupAndDivisionController(GroupAndDivisionService groupAndDivisionService) {
        this.groupAndDivisionService = groupAndDivisionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addGpAndDv(@RequestBody GroupAndDivision groupAndDivision) {
        try {
            Map<String, Object> res = groupAndDivisionService.addGpAndDv(groupAndDivision);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/groupname/{groupname}")
    public ResponseEntity<Map<String, Object>> deletebyGroupname(@PathVariable("groupname") String groupname) {
        try {
            Map<String, Object> res = groupAndDivisionService.deletebyGroupname(groupname);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to delete", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/divisionname/{divisionname}")
    public ResponseEntity<Map<String, Object>> deletebyDivisionname(@PathVariable("divisionname") String divisionName) {
        try {
            Map<String, Object> res = groupAndDivisionService.deletebyDivisionname(divisionName);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to delete", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/spocname/{spocname}")
    public ResponseEntity<Map<String, Object>> deletebySpocname(@PathVariable("spocname") String spocName) {
        try {
            Map<String, Object> res = groupAndDivisionService.deletebySpocname(spocName);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to delete", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/update/{sequenceId}")
    public ResponseEntity<Map<String ,Object>> updateGroupAndDivision(@PathVariable("sequenceId") Long sequenceId, @RequestBody GroupAndDivision groupAndDivision){
        try{
            Map<String,Object> res = groupAndDivisionService.updateGroupAndDivision(sequenceId,groupAndDivision);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



}

