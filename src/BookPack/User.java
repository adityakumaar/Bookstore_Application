package BookPack;

//import java.util.HashMap;
public class User {
    /**
     * User class that stores the username and password of a user.
     */
    private String username;
    private String password;
    private String fullname;
    private int balance;

    public User(String username, String password, String fullname, int balance) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.balance = balance;
    }

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
    public String getFullname() {
        return fullname;
    }
    public int getBalance() {
        return balance;
    }
    public void setPassword(String newPass) {
        this.password = newPass;
    }
}
