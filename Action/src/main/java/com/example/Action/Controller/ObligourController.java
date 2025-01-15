package com.example.Action.Controller;



import com.example.Action.Entity.Obligour;

import com.example.Action.Service.ObligourService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/obligour")
public class ObligourController {

    private final ObligourService obligourService;

    public ObligourController(ObligourService obligourService) {
        this.obligourService = obligourService;
    }

    @Operation(summary = "addObligour",
            description = "addObligour.")
    @ApiResponse(responseCode = "200", description = "Successfully added Obligour")
    @ApiResponse(responseCode = "400", description = " fail to add Obligour")
    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('Sr.Credit Reviewer', 'Credit Reviewer')")
    public Obligour addObligour(@RequestBody Obligour obligour) {
         return obligourService.addObligour(obligour);

    }
}
