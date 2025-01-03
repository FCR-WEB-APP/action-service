package com.example.Action.Controller;


import com.example.Action.Entity.Query;
import com.example.Action.Service.QueryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/query")
public class QueryController {
    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping("/add")
    public Query addQuery(@RequestBody Query query) {
        return queryService.addQuery(query);
    }

    @DeleteMapping
    public String deleteQuery(@RequestParam Long queryId) {
        String result = queryService.deleteQuery(queryId);
        return result;
    }
}