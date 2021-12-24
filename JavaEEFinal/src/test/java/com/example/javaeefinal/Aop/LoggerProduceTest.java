package com.example.javaeefinal.Aop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class LoggerProduceTest {
    @Mock
    Logger logger;
    @InjectMocks
    LoggerProduce loggerProduce;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testProduceLogger() {
        Logger result = loggerProduce.produceLogger(null);
        Assertions.assertEquals(logger, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme