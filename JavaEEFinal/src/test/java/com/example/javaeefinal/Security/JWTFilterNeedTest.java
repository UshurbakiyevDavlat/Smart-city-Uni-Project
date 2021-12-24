package com.example.javaeefinal.Security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.container.ResourceInfo;
import java.io.IOException;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class JWTFilterNeedTest {
    @Mock
    Logger logger;
    @Mock
    ResourceInfo resourceInfo;
    @InjectMocks
    JWTFilterNeed jWTFilterNeed;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFilter() throws IOException {
        try {
            jWTFilterNeed.filter(null);
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme