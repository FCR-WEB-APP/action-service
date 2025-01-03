package com.example.Action.Service;


import com.example.Action.Dao.QueryDao;
import com.example.Action.Entity.Query;
import org.springframework.stereotype.Service;

@Service
public class QueryService {
    private final QueryDao queryDao;

    public QueryService(QueryDao queryDao) {
        this.queryDao = queryDao;
    }

    public Query addQuery(Query query) {
        int rows = queryDao.addQuery(query);
        if (rows > 0) {
            return query;
        } else {
            throw new RuntimeException("Failed to add Query");        }
    }

    public String deleteQuery(Long queryId) {
        int rowsAffected = queryDao.deleteQuery(queryId);
        if (rowsAffected > 0) {
            return "Query Deleted Successfully";
        } else {
            return "Failed to delete the query";
        }
    }
}