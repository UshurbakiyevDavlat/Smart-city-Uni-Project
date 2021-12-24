package com.example.javaeefinal.controller;

import com.example.javaeefinal.Security.JWTToken;
import com.example.javaeefinal.model.VacancyCategory;
import com.example.javaeefinal.model.HR;
import com.example.javaeefinal.model.Vacancy;
import com.example.javaeefinal.service.JobseekerService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/jobSeekerResource")
public class JobseekersResource {
    @EJB
    JobseekerService service;

    @Inject
    Logger logger;

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
        logger.info("update job method parameter:" + param + "," + "," + value + "," + id);

        return service.updateJob(param,value,id);
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
        logger.info("update hr method parameter:" + param + "," + "," + value + "," + id);
        return service.updateHR(param,value,id);
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
        logger.info("update category method parameter:" + param + "," + "," + value + "," + id);
        return service.updateCategory(param,value,id);
    }
}
