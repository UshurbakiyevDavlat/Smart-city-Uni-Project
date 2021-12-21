package com.example.javaeefinal.controller;

import com.example.javaeefinal.Security.JWTToken;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/hello-world")
public class HelloResource {

    @Inject
    private Logger logger;

    @GET
    @Produces("text/plain")
    public String hello() {
        logger.info("testing aop");
        return "Hello, World!";
    }

    @PermitAll
    @GET
    @Path("jwt")
    @JWTToken
    public Response echoWithJWTToken(@QueryParam("message") String message) {
        logger.info("testing jwt");
        return Response.ok().entity(message == null ? "no message" : message).build();
    }
}