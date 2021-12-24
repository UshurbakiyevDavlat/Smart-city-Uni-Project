package com.example.javaeefinal.Security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class ListFilterTest {
    @Mock
    Logger logger;
    @InjectMocks
    ListFilter listFilter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFilter() throws IOException {
        try {
            listFilter.filter(null);
            Assertions.assertEquals(null, listFilter);
        } catch (Exception e) {
            Assertions.assertNotEquals(null, listFilter);
        }

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme