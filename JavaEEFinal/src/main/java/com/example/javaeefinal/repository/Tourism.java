package com.example.javaeefinal.repository;


import com.example.javaeefinal.dbmanager.DBManager;
import com.example.javaeefinal.model.Address;

import javax.ejb.Stateful;
import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class Tourism {
    private final Connection connection = DBManager.getConnection();

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public List<Address> getAddresses() {
        List<Address> addresses = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM address");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                addresses.add(new Address(
                        resultSet.getInt("id"),
                        resultSet.getString("city"),
                        resultSet.getString("streetName"),
                        resultSet.getString("streetNumber"),
                        resultSet.getString("created_at")
                ));
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addresses;
    }


    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public Response updateAddress(String param, String value, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE address SET " + param + " = ? WHERE id = ?"
            );

            statement.setString(1, value);
            statement.setInt(2, id);

            System.out.println(statement);
            int result = statement.executeUpdate();

            if (result == 1) return Response.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity(e.getMessage()).build();
        }
        return Response.notModified().build();
    }

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public Response deleteAddress(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM address WHERE id = ?"
            );
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            if (result == 1) return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity(e.getMessage()).build();
        }
        return Response.notModified().build();
    }
}
