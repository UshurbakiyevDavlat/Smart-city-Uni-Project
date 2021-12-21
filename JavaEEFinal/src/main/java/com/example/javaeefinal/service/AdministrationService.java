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


    //create methods
//    public Response auth (String login, String password) throws Exception {
//        return repository.auth(login,password);
//    }

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
    public List<Users> getUser() {
        return repository.getUser();
    }

    //update methods
    public Response updateAddress (String param,String value, int id) {
        return repository.updateAddress(param, value, id);
    }
    public Response updateBuilding (String param,String value, int id) {
        return repository.updateBuilding(param, value, id);
    }
    public Response updateBuildingCategory (String param,String value, int id) {
        return  repository.updateBuildingCategory(param, value, id);
    }
    public Response updateCategory (String param, String value, int id) {
        return repository.updateCategory(param,value,id);
    }
    public Response updateHR (String param,String value, int id) {
        return repository.updateHumanResources(param, value, id);
    }
    public Response updateJob (String param,String value, int id) {
        return repository.updateJob(param, value, id);
    }
    public Response updateNews (String param,String value, int id) {
        return repository.updateNews(param, value, id);
    }
    public Response updateUser (String param,String value, int id) {
        return repository.updateUser(param, value, id);
    }


    //delete methods
    public Response deleteAddress (int id) {
        return repository.deleteAddress(id);
    }
    public Response deleteBuilding (int id) {
        return repository.deleteBuilding(id);
    }
    public Response deleteBuildingCategory(int id) {
        return repository.deleteBuildingCategory(id);
    }
    public Response deleteCategory (int id) {
        return repository.deleteCategory(id);
    }
    public Response deleteHR (int id) {
        return repository.deleteHumanResources(id);
    }
    public Response deleteJob (int id) {
        return repository.deleteJob(id);
    }
    public Response deleteNews (int id) {
        return repository.deleteNews(id);
    }
    public Response deleteUser (int id) {
        return repository.deleteUser(id);
    }
}
