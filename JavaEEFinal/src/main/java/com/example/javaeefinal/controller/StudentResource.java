package com.example.javaeefinal.controller;

import com.example.javaeefinal.repository.Student;
import com.example.javaeefinal.service.StudentService;

import javax.ejb.EJB;

public class StudentResource {
    @EJB
    StudentService service;
}
