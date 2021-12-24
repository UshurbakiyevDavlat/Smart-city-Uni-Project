package com.example.javaeefinal.repository;


import com.example.javaeefinal.dbmanager.DBManager;
import com.example.javaeefinal.model.VacancyCategory;
import com.example.javaeefinal.model.HR;
import com.example.javaeefinal.model.Vacancy;

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
public class Jobseekers {

    private final Connection connection = DBManager.getConnection();

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public List<VacancyCategory> getCategory() {
        List<VacancyCategory> vacancyCategory = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vacancyCategory.add(new VacancyCategory(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("created_at")
                ));
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vacancyCategory;
    }

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public List<HR> getHumanResources() {
        List<HR> humanResources = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM humanresources");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                humanResources.add(new HR(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("secondname"),
                        resultSet.getString("email"),
                        resultSet.getString("contactnumber"),
                        resultSet.getString("created_at")
                ));
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return humanResources;
    }

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public List<Vacancy> getJob() {
        List<Vacancy> vacancies = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM job");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vacancies.add(new Vacancy(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDouble("salary"),
                        resultSet.getInt("hr_id"),
                        resultSet.getString("created_at")
                ));
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vacancies;
    }

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public Response updateCategory(String param, String value, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE category SET " + param + " = ? WHERE id = ?"
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
    public Response updateHumanResources(String param, String value, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE humanresources SET " + param + " = ? WHERE id = ?"
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
    public Response updateJob(String param, String value, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE job SET " + param + " = ? WHERE id = ?"
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
    public Response deleteCategory(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM category WHERE id = ?"
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
    public Response deleteHumanResources(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM humanresources WHERE id = ?"
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
    public Response deleteJob(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM job WHERE id = ?"
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
