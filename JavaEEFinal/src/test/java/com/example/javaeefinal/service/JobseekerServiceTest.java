package com.example.javaeefinal.service;

import com.example.javaeefinal.model.HR;
import com.example.javaeefinal.model.Vacancy;
import com.example.javaeefinal.model.VacancyCategory;
import com.example.javaeefinal.repository.Jobseekers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class JobseekerServiceTest {
    @Mock
    Jobseekers repository;
    @InjectMocks
    JobseekerService jobseekerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCategory() {
        when(repository.getCategory()).thenReturn(Arrays.<VacancyCategory>asList(new VacancyCategory(0, null, null, "created_at")));

        List<VacancyCategory> result = jobseekerService.getCategory();
        Assertions.assertNotEquals(Arrays.<VacancyCategory>asList(new VacancyCategory(0, null, null, "created_at")), result);
    }

    @Test
    void testGetHumanResources() {
        when(repository.getHumanResources()).thenReturn(Arrays.<HR>asList(new HR(0, null, null, null, null, "created_at")));

        List<HR> result = jobseekerService.getHumanResources();
        Assertions.assertNotEquals(Arrays.<HR>asList(new HR(0, null, null, null, null, "created_at")), result);
    }

    @Test
    void testGetJob() {
        when(repository.getJob()).thenReturn(Arrays.<Vacancy>asList(new Vacancy(0, null, null, 0d, 0, "created_at")));

        List<Vacancy> result = jobseekerService.getJob();
        Assertions.assertNotEquals(Arrays.<Vacancy>asList(new Vacancy(0, null, null, 0d, 0, "created_at")), result);
    }

    @Test
    void testUpdateCategory() {
        when(repository.updateCategory(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = jobseekerService.updateCategory("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateHR() {
        when(repository.updateHumanResources(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = jobseekerService.updateHR("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateJob() {
        when(repository.updateJob(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = jobseekerService.updateJob("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteHR() {
        when(repository.deleteHumanResources(anyInt())).thenReturn(null);

        Response result = jobseekerService.deleteHR(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteJob() {
        when(repository.deleteJob(anyInt())).thenReturn(null);

        Response result = jobseekerService.deleteJob(0);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme