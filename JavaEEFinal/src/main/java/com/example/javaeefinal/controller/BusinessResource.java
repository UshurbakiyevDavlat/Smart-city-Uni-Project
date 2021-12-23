package com.example.javaeefinal.controller;

import com.example.javaeefinal.repository.Business;
import com.example.javaeefinal.service.BussinessService;

import javax.ejb.EJB;

public class BusinessResource {
    @EJB
    BussinessService service;
}
