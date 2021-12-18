package com.example.javaeefinal.service;

import com.example.javaeefinal.model.*;
import com.example.javaeefinal.repository.Administration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class AdministrationService {
    @EJB
    private Administration repository;

    //get methods
    public List<Address> getAddresses() {
        return repository.getAddresses();
    }
    public List<Building> getBuildings() {
        return repository.getBuildings();
    }
    public List<BuildingCategory> getBuildingCategory() {
        return repository.getBuildingCategory();
    }
    public List<Category> getCategory() {
        return repository.getCategory();
    }
    public List<HumanResources> getHumanResources() {
        return repository.getHumanResources();
    }
    public List<Job> getJob() {
        return repository.getJob();
    }
    public List<News> getNews() {
        return repository.getNews();
    }
    public List<User> getUser() {
        return repository.getUser();
    }

    //update methods
    public Response updateAddress (String param,String value, int id) {
        return repository.updateAddress(param, value, id);
    }


    //delete methods
    public Response deleteAddress (int id) {
        return repository.deleteAddress(id);
    }
}
