package com.example.javaeefinal.controller;

import com.example.javaeefinal.Security.JWTToken;
import com.example.javaeefinal.Security.ListFilterInt;
import com.example.javaeefinal.model.Address;
import com.example.javaeefinal.repository.Tourism;
import com.example.javaeefinal.service.TourismService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/touristResource")
public class TouristResource {
    @EJB
    TourismService service;

    @Inject
    Logger logger;

    @RolesAllowed({"ADMIN","owner"})
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
    @PUT
    @Produces("application/json")
    @Path("/updateAddress")
    public Response updateAddress (
            @NotNull @QueryParam("param")String param,
            @NotNull @QueryParam("value") String value,
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("update address method parameter:" + param + "," + "," + value + "," + id);
        return service.updateAddress(param,value,id);
    }

    @RolesAllowed("owner")
    @JWTToken
    @DELETE
    @Produces("application/json")
    @Path("/deleteAddress")
    public Response deleteAddress (
            @NotNull @QueryParam("id") int id
    ) {
        logger.info("delete address  method parameter:"  + id);
        return service.deleteAddress(id);
    }
}
