package com.example.Action.Controller;



import com.example.Action.Entity.Obligour;

import com.example.Action.Service.ObligourService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/obligour")
public class ObligourController {

    private final ObligourService obligourService;

    public ObligourController(ObligourService obligourService) {
        this.obligourService = obligourService;
    }

    @PostMapping("/add")
    public Obligour addObligour(@RequestBody Obligour obligour) {
         return obligourService.addObligour(obligour);

    }
}
