package Service;

import Model.dao.IUserDao;
import Model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 01.07.2017.
 */
public class AutorizationService {
    /*public static boolean auth (String login, String password){
        if (UserDao.getUserByLoginAndPassword(login, password) != null)
            return  true;
        else
            return false;
    }*/

    @Autowired
    IUserDao iUserDao;

    public boolean auth (String login, String password){
        if (iUserDao.getUserByLoginAndPassword(login, password) != null)
            return  true;
        else
            return false;
    }
}
