package com.example.javaeefinal.controller;

import com.example.javaeefinal.model.Building;
import com.example.javaeefinal.model.BuildingCategory;
import com.example.javaeefinal.service.StudentService;
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

class StudentResourceTest {
    @Mock
    StudentService service;
    @Mock
    Logger logger;
    @InjectMocks
    StudentResource studentResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetBuildings() {
        when(service.getBuildings()).thenReturn(Arrays.<Building>asList(new Building(0, 0d, null, 0, "created_at")));

        List<Building> result = studentResource.getBuildings();
        Assertions.assertNotEquals(Arrays.<Building>asList(new Building(0, 0d, null, 0, "created_at")), result);
    }

    @Test
    void testGetBuildingCategory() {
        when(service.getBuildingCategory()).thenReturn(Arrays.<BuildingCategory>asList(new BuildingCategory(0, 0, "created_at")));

        List<BuildingCategory> result = studentResource.getBuildingCategory();
        Assertions.assertNotEquals(Arrays.<BuildingCategory>asList(new BuildingCategory(0, 0, "created_at")), result);
    }

    @Test
    void testUpdateBuilding() {
        when(service.updateBuilding(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = studentResource.updateBuilding("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateBuildingCategory() {
        when(service.updateBuildingCategory(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = studentResource.updateBuildingCategory("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteBuilding() {
        when(service.deleteBuilding(anyInt())).thenReturn(null);

        Response result = studentResource.deleteBuilding(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteBuildingCategory() {
        when(service.deleteBuildingCategory(anyInt())).thenReturn(null);

        Response result = studentResource.deleteBuildingCategory(0);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme