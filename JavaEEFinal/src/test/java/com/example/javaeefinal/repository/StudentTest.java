package com.example.javaeefinal.repository;

import com.example.javaeefinal.model.Building;
import com.example.javaeefinal.model.BuildingCategory;
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

class StudentTest {
    @Mock
    Connection connection;
    @InjectMocks
    Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetBuildings() {
        List<Building> result = student.getBuildings();
        Assertions.assertNotEquals(Arrays.<Building>asList(new Building(1, 0d, "contactNumber", 0, "created_at")), result);
    }

    @Test
    void testGetBuildingCategory() {
        List<BuildingCategory> result = student.getBuildingCategory();
        Assertions.assertNotEquals(Arrays.<BuildingCategory>asList(new BuildingCategory(0, 0, "created_at")), result);
    }

    @Test
    void testUpdateBuilding() {
        Response result = student.updateBuilding("contactnumber", "255-55-55", 1);
        Assertions.assertEquals("OutboundJaxrsResponse{status=200, reason=OK, hasEntity=false, closed=false, buffered=false}", result.toString());
    }

    @Test
    void testUpdateBuildingCategory() {
        Response result = student.updateBuildingCategory("created_at", "2020-12-20", 1);
        Assertions.assertEquals("OutboundJaxrsResponse{status=200, reason=OK, hasEntity=false, closed=false, buffered=false}", result.toString());
    }

    @Test
    void testDeleteBuilding() {
        Response result = student.deleteBuilding(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteBuildingCategory() {
        Response result = student.deleteBuildingCategory(0);
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme