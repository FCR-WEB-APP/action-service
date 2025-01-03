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



    public Map<String, Object> addcasedetails(CaseDetails caseDetails) {
        CaseDetails caseDetails1 = caseDetailsDao.addcasedetails(caseDetails);
        return Map.of(
                "status", HttpStatus.CREATED.value(),
                "success","Successfully added",
                "data",caseDetails1
        );

    }

    public Map<String, Object> updateCaseDetails(Long case_ref_no, CaseDetails caseDetails) {
        CaseDetails caseDetails1 = caseDetailsDao.updateCaseDetails(case_ref_no,caseDetails);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "success","Successfully updated",
                "data",caseDetails1
        );

    }
}
