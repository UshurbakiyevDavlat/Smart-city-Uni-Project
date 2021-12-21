package com.example.javaeefinal.controller;


import com.example.javaeefinal.Security.JWTToken;
import com.example.javaeefinal.model.*;
import com.example.javaeefinal.service.AdministrationService;


import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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
    // TODO нужно доделать не работает персистенс кажется
    @DenyAll
    @JWTToken
    @POST
    @Path("/login")
    public Response authenticateUser(@FormParam("login") String login,
                                     @FormParam("password") String password) throws Exception {
//        return service.auth(login,password);
        return Response.notModified().build();
    }

    // get methods
    @RolesAllowed({"ADMIN","owner"})
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getAddress")
    public List<Address> getAddress() {
        return service.getAddresses();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getBuildings")
    public List<Building> getBuildings() {
        return service.getBuildings();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getBuildingsCategory")
    public List<BuildingCategory> getBuildingCategory() {
        return service.getBuildingCategory();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getCategory")
    public List<Category> getCategory() {
        return service.getCategory();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getHumanResources")
    public List<HumanResources> getHumanResources() {
        return service.getHumanResources();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getJob")
    public List<Job> getJob() {
        return service.getJob();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getNews")
    public List<News> getNews() {
        return service.getNews();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getUsers")
    public List<Users> getUsers() {
        return service.getUser();
    }

    //Put methods
    @PermitAll
    @JWTToken
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

    @RolesAllowed({"ADMIN","owner"})
    @JWTToken
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

    @RolesAllowed({"ADMIN","owner"})
    @JWTToken
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
    @RolesAllowed({"ADMIN","owner"})
    @JWTToken
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

    @RolesAllowed({"ADMIN","owner"})
    @JWTToken
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

    @RolesAllowed("ADMIN")
    @JWTToken
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
    @RolesAllowed({"ADMIN","owner"})
    @JWTToken
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

    @RolesAllowed({"ADMIN","owner"})
    @JWTToken
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
    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteAddress")
    public Response deleteAddress (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteAddress(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteBuilding")
    public Response deleteBuilding (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteBuilding(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteBuildingCategory")
    public Response deleteBuildingCategory (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteBuildingCategory(id);
    }


    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteCategory")
    public Response deleteCategory (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteCategory(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
        @Path("/deleteHR")
    public Response deleteHR (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteHR(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteJob")
    public Response deleteJob (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteJob(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteNews")
    public Response deleteNews (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteNews(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteUser")
    public Response deleteUser (
            @NotNull @QueryParam("id") int id
    ) {
        return service.deleteUser(id);
    }
}
