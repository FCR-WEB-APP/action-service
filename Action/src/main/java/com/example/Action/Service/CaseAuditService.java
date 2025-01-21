package com.example.Action.Service;

import com.example.Action.Dao.CaseAuditDao;
import com.example.Action.Entity.CaseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CaseAuditService {


    private final CaseAuditDao caseAuditDao;

    public CaseAuditService(CaseAuditDao caseAuditDao) {
        this.caseAuditDao = caseAuditDao;
    }


    public void addCaseAudit(CaseDetails caseDetails,String username) {
        caseAuditDao.addCaseAudit(caseDetails,username);

    }
}

