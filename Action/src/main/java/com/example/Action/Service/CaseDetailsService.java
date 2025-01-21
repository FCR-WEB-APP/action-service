package com.example.Action.Service;

import com.example.Action.Dao.CaseDetailsDao;
import com.example.Action.Entity.CaseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CaseDetailsService {

    private final CaseDetailsDao caseDetailsDao;

    public CaseDetailsService(CaseDetailsDao caseDetailsDao) {

        this.caseDetailsDao = caseDetailsDao;
    }



    public Map<String, Object> addcasedetails(CaseDetails caseDetails,String username) {
        CaseDetails caseDetails1 = caseDetailsDao.addcasedetails(caseDetails,username);
        return Map.of(
                "status", HttpStatus.CREATED.value(),
                "success","Successfully added",
                "data",caseDetails1
        );

    }

    public Map<String, Object> updateCaseDetails(String case_ref_no, CaseDetails caseDetails,String username) {
        CaseDetails caseDetails1 = caseDetailsDao.updateCaseDetails(case_ref_no,caseDetails,username);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "success","Successfully updated",
                "data",caseDetails1
        );

    }
}
