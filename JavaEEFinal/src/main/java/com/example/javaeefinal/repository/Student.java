package com.example.javaeefinal.repository;

import com.example.javaeefinal.dbmanager.DBManager;
import com.example.javaeefinal.model.Building;
import com.example.javaeefinal.model.BuildingCategory;

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
public class Student {
    private final Connection connection = DBManager.getConnection();



    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public List<Building> getBuildings() {
        List<Building> buildings = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM building");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                buildings.add(new Building(
                        resultSet.getInt("id"),
                        resultSet.getDouble("rating"),
                        resultSet.getString("contactnumber"),
                        resultSet.getInt("address_id"),
                        resultSet.getString("created_at")
                ));
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buildings;
    }

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public List<BuildingCategory> getBuildingCategory() {
        List<BuildingCategory> buildingCategories = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM buildingcategory");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                buildingCategories.add(new BuildingCategory(
                        resultSet.getInt("id"),
                        resultSet.getInt("building_id"),
                        resultSet.getString("created_at")
                ));
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return buildingCategories;
    }

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public Response updateBuilding(String param, String value, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE building SET " + param + " = ? WHERE id = ?"
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
    public Response updateBuildingCategory(String param, String value, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE buildingcategory SET " + param + " = ? WHERE id = ?"
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
    public Response deleteBuilding(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM building WHERE id = ?"
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

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public Response deleteBuildingCategory(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM buildingcategory WHERE id = ?"
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
