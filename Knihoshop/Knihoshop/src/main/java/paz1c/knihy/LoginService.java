package paz1c.knihy;

public class LoginService {
    private static final String DEFAULT_LOGIN = "admin";

    private static final String DEFAULT_PASSWORD = "admin";

    boolean login(String login, String password) {
        return DEFAULT_LOGIN.equals(login) && DEFAULT_PASSWORD.equals(password);
    }       
}

 
        
