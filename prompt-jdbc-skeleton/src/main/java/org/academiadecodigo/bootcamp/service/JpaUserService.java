package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JpaUserService implements UserService {

    private final Connection dbConnection;
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public JpaUserService() {
        dbConnection = new ConnectionManager().getConnection();
        emf = Persistence.createEntityManagerFactory("mytest");
        em = emf.createEntityManager();
    }

    @Override
    public boolean authenticate(String username, String password) {

        boolean result = false;

        try {
            // ... connection and statements....
            String query = "SELECT * FROM user WHERE (username = ? AND password = ?)";
            PreparedStatement statement = dbConnection.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, password);

            // execute the query
            ResultSet resultSet = statement.executeQuery();

            // get the results
            if (resultSet.next()) {
                result = true;
            }

            statement.close();
        } catch (SQLException ex) {
            System.out.println("Failure to authenticate: " + ex.getMessage());
        }

        return result;
    }

    @Override
    public void add(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public User findByName(String username) {

        em.getTransaction().begin();
        User user = em.find(User.class, username);
        em.getTransaction().commit();

        return user;
    }

    @Override
    public User findById(Integer id) {

        em.getTransaction().begin();
        User user =  em.find(User.class, id);
        em.getTransaction().commit();

        return user;
    }

    @Override
    public List<User> findAll() {

        List<User> userList = new LinkedList<>();
        User user = new User();

        em.getTransaction().begin();
        //User user = em.find(User.class, );
        em.getTransaction().commit();

        return userList;
    }

    @Override
    public int count() {

        int result = 0;

        try {
            // create a new statement
            Statement statement = dbConnection.createStatement();

            // create a query
            String query = "SELECT COUNT(*) FROM user";

            // execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // get the results
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

            statement.close();
        } catch (SQLException ex) {
            System.out.println("Failure to count: " + ex.getMessage());
        }

        return result;
    }

}
