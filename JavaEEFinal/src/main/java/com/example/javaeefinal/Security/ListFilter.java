package com.example.javaeefinal.Security;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Provider
@ListFilterInt
public class ListFilter implements ContainerRequestFilter {
    @Inject
    private Logger logger;
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        logger.info(containerRequestContext.getMethod());
    }
}
