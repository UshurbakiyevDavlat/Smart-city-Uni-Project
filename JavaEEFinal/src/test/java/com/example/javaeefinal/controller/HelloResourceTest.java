package com.example.javaeefinal.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class HelloResourceTest {
    @Mock
    Logger logger;
    @InjectMocks
    HelloResource helloResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testHello() {
        String result = helloResource.hello();
        Assertions.assertEquals("Hello, World!", result);
    }

    @Test
    void testEchoWithJWTToken() {
        Response result = helloResource.echoWithJWTToken("message");
        Assertions.assertEquals("OutboundJaxrsResponse{status=200, reason=OK, hasEntity=true, closed=false, buffered=false}", result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme