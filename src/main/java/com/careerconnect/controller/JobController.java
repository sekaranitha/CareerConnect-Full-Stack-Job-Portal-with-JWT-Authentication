package com.careerconnect.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.careerconnect.model.Job;
import com.careerconnect.service.JobService;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:5173")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping
    public List<Job> getJobs() {
        return service.getAllJobs();
    }

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return service.addJob(job);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteJob(id);
    }
}