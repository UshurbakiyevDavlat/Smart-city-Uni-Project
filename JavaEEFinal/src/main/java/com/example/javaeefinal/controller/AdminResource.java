package com.example.javaeefinal.controller;


import com.example.javaeefinal.model.*;
import com.example.javaeefinal.service.AdministrationService;


import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
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

    // post methods


    // get methods
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

    //Put methods
    @PUT
    @Produces("application/json")
    @Path("/updateAddress")
    public Response updateAddress (
            @NotNull @QueryParam("param")String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        return service.updateAddress(param,value,id);
    }

    @PUT
    @Produces("application/json")
    @Path("/updateBuilding")
    public Response updateBuilding (
            @NotNull @QueryParam("param")String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        return service.updateBuilding(param,value,id);
    }

    @PUT
    @Produces("application/json")
    @Path("/updateBuildingCategory")
    public Response updateBuildingCategory (
            @NotNull @QueryParam("param")String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        return service.updateBuildingCategory(param,value,id);
    }
    @PUT
    @Produces("application/json")
    @Path("/updateCategory")
    public Response updateCategory (
            @NotNull @QueryParam("param")String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        return service.updateCategory(param,value,id);
    }


    @PUT
    @Produces("application/json")
    @Path("/updateHR")
    public Response updateHR (
            @NotNull @QueryParam("param")String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        return service.updateHR(param,value,id);
    }

    @PUT
    @Produces("application/json")
    @Path("/updateJob")
    public Response updateJob (
            @NotNull @QueryParam("param")String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        return service.updateJob(param,value,id);
    }

    @PUT
    @Produces("application/json")
    @Path("/updateNews")
    public Response updateNews (
            @NotNull @QueryParam("param")String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        return service.updateNews(param,value,id);
    }

    @PUT
    @Produces("application/json")
    @Path("/updateUser")
    public Response updateUser (
            @NotNull @QueryParam("param")String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        return service.updateUser(param,value,id);
    }



    //delete methods
    @DELETE
    @Produces("application/json")
    @Path("/deleteAddress")
    public Response deleteAddress (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteAddress(id);
    }

    @DELETE
    @Produces("application/json")
    @Path("/deleteBuilding")
    public Response deleteBuilding (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteBuilding(id);
    }

    @DELETE
    @Produces("application/json")
    @Path("/deleteBuildingCategory")
    public Response deleteBuildingCategory (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteBuildingCategory(id);
    }


    @DELETE
    @Produces("application/json")
    @Path("/deleteCategory")
    public Response deleteCategory (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteCategory(id);
    }

    @DELETE
    @Produces("application/json")
        @Path("/deleteHR")
    public Response deleteHR (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteHR(id);
    }

    @DELETE
    @Produces("application/json")
    @Path("/deleteJob")
    public Response deleteJob (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteJob(id);
    }

    @DELETE
    @Produces("application/json")
    @Path("/deleteNews")
    public Response deleteNews (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteNews(id);
    }

    @DELETE
    @Produces("application/json")
    @Path("/deleteUser")
    public Response deleteUser (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteUser(id);
    }
}
