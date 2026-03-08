package com.careerconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.careerconnect.model.JobApplication;
import com.careerconnect.repository.ApplicationRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository repo;

    public ApplicationService(ApplicationRepository repo) {
        this.repo = repo;
    }

    public JobApplication apply(JobApplication application) {
        application.setStatus("APPLIED");
        return repo.save(application);
    }

    public List<JobApplication> getUserApplications(int userId) {
        return repo.findByUserId(userId);
    }
}