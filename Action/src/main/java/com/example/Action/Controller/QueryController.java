package com.example.Action.Controller;


import com.example.Action.Entity.Query;
import com.example.Action.Service.QueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/query")
public class QueryController {
    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @Operation(summary = "addQuery",
            description = "addQuery.")
    @ApiResponse(responseCode = "200", description = "Successfully added Query")
    @ApiResponse(responseCode = "400", description = " fail to add Query")
    @PostMapping("/add")
    public Query addQuery(@RequestBody Query query) {
        return queryService.addQuery(query);
    }

    @Operation(summary = "deleteQuery",
            description = "deleteQuery.")
    @ApiResponse(responseCode = "200", description = "Successfully deleteQuery")
    @ApiResponse(responseCode = "400", description = " fail to  deleteQuery")
    @DeleteMapping("/delete")
    public String deleteQuery(@RequestParam Long queryId) {
        String result = queryService.deleteQuery(queryId);
        return result;
    }
}