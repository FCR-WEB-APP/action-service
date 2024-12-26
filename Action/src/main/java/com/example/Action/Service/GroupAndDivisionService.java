package com.example.Action.Service;

import com.example.Action.Dao.GroupAndDivisionDao;
import com.example.Action.Entity.GroupAndDivision;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GroupAndDivisionService {

    private final GroupAndDivisionDao groupAndDivisionDao;

    public GroupAndDivisionService(GroupAndDivisionDao groupAndDivisionDao) {
        this.groupAndDivisionDao = groupAndDivisionDao;
    }

    public Map<String, Object> addGpAndDv(GroupAndDivision groupAndDivision) {
        GroupAndDivision groupAndDivision1 = groupAndDivisionDao.addGpAndDv(groupAndDivision);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "success","successfully added",
              "data",groupAndDivision1
        );
    }

    public Map<String, Object> deletebyGroupname(String groupname) {
        String res = groupAndDivisionDao.deletebyGroupname(groupname);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "success","successfully deleted",
                "data",res
        );

    }

    public Map<String, Object> deletebyDivisionname(String divisionName) {
        String res = groupAndDivisionDao.deletebyDivisionname(divisionName);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "success","successfully deleted",
                "data",res
        );

    }

    public Map<String, Object> deletebySpocname(String spocName) {
        String res = groupAndDivisionDao.deletebySpocname(spocName);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "success","successfully deleted",
                "data",res
        );

    }

    public Map<String, Object> updateGroupAndDivision(Long sequenceId,GroupAndDivision groupAndDivision) {
        String res = groupAndDivisionDao.updateGroupAndDivision(sequenceId,groupAndDivision);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "success","successfully deleted",
                "data",res
        );


    }
}
