package com.example.javaeefinal.service;

import com.example.javaeefinal.model.Building;
import com.example.javaeefinal.model.BuildingCategory;
import com.example.javaeefinal.repository.Student;
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

class StudentServiceTest {
    @Mock
    Student repository;
    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetBuildings() {
        when(repository.getBuildings()).thenReturn(Arrays.<Building>asList(new Building(0, 0d, null, 0, "created_at")));

        List<Building> result = studentService.getBuildings();
        Assertions.assertNotEquals(Arrays.<Building>asList(new Building(0, 0d, null, 0, "created_at")), result);
    }

    @Test
    void testGetBuildingCategory() {
        when(repository.getBuildingCategory()).thenReturn(Arrays.<BuildingCategory>asList(new BuildingCategory(0, 0, "created_at")));

        List<BuildingCategory> result = studentService.getBuildingCategory();
        Assertions.assertNotEquals(Arrays.<BuildingCategory>asList(new BuildingCategory(0, 0, "created_at")), result);
    }

    @Test
    void testUpdateBuilding() {
        when(repository.updateBuilding(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = studentService.updateBuilding("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateBuildingCategory() {
        when(repository.updateBuildingCategory(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = studentService.updateBuildingCategory("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteBuilding() {
        when(repository.deleteBuilding(anyInt())).thenReturn(null);

        Response result = studentService.deleteBuilding(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteBuildingCategory() {
        when(repository.deleteBuildingCategory(anyInt())).thenReturn(null);

        Response result = studentService.deleteBuildingCategory(0);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme