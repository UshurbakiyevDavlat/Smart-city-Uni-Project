package com.example.javaeefinal.service;

import com.example.javaeefinal.model.Building;
import com.example.javaeefinal.model.BuildingCategory;
import com.example.javaeefinal.repository.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class StudentService {
    @EJB
    Student repository;

    public List<Building> getBuildings() {
        return repository.getBuildings();
    }

    public List<BuildingCategory> getBuildingCategory() {
        return repository.getBuildingCategory();
    }

    public Response updateBuilding(String param, String value, int id) {
        return repository.updateBuilding(param, value, id);
    }

    public Response updateBuildingCategory(String param, String value, int id) {
        return repository.updateBuildingCategory(param, value, id);
    }

    public Response deleteBuilding(int id) {
        return repository.deleteBuilding(id);
    }

    public Response deleteBuildingCategory(int id) {
        return repository.deleteBuildingCategory(id);
    }

}
