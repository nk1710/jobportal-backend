package com.example.joblisting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.joblisting.model.Application;
import com.example.joblisting.repository.ApplicationRepository;

@RestController
@RequestMapping("/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationRepository repo;

    @PostMapping("/apply")
    public Application apply(@RequestBody Application application) {
        try {
            System.out.println("====== APPLY API HIT ======");
            System.out.println("JobId: " + application.getJobId());
            System.out.println("ApplicantId: " + application.getApplicantId());
            System.out.println("ApplicantName: " + application.getApplicantName());
            System.out.println("Email: " + application.getApplicantEmail());

            Application saved = repo.save(application);
            System.out.println("SAVED SUCCESSFULLY");
            return saved;

        } catch (Exception e) {
            System.out.println("❌ ERROR WHILE APPLYING");
            e.printStackTrace();
            throw e;
        }
    }
}
