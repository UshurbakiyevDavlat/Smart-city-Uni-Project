package com.example.javaeefinal.controller;

import com.example.javaeefinal.model.*;
import com.example.javaeefinal.service.AdministrationService;
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

class AdminResourceTest {
    @Mock
    AdministrationService service;
    @Mock
    Logger logger;
    @InjectMocks
    AdminResource adminResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testHello() {
        String result = adminResource.hello();
        Assertions.assertNotEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testAuthenticateUser() throws Exception {
        Response result = adminResource.authenticateUser("login", "password");
        Assertions.assertNotEquals(null, result);
    }

    @Test
    void testCreateUser() {
        when(service.createUser(any())).thenReturn(null);

        Response result = adminResource.createUser(new Users(0, null, null, null, null, 0, "created_at"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSendMessage() {
        when(service.sendJmsMessage(any())).thenReturn("sendJmsMessageResponse");

        String result = adminResource.sendMessage(new Users(0, null, null, null, null, 0, "created_at"));
        Assertions.assertNotEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetMessage() {
        when(service.getMessage()).thenReturn("getMessageResponse");

        String result = adminResource.getMessage();
        Assertions.assertNotEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetAddress() {
        when(service.getAddresses()).thenReturn(Arrays.<Address>asList(new Address(0, null, null, null, "created_at")));

        List<Address> result = adminResource.getAddress();
        Assertions.assertNotEquals(Arrays.<Address>asList(new Address(0, null, null, null, "created_at")), result);
    }

    @Test
    void testGetBuildings() {
        when(service.getBuildings()).thenReturn(Arrays.<Building>asList(new Building(0, 0d, null, 0, "created_at")));

        List<Building> result = adminResource.getBuildings();
        Assertions.assertNotEquals(Arrays.<Building>asList(new Building(0, 0d, null, 0, "created_at")), result);
    }

    @Test
    void testGetBuildingCategory() {
        when(service.getBuildingCategory()).thenReturn(Arrays.<BuildingCategory>asList(new BuildingCategory(0, 0, "created_at")));

        List<BuildingCategory> result = adminResource.getBuildingCategory();
        Assertions.assertNotEquals(Arrays.<BuildingCategory>asList(new BuildingCategory(0, 0, "created_at")), result);
    }

    @Test
    void testGetCategory() {
        when(service.getCategory()).thenReturn(Arrays.<VacancyCategory>asList(new VacancyCategory(0, null, null, "created_at")));

        List<VacancyCategory> result = adminResource.getCategory();
        Assertions.assertNotEquals(Arrays.<VacancyCategory>asList(new VacancyCategory(0, null, null, "created_at")), result);
    }

    @Test
    void testGetHumanResources() {
        when(service.getHumanResources()).thenReturn(Arrays.<HR>asList(new HR(0, null, null, null, null, "created_at")));

        List<HR> result = adminResource.getHumanResources();
        Assertions.assertNotEquals(Arrays.<HR>asList(new HR(0, null, null, null, null, "created_at")), result);
    }

    @Test
    void testGetJob() {
        when(service.getJob()).thenReturn(Arrays.<Vacancy>asList(new Vacancy(0, null, null, 0d, 0, "created_at")));

        List<Vacancy> result = adminResource.getJob();
        Assertions.assertNotEquals(Arrays.<Vacancy>asList(new Vacancy(0, null, null, 0d, 0, "created_at")), result);
    }

    @Test
    void testGetNews() {
        when(service.getNews()).thenReturn(Arrays.<News>asList(new News(0, null, null, "created_at")));

        List<News> result = adminResource.getNews();
        Assertions.assertNotEquals(Arrays.<News>asList(new News(0, null, null, "created_at")), result);
    }

    @Test
    void testGetUsers() {
        when(service.getUser()).thenReturn(Arrays.<Users>asList(new Users(0, null, null, null, null, 0, "created_at")));

        List<Users> result = adminResource.getUsers();
        Assertions.assertNotEquals(Arrays.<Users>asList(new Users(0, null, null, null, null, 0, "created_at")), result);
    }

    @Test
    void testUpdateAddress() {
        when(service.updateAddress(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = adminResource.updateAddress("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateBuilding() {
        when(service.updateBuilding(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = adminResource.updateBuilding("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateBuildingCategory() {
        when(service.updateBuildingCategory(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = adminResource.updateBuildingCategory("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateCategory() {
        when(service.updateCategory(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = adminResource.updateCategory("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateHR() {
        when(service.updateHR(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = adminResource.updateHR("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateJob() {
        when(service.updateJob(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = adminResource.updateJob("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateNews() {
        when(service.updateNews(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = adminResource.updateNews("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateUser() {
        when(service.updateUser(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = adminResource.updateUser("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteAddress() {
        when(service.deleteAddress(anyInt())).thenReturn(null);

        Response result = adminResource.deleteAddress(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteBuilding() {
        when(service.deleteBuilding(anyInt())).thenReturn(null);

        Response result = adminResource.deleteBuilding(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteBuildingCategory() {
        when(service.deleteBuildingCategory(anyInt())).thenReturn(null);

        Response result = adminResource.deleteBuildingCategory(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteCategory() {
        when(service.deleteCategory(anyInt())).thenReturn(null);

        Response result = adminResource.deleteCategory(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteHR() {
        when(service.deleteHR(anyInt())).thenReturn(null);

        Response result = adminResource.deleteHR(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteJob() {
        when(service.deleteJob(anyInt())).thenReturn(null);

        Response result = adminResource.deleteJob(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteNews() {
        when(service.deleteNews(anyInt())).thenReturn(null);

        Response result = adminResource.deleteNews(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteUser() {
        when(service.deleteUser(anyInt())).thenReturn(null);

        Response result = adminResource.deleteUser(0);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme