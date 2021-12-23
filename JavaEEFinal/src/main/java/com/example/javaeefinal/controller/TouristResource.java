package com.example.javaeefinal.controller;

import com.example.javaeefinal.repository.Tourism;
import com.example.javaeefinal.service.TourismService;

import javax.ejb.EJB;

public class TouristResource {
    @EJB
    TourismService service;
}
