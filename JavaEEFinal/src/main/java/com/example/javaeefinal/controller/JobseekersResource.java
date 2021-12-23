package com.example.javaeefinal.controller;

import com.example.javaeefinal.repository.Jobseekers;
import com.example.javaeefinal.service.JobseekerService;

import javax.ejb.EJB;

public class JobseekersResource {
    @EJB
    JobseekerService service;
}
