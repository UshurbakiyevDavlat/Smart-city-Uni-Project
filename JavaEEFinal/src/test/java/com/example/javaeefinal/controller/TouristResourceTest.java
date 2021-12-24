package com.example.javaeefinal.controller;

import com.example.javaeefinal.model.Address;
import com.example.javaeefinal.service.TourismService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class TouristResourceTest {
    @Mock
    TourismService service;
    @Mock
    Logger logger;
    @InjectMocks
    TouristResource touristResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAddress() {
        when(service.getAddresses()).thenReturn(Arrays.<Address>asList(new Address(0, null, null, null, "created_at")));

        List<Address> result = touristResource.getAddress();
        Assertions.assertNotEquals(Arrays.<Address>asList(new Address(0, null, null, null, "created_at")), result);
    }

    @Test
    void testUpdateAddress() {
        when(service.updateAddress(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = touristResource.updateAddress("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteAddress() {
        when(service.deleteAddress(anyInt())).thenReturn(null);

        Response result = touristResource.deleteAddress(0);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme