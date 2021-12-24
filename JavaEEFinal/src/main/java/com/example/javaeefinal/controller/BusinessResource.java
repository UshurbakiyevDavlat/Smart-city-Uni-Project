package com.example.javaeefinal.controller;

import com.example.javaeefinal.Security.JWTToken;
import com.example.javaeefinal.model.News;
import com.example.javaeefinal.repository.Business;
import com.example.javaeefinal.service.BussinessService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/bussinessResource")
public class BusinessResource {
    @EJB
    BussinessService service;

    @Inject
     Logger logger;

    @PermitAll
    @JWTToken
    @GET
    @Produces("application/json")
    @Path("/getNews")
    public List<News> getNews() {
        logger.info("get news method");
        return service.getNews();
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
        logger.info("update news method parameter:" + param + "," + "," + value + "," + id);
        return service.updateNews(param,value,id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteNews")
    public Response deleteNews (
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete news  method parameter:"  + id);
        return service.deleteNews(id);
    }
}
