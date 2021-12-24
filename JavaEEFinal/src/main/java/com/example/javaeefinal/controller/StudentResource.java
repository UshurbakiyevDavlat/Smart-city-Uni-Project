package com.example.javaeefinal.controller;

import com.example.javaeefinal.Security.JWTToken;
import com.example.javaeefinal.model.Building;
import com.example.javaeefinal.model.BuildingCategory;
import com.example.javaeefinal.repository.Student;
import com.example.javaeefinal.service.StudentService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;


@Path("/studentResource")
public class StudentResource {
    @EJB
    StudentService service;

    @Inject
     Logger logger;

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
        logger.info("update building method parameter:" + param + "," + "," + value + "," + id);
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
        logger.info("update buildingcategory method parameter:" + param + "," + "," + value + "," + id);
        return service.updateBuildingCategory(param,value,id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteBuilding")
    public Response deleteBuilding (
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
    public Response deleteBuildingCategory (
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete building category  method parameter:"  + id);
        return service.deleteBuildingCategory(id);
    }
}
