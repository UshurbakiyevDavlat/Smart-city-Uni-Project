package com.example.javaeefinal.cache;


import com.example.javaeefinal.model.Users;
import com.example.javaeefinal.repository.Administration;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Startup
@Singleton
public class CacheUsers {
    private Map cache;
    @EJB
    Administration administration;

    @Schedule(hour = "*/5", minute = "*", persistent = false)
    @PostConstruct
    private void populateCache(){
        cache = createFreshCache();
    }

    @Lock(LockType.READ)
    public Object getData(String id){
        return cache.get(id);
    }

    private Map<String, String> createFreshCache() {
        System.out.println("Starting to cache users password: ");
        Map<String, String> map = new HashMap<>();
        List<Users> dataList = administration.getUser();
        for (Users users : dataList) {
            map.put(String.valueOf(users.getId()), users.getPassword());
        }
        System.out.println("completed to cache users password: ");
        return map;
    }
}
