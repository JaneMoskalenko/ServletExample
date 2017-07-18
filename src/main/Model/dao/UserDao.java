package Model.dao;

import Model.POJOs.User;
import Model.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class UserDao implements IUserDao{
    private static Connection connection = ConnectionManager.getConnection();

    public  User getUserByLoginAndPassword(String login, String password) {
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

    public static HashMap<String, String> getAllUser(){
        HashMap<String, String> hmapUsers = new HashMap<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery
                    ("SELECT * FROM public.users");
            while (resultSet.next()){
                hmapUsers.put(resultSet.getString("login"),
                        resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hmapUsers;
    }

    public static ArrayList<User> getAllUserInObject(){
        ArrayList<User> userArrayList = new ArrayList<User>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery
                    ("SELECT * FROM public.users");
            while (resultSet.next()){
                User newUser = new User(resultSet.getString("login"),
                        resultSet.getString("password"));
                userArrayList.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userArrayList;
    }

    public static boolean deleteUserByLogin(String login){
        try (Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM public.users " +
                    "WHERE login = '" + login + "'";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean addUser(String login, String password){
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO public.users (login, password)" +
                    "VALUES ('" + login + "', '" + password + "')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
