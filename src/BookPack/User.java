package BookPack;

//import java.util.HashMap;
public class User {
    /**
     * User class that stores the username and password of a user.
     */
    private String username;
    private String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}