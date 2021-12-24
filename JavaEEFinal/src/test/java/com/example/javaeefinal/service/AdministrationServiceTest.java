package com.example.javaeefinal.service;

import com.example.javaeefinal.model.*;
import com.example.javaeefinal.repository.Administration;
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

class AdministrationServiceTest {
    @Mock
    Administration repository;
    @InjectMocks
    AdministrationService administrationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateUser() {
        when(repository.createUser(any())).thenReturn(null);

        Response result = administrationService.createUser(new Users(0, null, null, null, null, 0, "created_at"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSendJmsMessage() {
        when(repository.sendMessage(any())).thenReturn("sendMessageResponse");

        String result = administrationService.sendJmsMessage(new Users(0, null, null, null, null, 0, "created_at"));
        Assertions.assertNotEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetMessage() {
        when(repository.getMessage()).thenReturn("getMessageResponse");

        String result = administrationService.getMessage();
        Assertions.assertNotEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetAddresses() {
        when(repository.getAddresses()).thenReturn(Arrays.<Address>asList(new Address(0, null, null, null, "created_at")));

        List<Address> result = administrationService.getAddresses();
        Assertions.assertNotEquals(Arrays.<Address>asList(new Address(0, null, null, null, "created_at")), result);
    }

    @Test
    void testGetBuildings() {
        when(repository.getBuildings()).thenReturn(Arrays.<Building>asList(new Building(0, 0d, null, 0, "created_at")));

        List<Building> result = administrationService.getBuildings();
        Assertions.assertNotEquals(Arrays.<Building>asList(new Building(0, 0d, null, 0, "created_at")), result);
    }

    @Test
    void testGetBuildingCategory() {
        when(repository.getBuildingCategory()).thenReturn(Arrays.<BuildingCategory>asList(new BuildingCategory(0, 0, "created_at")));

        List<BuildingCategory> result = administrationService.getBuildingCategory();
        Assertions.assertNotEquals(Arrays.<BuildingCategory>asList(new BuildingCategory(0, 0, "created_at")), result);
    }

    @Test
    void testGetCategory() {
        when(repository.getCategory()).thenReturn(Arrays.<VacancyCategory>asList(new VacancyCategory(0, null, null, "created_at")));

        List<VacancyCategory> result = administrationService.getCategory();
        Assertions.assertNotEquals(Arrays.<VacancyCategory>asList(new VacancyCategory(0, null, null, "created_at")), result);
    }

    @Test
    void testGetHumanResources() {
        when(repository.getHumanResources()).thenReturn(Arrays.<HR>asList(new HR(0, null, null, null, null, "created_at")));

        List<HR> result = administrationService.getHumanResources();
        Assertions.assertNotEquals(Arrays.<HR>asList(new HR(0, null, null, null, null, "created_at")), result);
    }

    @Test
    void testGetJob() {
        when(repository.getJob()).thenReturn(Arrays.<Vacancy>asList(new Vacancy(0, null, null, 0d, 0, "created_at")));

        List<Vacancy> result = administrationService.getJob();
        Assertions.assertNotEquals(Arrays.<Vacancy>asList(new Vacancy(0, null, null, 0d, 0, "created_at")), result);
    }

    @Test
    void testGetNews() {
        when(repository.getNews()).thenReturn(Arrays.<News>asList(new News(0, null, null, "created_at")));

        List<News> result = administrationService.getNews();
        Assertions.assertNotEquals(Arrays.<News>asList(new News(0, null, null, "created_at")), result);
    }

    @Test
    void testGetUser() {
        when(repository.getUser()).thenReturn(Arrays.<Users>asList(new Users(0, null, null, null, null, 0, "created_at")));

        List<Users> result = administrationService.getUser();
        Assertions.assertNotEquals(Arrays.<Users>asList(new Users(0, null, null, null, null, 0, "created_at")), result);
    }

    @Test
    void testUpdateAddress() {
        when(repository.updateAddress(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = administrationService.updateAddress("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateBuilding() {
        when(repository.updateBuilding(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = administrationService.updateBuilding("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateBuildingCategory() {
        when(repository.updateBuildingCategory(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = administrationService.updateBuildingCategory("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateCategory() {
        when(repository.updateCategory(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = administrationService.updateCategory("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateHR() {
        when(repository.updateHumanResources(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = administrationService.updateHR("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateJob() {
        when(repository.updateJob(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = administrationService.updateJob("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateNews() {
        when(repository.updateNews(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = administrationService.updateNews("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateUser() {
        when(repository.updateUser(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = administrationService.updateUser("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteAddress() {
        when(repository.deleteAddress(anyInt())).thenReturn(null);

        Response result = administrationService.deleteAddress(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteBuilding() {
        when(repository.deleteBuilding(anyInt())).thenReturn(null);

        Response result = administrationService.deleteBuilding(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteBuildingCategory() {
        when(repository.deleteBuildingCategory(anyInt())).thenReturn(null);

        Response result = administrationService.deleteBuildingCategory(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteCategory() {
        when(repository.deleteCategory(anyInt())).thenReturn(null);

        Response result = administrationService.deleteCategory(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteHR() {
        when(repository.deleteHumanResources(anyInt())).thenReturn(null);

        Response result = administrationService.deleteHR(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteJob() {
        when(repository.deleteJob(anyInt())).thenReturn(null);

        Response result = administrationService.deleteJob(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteNews() {
        when(repository.deleteNews(anyInt())).thenReturn(null);

        Response result = administrationService.deleteNews(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteUser() {
        when(repository.deleteUser(anyInt())).thenReturn(null);

        Response result = administrationService.deleteUser(0);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme