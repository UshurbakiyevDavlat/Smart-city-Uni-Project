package com.example.javaeefinal.repository;


import com.example.javaeefinal.dbmanager.DBManager;

import javax.ejb.Stateful;
import java.sql.Connection;

@Stateful
public class Jobseekers {

    private final Connection connection = DBManager.getConnection();
}
