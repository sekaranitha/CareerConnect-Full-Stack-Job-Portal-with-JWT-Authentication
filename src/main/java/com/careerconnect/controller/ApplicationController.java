package com.careerconnect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.careerconnect.model.JobApplication;
import com.careerconnect.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "http://localhost:5173")
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public JobApplication apply(@RequestBody JobApplication application) {
        return service.apply(application);
    }

    @GetMapping("/user/{userId}")
    public List<JobApplication> userApplications(@PathVariable int userId) {
        return service.getUserApplications(userId);
    }
}