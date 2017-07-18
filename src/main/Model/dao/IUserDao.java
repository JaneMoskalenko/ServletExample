package Model.dao;


import Model.POJOs.User;

import java.util.HashMap;

public interface IUserDao {

   /* public  boolean addUser(String login, String password);

    public  boolean deleteUserByLogin(String login);*/

    public User getUserByLoginAndPassword(String login, String password);

    /*public  HashMap<String, String> getAllUser();*/
}
