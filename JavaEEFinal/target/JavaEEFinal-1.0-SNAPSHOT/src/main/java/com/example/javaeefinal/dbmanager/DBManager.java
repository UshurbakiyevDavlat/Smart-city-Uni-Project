package com.example.javaeefinal.dbmanager;

import com.example.javaeefinal.model.Address;
import com.example.javaeefinal.model.User;

import javax.ejb.Stateful;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class DBManager {

    private static Connection connection;
    private static String password = "dada2000";
    private static String user = "postgres";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Final",
                    user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Address> getAddresses() {
        List<Address> addresses = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Address\"");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                addresses.add(new Address(
                        resultSet.getInt("id"),
                        resultSet.getString("city"),
                        resultSet.getString("streetName"),
                        resultSet.getString("streetNumber")
                ));
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addresses;
    }

//    public static List<User> getUsers () {
//
//    }
}
