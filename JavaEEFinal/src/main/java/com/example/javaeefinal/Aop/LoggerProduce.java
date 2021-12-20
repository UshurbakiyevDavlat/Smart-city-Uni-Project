package com.example.javaeefinal.Aop;

import com.example.javaeefinal.controller.HelloResource;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerProduce {
    Logger logger;
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        String lConf = "C:\\Users\\dushu\\Desktop\\IITU\\web_component_development\\final\\Smart-city-Uni-Project\\JavaEEFinal\\src\\main\\java\\com\\example\\javaeefinal\\Aop\\log.config";
        try (FileInputStream ins = new FileInputStream(lConf)) {
            LogManager.getLogManager().readConfiguration(ins);
            logger =  Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
        return  logger;
    }

}
