package com.example.javaeefinal.dbmanager;

import javax.transaction.Transactional;
import java.sql.*;

@Transactional(Transactional.TxType.SUPPORTS)
public class DBManager {


    private static Connection connection;
    private static final String password = "dada2000";
    private static final String user = "postgres";
    private static final String url = "jdbc:postgresql://localhost:5432/Final";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Connecting to a selected database...");
            connection = DriverManager.getConnection(
                    url,
                    user,
                    password);
            System.out.println("Connected database successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
