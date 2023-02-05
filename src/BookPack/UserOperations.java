package BookPack;

import java.util.*;
import java.io.Console;

public class UserOperations {
    /*** HashMap stores all the registered users, where the username is the key and the User object is the value. */
    public static HashMap<String, User> users = new HashMap<>();

    /*** The scanner object is used for taking inputs from the console */
    public  static Scanner scanner = new Scanner(System.in);

    /** This is an object for currently logged-in user */
    public static User active;

    /*** Method for user registration of new user */
    public static void register() {
        System.out.print("\nEnter your full name: ");
        String fname = null, lname = null;
        fname = scanner.next();
        lname = scanner.next();
        String fullname = fname + " " + lname;

        System.out.print("Enter your username: ");
        String username = scanner.next();

        /** The following if block checks for the username if it already exists in the users HashMap */
        User user = UserOperations.users.get(username);
        if(user != null && user.getUsername().equals(username)){
            boolean flag = true;
            while(flag) {
                System.out.println("\nUser already exists.");
                System.out.print("Enter your username: ");
                username = scanner.next();

                if(!user.getUsername().equals(username))
                    flag = false;
            }
        }

        /** If the username does not exist the user is asked for entering the password. */
        String password1 = null ,password2 = null;
        boolean f1 = true;
        /** The following while loop runs infinitely till both the passwords match */
        while(f1) {
            //uncomment the following lines for running in intelliJ IDEA
            System.out.print("Enter your password: ");
            password1 = scanner.next();
            System.out.print("Re-enter your password: ");
            password2 = scanner.next();

            //uncomment the following lines for running in VS Code
            //Console cnsl = System.console();
            //if(cnsl == null) {
            //    System.out.println("No console available.");
            //}
            //char[] passwd1 = cnsl.readPassword("Enter your password: ");
            //password1 = new String(passwd1);
            //char[] passwd2 = cnsl.readPassword("Re-enter your password: ");
            //password2 = new String(passwd2);

            if(password1.equals(password2))
                f1=false;
            else
                System.out.println("\nPlease enter same password\n");
        }

        /** A new user with a default balance of 50 credits is registered after the user successfully enters the Fullname, Username, Password */
        user = new User(username, password1, fullname, 50);
        UserOperations.users.put(username, user);
        System.out.println("\nUser registered successfully.");
    }

    /*** Method for user login */
    public static boolean login() {
        System.out.print("\nEnter your username: ");
        String username = scanner.next();

        //uncomment the following lines for running in intelliJ IDEA
        System.out.print("Enter your password: ");
        String password = scanner.next();

        //uncomment the following lines for running in VS Code
        //Console cnsl = System.console();
        //if(cnsl == null) {
        //    System.out.println("No console available.");
        //}
        //char[] passwd = cnsl.readPassword("Enter password: ");
        //String password = new String(passwd);

        User user = UserOperations.users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("\nLogin successfully.");
            UserOperations.active = user;
            return true;
        } else {
            System.out.println("\nLogin failed. Invalid username or password.");
        }
        return false;
    }

    /**
     * Method for purchasing books
     * This method accepts an object to the BookStore class
     **/
    public static void purchase(BookStore b) {
        // The wallet balance of the current user is displayed
        System.out.println("Your wallet balance is : " + active.getBalance());

        // User is asked to enter the Book ID for purchasing the book
        System.out.print("\nEnter the Book ID for purchasing: ");
        int bid = scanner.nextInt();

        // The sellBook method is called from the BookStore class
        int result = b.sellBook(bid, UserOperations.active);

        // Depending on the returned value form the sellBook method (-1, 1, or 0) a message is displayed to the current user
        if(result == 1) {
            System.out.println("\nBook Purchased successfully");
        }
        else if (result == -1) {
            System.out.println("Your wallet balance is not sufficient");
        }
        else {
            System.out.println("Book is out of stock");
        }
    }

    /**
     * Method for resetting password
     * This method takes the fullname, username of the user for validation before allowing to reset the password
     **/
    public static boolean resetPassword() {
        System.out.print("\nEnter your fullname: ");
        String fname = null , lname = null;
        fname = scanner.next();
        lname =  scanner.next();
        String fullname = fname+" "+lname;
        System.out.print("Enter your username: ");
        String username = scanner.next();
        User user = UserOperations.users.get(username);

        /*** Only the existing user can reset the password. */
        if (user != null && user.getUsername().equals(username) && user.getFullname().equals(fullname)) {
            boolean flag = true;
            while(flag) {
                //uncomment the following lines for running in intelliJ IDEA
                System.out.print("Enter your new password: ");
                String password1 = scanner.next();
                System.out.print("Re-enter your new password: ");
                String password2 = scanner.next();

                //uncomment the following lines for running in VS Code
                //Console cnsl = System.console();
                //if(cnsl == null) {
                //    System.out.println("No console available.");
                //}
                //char[] passwd1 = cnsl.readPassword("Enter your new password: ");
                //String password1 = new String(passwd1);
                //char[] passwd2 = cnsl.readPassword("Re-enter your new password: ");
                //String password2 = new String(passwd2);

                if(password1.equals(password2)){
                    flag = false;
                    System.out.println("\nPassword reset successfully.");
                    user.setPassword(password1);
                }
                else
                    System.out.println("\nPlease enter same password.");
            }
            return true;
        }
        System.out.println("\nNo such user exists.");
        return false;
    }

    /** This method sets the current user object as null and logs the user out */
    public static boolean logout() {
        UserOperations.active = null;
        return true;
    }

    /*** HashMap iterator for displaying all the users. (for debugging purpose only) */
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
