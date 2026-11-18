package com.quickrelief.controller;

import com.quickrelief.dto.AllocateSupplyRequest;
import com.quickrelief.model.SupplyRequest;
import com.quickrelief.service.AllocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    private final AllocationService allocationService;

    public RequestController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SupplyRequest allocate(@Valid @RequestBody AllocateSupplyRequest request) {
        return allocationService.allocate(request);
    }
}
