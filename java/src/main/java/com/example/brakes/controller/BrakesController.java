package com.example.brakes.controller;

import com.example.brakes.model.BrakesCalculationRequest;
import com.example.brakes.service.BrakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brakes")
public class BrakesController {

    @Autowired
    private BrakesService brakesService;

    @PostMapping("/calculate-temperature-change")
    public double calculateTemperatureChange(@RequestBody BrakesCalculationRequest request) {
        return brakesService.calculateTemperatureChange(request);
    }
}