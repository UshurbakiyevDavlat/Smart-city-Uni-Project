package com.example.javaeefinal.controller;

import com.example.javaeefinal.model.*;
import com.example.javaeefinal.service.AdministrationService;


import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/adResource")

public class AdminResource {

    @EJB
    AdministrationService service;

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, Admin!";
    }

    @GET
    @Produces("application/json")
    @Path("/getAddress")
    public List<Address> getAddress() {
        return service.getAddresses();
    }

    @GET
    @Produces("application/json")
    @Path("/getBuildings")
    public List<Building> getBuildings() {
        return service.getBuildings();
    }

    @GET
    @Produces("application/json")
    @Path("/getBuildingsCategory")
    public List<BuildingCategory> getBuildingCategory() {
        return service.getBuildingCategory();
    }

    @GET
    @Produces("application/json")
    @Path("/getCategory")
    public List<Category> getCategory() {
        return service.getCategory();
    }

    @GET
    @Produces("application/json")
    @Path("/getHumanResources")
    public List<HumanResources> getHumanResources() {
        return service.getHumanResources();
    }

    @GET
    @Produces("application/json")
    @Path("/getJob")
    public List<Job> getJob() {
        return service.getJob();
    }

    @GET
    @Produces("application/json")
    @Path("/getNews")
    public List<News> getNews() {
        return service.getNews();
    }

    @GET
    @Produces("application/json")
    @Path("/getUsers")
    public List<User> getUsers() {
        return service.getUser();
    }


    @PUT
    @Produces("application/json")
    @Path("/updateAddress")
    public Response updateAddress (
            @QueryParam("param")String param,
            @QueryParam("value") String value,
            @QueryParam("id") int id
    ) {
        return service.updateAddress(param,value,id);
    }

    @DELETE
    @Produces("application/json")
    @Path("/deleteAddress")
    public Response deleteAddress (
            @QueryParam("id") int id
    ) {
        return service.deleteAddress(id);
    }
}
