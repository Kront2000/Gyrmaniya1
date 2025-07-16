package Service;

public class LoginService {
    final static String LOGIN = "admin";
    final static String PASSWORD = "1a2s3d4f";
    private static final LoginService INSTANCE = new LoginService();

    public boolean login(String login, String password){
        if(login.equals(LOGIN) && password.equals(PASSWORD)){
            return true;
        } else{
            return false;
        }
    }
    public static LoginService getInstance(){
        return INSTANCE;
    }

    private LoginService(){}
}
