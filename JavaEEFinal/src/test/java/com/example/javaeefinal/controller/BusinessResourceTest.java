package com.example.javaeefinal.controller;

import com.example.javaeefinal.model.News;
import com.example.javaeefinal.service.BussinessService;
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

class BusinessResourceTest {
    @Mock
    BussinessService service;
    @Mock
    Logger logger;
    @InjectMocks
    BusinessResource businessResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetNews() {
        when(service.getNews()).thenReturn(Arrays.<News>asList(new News(0, null, null, "created_at")));

        List<News> result = businessResource.getNews();
        Assertions.assertNotEquals(Arrays.<News>asList(new News(0, null, null, "created_at")), result);
    }

    @Test
    void testUpdateNews() {
        when(service.updateNews(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = businessResource.updateNews("param", "value", 0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteNews() {
        when(service.deleteNews(anyInt())).thenReturn(null);

        Response result = businessResource.deleteNews(0);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme