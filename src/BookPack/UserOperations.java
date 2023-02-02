package BookPack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class UserOperations {
    public static HashMap<String, User> users = new HashMap<>();
    public  static Scanner scanner = new Scanner(System.in);
    public static User active;

    /*** method for user registration */
    public static boolean register() {
        System.out.print("\nEnter your full name: ");
        String fname = null , lname = null;
        fname = scanner.next();
        lname = scanner.next();
        String fullname = fname + " " + lname;
        System.out.print("Enter your username: ");
        String username = scanner.next();
        String password = null ,password2 = null;
        boolean f1 = true;
        while(f1) {
            System.out.print("Enter your password: ");
            password = scanner.next();
            System.out.print("Re-enter your password: ");
            password2 = scanner.next();
            if(password.equals(password2))
                f1=false;
            else
                System.out.println("\nPlease enter same password\n");

        }
        User user = UserOperations.users.get(username);
        /*** Same user can not register twice. */
        if (user != null && user.getUsername().equals(username)) {
            System.out.println("\nUser already exists.");
            return false;
        }
        user = new User(username, password, fullname, 50);
        UserOperations.users.put(username, user);
        System.out.println("\nUser registered successfully.");
        return true;
    }

    /*** method for user login */
    public static boolean login() {
        System.out.print("\nEnter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        User user = UserOperations.users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successfully.");
            UserOperations.active = user;
            return true;
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
        return false;
    }

    /*** method for purchasing books */
    public static void purchase(BookStore b) {
        System.out.println("Your wallet balance is : "+active.getBalance());
        System.out.print("\nEnter the Book ID for purchasing: ");
        int bid = scanner.nextInt();
        int result = b.sellBook(bid, UserOperations.active);
        if(result == 1) {
            System.out.println("Book Purchased successfully");
        }
        else if (result == -1) {
            System.out.println("Your wallet balance is not sufficient");
        }
        else {
            System.out.println("Book is out of stock");
        }
    }

    /*** method for resetting password */
    public static boolean resetPassword() {
        System.out.print("Enter your fullname: ");
        String fname = null , lname = null;
        fname = scanner.next();
        lname =  scanner.next();
        String fullname = fname+" "+lname;
        System.out.print("Enter your username: ");
        String username = scanner.next();
        User user = UserOperations.users.get(username);
        /*** Existing user can reset the password. */
        if (user != null && user.getUsername().equals(username) && user.getFullname().equals(fullname)) {
            boolean flag = true;
            while(flag) {
                System.out.print("Enter your new password: ");
                String password = scanner.next();
                System.out.print("Re-enter your new password: ");
                String password2 = scanner.next();
                if(password.equals(password2)){
                    flag = false;
                    System.out.println("Password reset successfully.");
                    user.setPassword(password);
                }
                else
                    System.out.println("!! Please enter same password");
            }
            return true;
        }
        System.out.println("No such user exists.");
        return false;
    }

    /*** HashMap iterator for displaying all the users. */
    public static void printUser() {
        Iterator<Map.Entry<String, User>> new_Iterator = UserOperations.users.entrySet().iterator();
        while (new_Iterator.hasNext()) {
            Map.Entry<String, User> new_Map = (Map.Entry<String, User>)
                    new_Iterator.next();
            User temp = new_Map.getValue();
            // Displaying HashMap
            System.out.println(new_Map.getKey() + "  fn:" + temp.getFullname() + " u:" + temp.getUsername() + " p:" + temp.getPassword() + "\n");
        }
    }
}
