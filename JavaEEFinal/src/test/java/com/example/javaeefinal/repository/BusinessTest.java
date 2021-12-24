package com.example.javaeefinal.repository;

import com.example.javaeefinal.model.News;
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

class BusinessTest {
    @Mock
    Connection connection;
    @InjectMocks
    Business business;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetNews() {
        List<News> result = business.getNews();
        Assertions.assertNotEquals(Arrays.<News>asList(new News(1, "the", "description", "created_at")), result);
    }

    @Test
    void testUpdateNews() {
        Response result = business.updateNews("title", "THE", 3);
        Assertions.assertNotNull(result);
    }

    @Test
    void testDeleteNews() {
        Response result = business.deleteNews(3);
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme