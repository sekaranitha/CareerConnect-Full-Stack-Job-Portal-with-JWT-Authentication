package com.careerconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.careerconnect.model.Job;
import com.careerconnect.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository repo;

    public JobService(JobRepository repo) {
        this.repo = repo;
    }

    public List<Job> getAllJobs() {
        return repo.findAll();
    }

    public Job addJob(Job job) {
        return repo.save(job);
    }

    public void deleteJob(int id) {
        repo.deleteById(id);
    }
}