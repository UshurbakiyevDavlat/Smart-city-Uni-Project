package com.example.javaeefinal.service;

import com.example.javaeefinal.repository.Student;

import javax.ejb.EJB;

public class StudentService {
    @EJB
    Student repository;
}
