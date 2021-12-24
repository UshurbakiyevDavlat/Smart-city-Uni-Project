package com.example.javaeefinal.repository;

import com.example.javaeefinal.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AdministrationTest {
    @Mock
    EntityManager em;
    @Mock
    Connection connection;
    @Mock
    Queue messageQueue;
    @Mock
    ConnectionFactory connectionFactory;
    //Field gson of type Gson - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    Administration administration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAddresses() {
        List<Address> result = administration.getAddresses();
        Assertions.assertNotEquals(Arrays.<Address>asList(new Address(0, "city", "streetName", "streetNumber", "created_at")), result);
    }

    @Test
    void testGetBuildings() {
        List<Building> result = administration.getBuildings();
        Assertions.assertNotEquals(Arrays.<Building>asList(new Building(0, 0d, "contactNumber", 0, "created_at")), result);
    }

    @Test
    void testGetBuildingCategory() {
        List<BuildingCategory> result = administration.getBuildingCategory();
        Assertions.assertNotEquals(Arrays.<BuildingCategory>asList(new BuildingCategory(0, 0, "created_at")), result);
    }

    @Test
    void testGetCategory() {
        List<VacancyCategory> result = administration.getCategory();
        Assertions.assertNotEquals(Arrays.<VacancyCategory>asList(new VacancyCategory(0, "title", "description", "created_at")), result);
    }

    @Test
    void testGetHumanResources() {
        List<HR> result = administration.getHumanResources();
        Assertions.assertNotEquals(Arrays.<HR>asList(new HR(0, "firstName", "secondName", "email", "contactNumber", "created_at")), result);
    }

    @Test
    void testGetJob() {
        List<Vacancy> result = administration.getJob();
        Assertions.assertNotEquals(Arrays.<Vacancy>asList(new Vacancy(0, "title", "description", 0d, 0, "created_at")), result);
    }

    @Test
    void testGetNews() {
        List<News> result = administration.getNews();
        Assertions.assertNotEquals(Arrays.<News>asList(new News(0, "title", "description", "created_at")), result);
    }

    @Test
    void testGetUser() {
        List<Users> result = administration.getUser();
        Assertions.assertNotEquals(Arrays.<Users>asList(new Users(0, "firstName", "secondName", "email", "password", 0, "created_at")), result);
    }

    @Test
    void testUpdateAddress() {
        Response result = administration.updateAddress("streetname", "Alfarabi", 0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testUpdateBuilding() {
        Response result = administration.updateBuilding("contactnumber", "255-55-55", 0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testUpdateBuildingCategory() {
        Response result = administration.updateBuildingCategory("created_at", "2020-10-20", 0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testUpdateCategory() {
        Response result = administration.updateCategory("created_at", "2020-10-20", 0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testUpdateHumanResources() {
        Response result = administration.updateHumanResources("created_at", "2020-10-20", 0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testUpdateJob() {
        Response result = administration.updateJob("created_at", "2020-10-20", 0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testUpdateNews() {
        Response result = administration.updateNews("created_at", "2020-10-20", 0);;
        Assertions.assertNotNull(result);
    }

    @Test
    void testUpdateUser() {
        Response result = administration.updateUser("created_at", "2020-10-20", 0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteAddress() {
        Response result = administration.deleteAddress(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteBuilding() {
        Response result = administration.deleteBuilding(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteBuildingCategory() {
        Response result = administration.deleteBuildingCategory(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteCategory() {
        Response result = administration.deleteCategory(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteHumanResources() {
        Response result = administration.deleteHumanResources(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteJob() {
        Response result = administration.deleteJob(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteNews() {
        Response result = administration.deleteNews(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteUser() {
        Response result = administration.deleteUser(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testCreateUser() {
        Response result = administration.createUser(new Users(3, "firstName", "secondName", "email", "password", 1, "created_at"));
        Assertions.assertNotNull(result);
    }

    @Test
    void testSendMessage() {
        try {
            String result = administration.sendMessage(new Users(1, "Dav1", "Ushur", "dushur@test.com", "dada1234", 1, "2021-12-24"));
            Assertions.assertEquals("successfully sended", result);
        } catch (Exception e) {
            Assertions.assertEquals("java.lang.RuntimeException: Caught exception from JMS when sending a message",e.toString());
        }
    }

    @Test
    void testGetMessage() {
        try {
            String result = administration.getMessage();
            Assertions.assertEquals("replaceMeWithExpectedResult", result);
        } catch (Exception e) {
            Assertions.assertEquals("java.lang.RuntimeException: Caught exception from JMS when receiving a message",e.toString());
        }
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme