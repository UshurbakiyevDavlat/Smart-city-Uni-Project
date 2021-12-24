package com.example.javaeefinal.controller;

import com.example.javaeefinal.model.HR;
import com.example.javaeefinal.model.Vacancy;
import com.example.javaeefinal.model.VacancyCategory;
import com.example.javaeefinal.service.JobseekerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class JobseekersResourceTest {
    @Mock
    JobseekerService service;
    @Mock
    Logger logger;
    @InjectMocks
    JobseekersResource jobseekersResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCategory() {
        when(service.getCategory()).thenReturn(Arrays.<VacancyCategory>asList(new VacancyCategory(0, null, null, "created_at")));

        List<VacancyCategory> result = jobseekersResource.getCategory();
        Assertions.assertNotEquals(Arrays.<VacancyCategory>asList(new VacancyCategory(0, null, null, "created_at")), result);
    }

    @Test
    void testGetHumanResources() {
        when(service.getHumanResources()).thenReturn(Arrays.<HR>asList(new HR(0, null, null, null, null, "created_at")));

        List<HR> result = jobseekersResource.getHumanResources();
        Assertions.assertNotEquals(Arrays.<HR>asList(new HR(0, null, null, null, null, "created_at")), result);
    }

    @Test
    void testGetJob() {
        when(service.getJob()).thenReturn(Arrays.<Vacancy>asList(new Vacancy(0, null, null, 0d, 0, "created_at")));

        List<Vacancy> result = jobseekersResource.getJob();
        Assertions.assertNotEquals(Arrays.<Vacancy>asList(new Vacancy(0, null, null, 0d, 0, "created_at")), result);
    }

    @Test
    void testUpdateJob() {
        when(service.updateJob(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = jobseekersResource.updateJob("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateHR() {
        when(service.updateHR(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = jobseekersResource.updateHR("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateCategory() {
        when(service.updateCategory(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = jobseekersResource.updateCategory("param", "value", 0);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme