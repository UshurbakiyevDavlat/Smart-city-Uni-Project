package com.example.javaeefinal.cache;

import com.example.javaeefinal.model.Address;
import com.example.javaeefinal.repository.Administration;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Startup
@Singleton
public class CacheAddresses {
    private Map cache;

    @EJB
    Administration administration;

    @Schedule(hour = "*", minute = "*/5", persistent = false)
    @PostConstruct
    private void populateCache(){
        cache = createFreshCache();
    }

    @Lock(LockType.READ)
    public Object getData(String id){
        return cache.get(id);
    }

    private Map<String, String> createFreshCache() {
        System.out.println("Starting to cache addresses: ");
        Map<String, String> map = new HashMap<>();
        List<Address> dataList = administration.getAddresses();
        for (Address addresses : dataList) {
            map.put(String.valueOf(addresses.getId()), addresses.getStreetName());
        }
        System.out.println("completed to cache addresses: ");
        return map;
    }
}
