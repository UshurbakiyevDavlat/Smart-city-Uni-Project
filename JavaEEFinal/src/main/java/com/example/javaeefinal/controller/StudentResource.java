package com.example.javaeefinal.controller;

import com.example.javaeefinal.repository.Student;

import javax.ejb.EJB;

public class StudentResource {
    @EJB
    Student student;
}
