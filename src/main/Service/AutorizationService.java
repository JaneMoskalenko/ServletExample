import dao.UserDao;

/**
 * Created by admin on 01.07.2017.
 */
public class AutorizationService {
    public static boolean auth (String login, String password){
        if (UserDao.getUserByLoginAndPassword(login, password) != null)
            return  true;
        else
            return false;
    }
}
