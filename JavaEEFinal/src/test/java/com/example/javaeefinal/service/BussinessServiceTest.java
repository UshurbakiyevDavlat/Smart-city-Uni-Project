package com.example.javaeefinal.service;

import com.example.javaeefinal.model.News;
import com.example.javaeefinal.repository.Business;
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

class BussinessServiceTest {
    @Mock
    Business repository;
    @InjectMocks
    BussinessService bussinessService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetNews() {
        when(repository.getNews()).thenReturn(Arrays.<News>asList(new News(0, null, null, "created_at")));

        List<News> result = bussinessService.getNews();
        Assertions.assertNotEquals(Arrays.<News>asList(new News(0, null, null, "created_at")), result);
    }

    @Test
    void testUpdateNews() {
        when(repository.updateNews(anyString(), anyString(), anyInt())).thenReturn(null);

        Response result = bussinessService.updateNews("title", "value", 0);
        Assertions.assertNull( result);
    }

    @Test
    void testDeleteNews() {
        when(repository.deleteNews(anyInt())).thenReturn(null);

        Response result = bussinessService.deleteNews(0);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme