package com.example.javaeefinal.repository;


import com.example.javaeefinal.dbmanager.DBManager;
import com.example.javaeefinal.model.*;
import com.google.gson.Gson;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.jms.*;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateful
@Transactional(Transactional.TxType.SUPPORTS)
public class Administration {


    @PersistenceContext
    private EntityManager em;

    private final Connection connection = DBManager.getConnection();

    @Resource(name = "MessageQueue")
    private Queue messageQueue;

    @Resource
    private ConnectionFactory connectionFactory;

    private final Gson gson;

    public Administration() {
        this.gson = new Gson();
    }

//    // TODO нужно доделать не работает персистенс кажется
//    public Response auth(String login, String password) throws Exception {
//        TypedQuery<Users> query = em.createNamedQuery(Users.FIND_BY_LOGIN_PASSWORD, Users.class);
//        query.setParameter("login", login);
//        query.setParameter("password",password);
//        Users users = query.getSingleResult();
//
//        if (users == null)
//            return Response.serverError().entity("Invalid email/password").build();
//
//        return Response.accepted().entity("Ok, successfully authorized!").build();
//    }


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
    public List<News> getNews() {
        List<News> news = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM news");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                news.add(new News(
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

        return news;
    }

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public List<Users> getUser() {
        List<Users> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Users\" ");

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                users.add(new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("secondname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("address_id"),
                        resultSet.getString("created_at")
                ));
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

        return users;
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
    public Response updateNews(String param, String value, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE news SET " + param + " = ? WHERE id = ?"
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
    public Response updateUser(String param, String value, int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE \"Users\" SET " + param + " = ? WHERE id = ?"
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

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public Response deleteNews(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM news WHERE id = ?"
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
    public Response deleteUser(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM \"Users\" WHERE id = ?"
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
    public Response createUser(Users users) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO \"Users\" (firstname,secondname,email,password,address_id) VALUES (?,?,?,?,?)"
            );
            statement.setString(1, users.getFirstName());
            statement.setString(2, users.getSecondName());
            statement.setString(3, users.getEmail());
            statement.setString(4, users.getPassword());
            statement.setInt(5, users.getAddress_id());

            int result = statement.executeUpdate();
            if (result == 1) return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity(e.getMessage()).build();
        }
        return Response.notModified().build();
        /* JSON for testing
         {
    "firstName":"Dav",
    "secondName":"Ushur",
    "email":"dushur@test.com",
    "password":"dada1234",
    "address_id":1
        }
        *
        * */
    }

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public String sendMessage(Users users) {
        try (final javax.jms.Connection connection = connectionFactory.createConnection();
             final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
             final MessageProducer producer = session.createProducer(messageQueue)) {
            connection.start();
            final Message jmsMessage = session.createTextMessage(gson.toJson(users));
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.setTimeToLive(0L);
            producer.send(jmsMessage);
            return "successfully sended";
        } catch (final Exception e) {
            throw new RuntimeException("Caught exception from JMS when sending a message", e);
        }
    }

    @Transactional(rollbackOn = SQLException.class,
            dontRollbackOn = EntityExistsException.class)
    @SuppressWarnings("SqlResolve")
    public String getMessage() {
        try (final javax.jms.Connection connection = connectionFactory.createConnection();
             final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
             final MessageConsumer messageConsumer = session.createConsumer(messageQueue)) {

            connection.start();

             final TextMessage textMessage = (TextMessage) messageConsumer.receive(10000);

            if (textMessage == null) {
                return "jmsMessage is null";
            }
            return textMessage.getText();

        } catch (final Exception e) {
            throw new RuntimeException("Caught exception from JMS when receiving a message", e);
        }
    }
}
