package dao;

import POJOs.User;
import connection.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by admin on 01.07.2017.
 */
public class UserDao {

    public static User getUserByLoginAndPassword(String login, String password) {

        Connection connection = ConnectionManager.getConnection();
        User user = null;

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery
                    ("Select * from public.users WHERE login='"
                            +login
                            +"' AND password='"+ password +"'");

            while (resultSet.next()){
                user = new User(resultSet.getString(1),
                        resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
