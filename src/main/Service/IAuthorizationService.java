package Service;

/**
 * Created by admin on 11.07.2017.
 */
public interface IAuthorizationService {

    boolean auth(String login, String password);
}
