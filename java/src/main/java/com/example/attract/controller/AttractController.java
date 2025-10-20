package com.example.attract.controller;

import com.example.attract.model.Body;
import com.example.attract.service.GravitationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attract")
public class AttractController {

    @Autowired
    private GravitationalService gravitationalService;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateAttraction(@RequestBody List<Body> bodies) {
        if (bodies == null || bodies.size() != 2) {
            return new ResponseEntity<>("Exactly two bodies are required for calculation.", HttpStatus.BAD_REQUEST);
        }
        try {
            GravitationalService.GravitationalCalculationResult result =
                    gravitationalService.calculateAttraction(bodies.get(0), bodies.get(1));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred during calculation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}