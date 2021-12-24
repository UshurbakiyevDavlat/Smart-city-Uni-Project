package com.example.javaeefinal.controller;


import com.example.javaeefinal.Security.JWTToken;
import com.example.javaeefinal.model.*;
import com.example.javaeefinal.service.AdministrationService;
import com.example.javaeefinal.Security.ListFilterInt;


import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/adResource")

public class AdminResource {

    @EJB
    AdministrationService service;

    @Inject
    Logger logger;


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


    @RolesAllowed({"ADMIN", "owner"})
    @JWTToken
    @POST
    @Path("/createUser")
    public Response createUser(Users users) {
        logger.info("creater user parameters:" + users);
        return service.createUser(users);
    }

    @RolesAllowed({"ADMIN", "owner"})
    @JWTToken
    @POST
    @Path("/jms")
    public String sendMessage(Users users) {
        logger.info("send message parameters:" + users);
        return service.sendJmsMessage(users);
    }

    @RolesAllowed({"ADMIN", "owner"})
    @JWTToken
    @GET
    @Path("/jms")
    @Produces("application/json")
    public String getMessage() {
        logger.info("get message method");
        //Users users = gson.fromJson(info,com.example.javaeefinal.model.Users.class);
        return service.getMessage();
    }

    // get methods
    @RolesAllowed({"ADMIN", "owner"})
    @JWTToken
    @ListFilterInt
    @GET
    @Produces("application/json")
    @Path("/getAddress")
    public List<Address> getAddress() {
        logger.info("get address method");
        return service.getAddresses();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getBuildings")
    public List<Building> getBuildings() {
        logger.info("get building method");
        return service.getBuildings();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getBuildingsCategory")
    public List<BuildingCategory> getBuildingCategory() {
        logger.info("get building category method");
        return service.getBuildingCategory();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getCategory")
    public List<VacancyCategory> getCategory() {
        logger.info("get category method");
        return service.getCategory();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getHumanResources")
    public List<HR> getHumanResources() {
        logger.info("get hr method");
        return service.getHumanResources();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getJob")
    public List<Vacancy> getJob() {
        logger.info("get job method");
        return service.getJob();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getNews")
    public List<News> getNews() {
        logger.info("get news method");
        return service.getNews();
    }

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getUsers")
    public List<Users> getUsers() {
        logger.info("get users method");
        return service.getUser();
    }

    //Put methods
    @PermitAll
    @JWTToken
    @PUT
    @Produces("application/json")
    @Path("/updateAddress")
    public Response updateAddress(
            @NotNull @QueryParam("param") String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("update address method parameter:" + param + "," + "," + value + "," + id);
        return service.updateAddress(param, value, id);
    }

    @RolesAllowed({"ADMIN", "owner"})
    @JWTToken
    @PUT
    @Produces("application/json")
    @Path("/updateBuilding")
    public Response updateBuilding(
            @NotNull @QueryParam("param") String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("update building method parameter:" + param + "," + "," + value + "," + id);
        return service.updateBuilding(param, value, id);
    }

    @RolesAllowed({"ADMIN", "owner"})
    @JWTToken
    @PUT
    @Produces("application/json")
    @Path("/updateBuildingCategory")
    public Response updateBuildingCategory(
            @NotNull @QueryParam("param") String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("update buildingcategory method parameter:" + param + "," + "," + value + "," + id);
        return service.updateBuildingCategory(param, value, id);
    }

    @RolesAllowed({"ADMIN", "owner"})
    @JWTToken
    @PUT
    @Produces("application/json")
    @Path("/updateCategory")
    public Response updateCategory(
            @NotNull @QueryParam("param") String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("update category method parameter:" + param + "," + "," + value + "," + id);
        return service.updateCategory(param, value, id);
    }

    @RolesAllowed({"ADMIN", "owner"})
    @JWTToken
    @PUT
    @Produces("application/json")
    @Path("/updateHR")
    public Response updateHR(
            @NotNull @QueryParam("param") String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("update hr method parameter:" + param + "," + "," + value + "," + id);
        return service.updateHR(param, value, id);
    }

    @RolesAllowed("ADMIN")
    @JWTToken
    @PUT
    @Produces("application/json")
    @Path("/updateJob")
    public Response updateJob(
            @NotNull @QueryParam("param") String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("update job method parameter:" + param + "," + "," + value + "," + id);
        return service.updateJob(param, value, id);
    }

    @RolesAllowed({"ADMIN", "owner"})
    @JWTToken
    @PUT
    @Produces("application/json")
    @Path("/updateNews")
    public Response updateNews(
            @NotNull @QueryParam("param") String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("update news method parameter:" + param + "," + "," + value + "," + id);
        return service.updateNews(param, value, id);
    }

    @RolesAllowed({"ADMIN", "owner"})
    @JWTToken
    @PUT
    @Produces("application/json")
    @Path("/updateUser")
    public Response updateUser(
            @NotNull @QueryParam("param") String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("update user  method parameter:" + param + "," + "," + value + "," + id);
        return service.updateUser(param, value, id);
    }


    //delete methods
    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteAddress")
    public Response deleteAddress(
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete address  method parameter:"  + id);
        return service.deleteAddress(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteBuilding")
    public Response deleteBuilding(
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete building  method parameter:"  + id);
        return service.deleteBuilding(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteBuildingCategory")
    public Response deleteBuildingCategory(
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete building category  method parameter:"  + id);
        return service.deleteBuildingCategory(id);
    }


    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteCategory")
    public Response deleteCategory(
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete category  method parameter:"  + id);
        return service.deleteCategory(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteHR")
    public Response deleteHR(
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete hr  method parameter:"  + id);
        return service.deleteHR(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteJob")
    public Response deleteJob(
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete job  method parameter:"  + id);
        return service.deleteJob(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteNews")
    public Response deleteNews(
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete news  method parameter:"  + id);
        return service.deleteNews(id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteUser")
    public Response deleteUser(
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete user  method parameter:"  + id);
        return service.deleteUser(id);
    }
}
