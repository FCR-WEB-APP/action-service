package com.example.Action.Service;

import com.example.Action.Dao.ObligourDao;
import com.example.Action.Entity.Obligour;
import org.springframework.stereotype.Service;



@Service
public class ObligourService {
    private final ObligourDao obligourDao;

    public ObligourService(ObligourDao obligourDao) {
        this.obligourDao = obligourDao;
    }

    public Obligour addObligour(Obligour obligour) {
        int rows = obligourDao.addObligour(obligour);
        if (rows > 0) {
            return obligour;
        } else {
            throw new RuntimeException("Failed to add obligour");
        }
    }
}