package com.example.javaeefinal.service;

import com.example.javaeefinal.model.Address;
import com.example.javaeefinal.repository.Tourism;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class TourismServiceTest {
    @Mock
    Tourism repository;
    @InjectMocks
    TourismService tourismService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAddresses() {
        when(repository.getAddresses()).thenReturn(Arrays.<Address>asList(new Address(0, null, null, null, "created_at")));

        List<Address> result = tourismService.getAddresses();
        Assertions.assertNotEquals(Arrays.<Address>asList(new Address(0, null, null, null, "created_at")), result);
    }

    @Test
    void testUpdateAddress() {
        when(repository.updateAddress(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = tourismService.updateAddress("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteAddress() {
        when(repository.deleteAddress(anyInt())).thenReturn(null);

        Response result = tourismService.deleteAddress(0);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme