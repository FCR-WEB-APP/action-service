package com.example.Action.Service;

import com.example.Action.Dao.CaseAuditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CaseAuditService {

    @Autowired
    private CaseAuditDao caseAuditDao;

    public List<Map<String, Object>> getAllCaseAudits() {
        return caseAuditDao.getAllCaseAudits();
    }

    public Map<String, Object> getCaseAuditByCaseRefNo(String caseRefNo) {
        return caseAuditDao.getCaseAuditByCaseRefNo(caseRefNo);
    }
}

