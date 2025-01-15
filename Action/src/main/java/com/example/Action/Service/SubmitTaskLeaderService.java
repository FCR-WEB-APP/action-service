package com.example.Action.Service;

import com.example.Action.Dao.SubmitTaskLeaderDao;
import com.example.Action.Dto.SpocSubmitCRTask;
import com.example.Action.Dto.SpocSubmitTask;
import com.example.Action.Dto.SubmitTaskLeader;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SubmitTaskLeaderService {

    private final SubmitTaskLeaderDao submitTaskLeaderDao;

    public SubmitTaskLeaderService(SubmitTaskLeaderDao submitTaskLeaderDao) {
        this.submitTaskLeaderDao = submitTaskLeaderDao;
    }


    public Map<String, Object> submitTaskLeader(SubmitTaskLeader submitTaskLeader) {
        SubmitTaskLeader res = submitTaskLeaderDao.submitTaskLeader(submitTaskLeader);
        return Map.of(
                "status", HttpStatus.CREATED.value(),
                "success","successfully submitted",
                "data",res
        );
    }

    public Map<String, Object> submitTaskSpoc(SpocSubmitTask spocSubmitTask) {
        SpocSubmitTask res = submitTaskLeaderDao.submitTaskSpoc(spocSubmitTask);
        return Map.of(
                "status", HttpStatus.CREATED.value(),
                "success","successfully submitted",
                "data",res
        );
    }

    public Map<String, Object> spocSubmitCRTask(SpocSubmitCRTask spocSubmitCRTask) {
        SpocSubmitCRTask res = submitTaskLeaderDao.spocSubmitCRTask(spocSubmitCRTask);
        return Map.of(
                "status", HttpStatus.CREATED.value(),
                "success","successfully submitted",
                "data",res
        );

    }
}
