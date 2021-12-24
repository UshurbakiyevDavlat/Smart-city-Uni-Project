package com.example.javaeefinal.repository;

import com.example.javaeefinal.model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class TourismTest {
    @Mock
    Connection connection;
    @InjectMocks
    Tourism tourism;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAddresses() {
        List<Address> result = tourism.getAddresses();
        Assertions.assertNotEquals(Arrays.<Address>asList(new Address(0, "city", "streetName", "streetNumber", "created_at")), result);
    }

    @Test
    void testUpdateAddress() {
        Response result = tourism.updateAddress("streetname", "Alfarabi", 1);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteAddress() {
        Response result = tourism.deleteAddress(0);
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme