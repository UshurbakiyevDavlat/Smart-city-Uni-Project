package com.example.javaeefinal.repository;

import com.example.javaeefinal.model.HR;
import com.example.javaeefinal.model.Vacancy;
import com.example.javaeefinal.model.VacancyCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class JobseekersTest {
    @Mock
    Connection connection;
    @InjectMocks
    Jobseekers jobseekers;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCategory() {
        List<VacancyCategory> result = jobseekers.getCategory();
        Assertions.assertNotEquals(Arrays.<VacancyCategory>asList(new VacancyCategory(0, "title", "description", "created_at")), result);
    }

    @Test
    void testGetHumanResources() {
        List<HR> result = jobseekers.getHumanResources();
        Assertions.assertNotEquals(Arrays.<HR>asList(new HR(1, "firstName", "secondName", "email", "contactNumber", "created_at")), result);
    }

    @Test
    void testGetJob() {
        List<Vacancy> result = jobseekers.getJob();
        Assertions.assertNotEquals(Arrays.<Vacancy>asList(new Vacancy(1, "title", "description", 0d, 0, "created_at")), result);
    }

    @Test
    void testUpdateCategory() {
        Response result = jobseekers.updateCategory("title", "ok", 3);
        Assertions.assertEquals("OutboundJaxrsResponse{status=200, reason=OK, hasEntity=false, closed=false, buffered=false}", result.toString());
    }

    @Test
    void testUpdateHumanResources() {
        Response result = jobseekers.updateHumanResources("firstname", "Sabina", 1);
        Assertions.assertEquals("OutboundJaxrsResponse{status=200, reason=OK, hasEntity=false, closed=false, buffered=false}", result.toString());
    }

    @Test
    void testUpdateJob() {
        Response result = jobseekers.updateJob("title", "laravel dev", 1);
        Assertions.assertEquals("OutboundJaxrsResponse{status=200, reason=OK, hasEntity=false, closed=false, buffered=false}", result.toString());
    }

    @Test
    void testDeleteCategory() {
        Response result = jobseekers.deleteCategory(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteHumanResources() {
        Response result = jobseekers.deleteHumanResources(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteJob() {
        Response result = jobseekers.deleteJob(0);
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme