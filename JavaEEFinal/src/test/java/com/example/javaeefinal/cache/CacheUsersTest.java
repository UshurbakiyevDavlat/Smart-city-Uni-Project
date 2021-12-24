package com.example.javaeefinal.cache;

import com.example.javaeefinal.repository.Administration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.Mockito.*;

class CacheUsersTest {
    @Mock
    Map cache;
    @Mock
    Administration administration;
    @InjectMocks
    CacheUsers cacheUsers;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetData() {
        Object result = cacheUsers.getData("id");
        Assertions.assertNull (result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme