package com.careerconnect.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.careerconnect.model.JobApplication;

public interface ApplicationRepository extends JpaRepository<JobApplication, Integer> {
    List<JobApplication> findByUserId(int userId);
}
