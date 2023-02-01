/**
 * Bookstore Application Java Project
 * Developed by:
 *              Team Charlie
 *              Aditya Kumar (202212046)
 *              Harsh Mangroliya (202212084)
 *              Gaurav Bardia (202212069)
 *              Denish Vaghasiya (202212028)
 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;

import BookPack.Book;
import BookPack.BookStore;
import BookPack.PurchaseDetails;
import BookPack.User;

/**
 * Created a separate package for classes Book, Bookstore, and User and imported the package in Main.java file
 * Package name: BookPack
 */

public class Main {
    static Scanner scanner = new Scanner(System.in);
    /*** HashMap stores all the registered users, where the username is the key and the User object is the value. */
    static HashMap<String, User> users = new HashMap<>();

    static User active;

    public static void main(String[] args) {
        /**
         * a BookStore object is created and some books are added to it.
         * Then the books are displayed, a book is sold, and the books are displayed again to show the updated quantity.
         */

        BookStore bookstore = new BookStore();
        bookstore.addBook(new Book(1,"Harry Potter", 20, 3));
        bookstore.addBook(new Book(2,"The Lord of ", 30, 2));
        bookstore.addBook(new Book(3,"The Hobbit  ", 40, 3));

        //bookstore.displayBooks();
        //bookstore.sellBook("Harry Potter");
        //bookstore.displayBooks();

        /**
         * A menu is displayed to the user asking whether they want to register or login.
         * If the user selects "register", the program calls the register method,
         * which prompts the user for their username and password and creates a User object with that information.
         * The User object is then added to the HashMap of users. If the user selects "login",
         * the program calls the login method, which prompts the user for their username and password.
         */
        boolean f1 = true;
        while(f1) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Forgot password");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            /** nested switch begins here. */
            switch (choice) {
                case 1:
                    if (register())
                        break;
                    else
                        continue;
                case 2:
                    if (login()) {
                        boolean f2 = true;
                        while(f2){
                            System.out.println("\nWelcome, "+active.getFullname());
                            bookstore.displayBooks();
                            System.out.println("1. Show Profile");
                            System.out.println("2. Purchase");
                            System.out.println("3. Logout");
                            System.out.println("Enter your choice: ");
                            choice = scanner.nextInt();

                            switch (choice) {
                                case 1:
                                    //show_profile();
                                    boolean f3 = true;
                                    boolean flag = false;
                                    while(f3){
                                        System.out.println("\nPurchase History :");
                                        for(int i=0;i<bookstore.purchaseDB.size();i++){
                                            PurchaseDetails tmp =  bookstore.purchaseDB.get(i);
                                            if(tmp.returnUsername().equals(active.getUsername())){
                                                tmp.printRecord();
                                                flag = true;
                                            }
                                        }
                                        System.out.println("\nYour wallet balance : "+active.getBalance());

                                        if(!flag)
                                            System.out.println("No record found");
                                        System.out.println("\n1. Back to catalog");
                                        System.out.println("2. Logout");
                                        System.out.println("\nEnter your choice: ");
                                        choice = scanner.nextInt();
                                        System.out.println("\n");
                                        switch (choice) {
                                            case 1:
                                                f3 = false;
                                                break;
                                            case 2:
                                                f3 = false;
                                                f2 = false;
                                                break;
                                            default:
                                                System.out.println("Invalid choice.");
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
                                    bookstore.displayBooks();
                                    purchase(bookstore);
                                    break;
                                case 3:
                                    f2 = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                        }
                    }
                    break;
                case 3:
                    printUser();
                    resetPassword();
                    printUser();
                    break;
                case 4:
                    f1 = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    /*** method for user registration */
    static boolean register() {
        System.out.print("Enter your full name: ");
        String fullname = scanner.next();
        System.out.print("Enter your username: ");
        String username = scanner.next();
        String password=null ,password2 = null;
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
        User user = users.get(username);
        /*** Same user can not register twice. */
        if (user != null && user.getUsername().equals(username)) {
            System.out.println("\nUser already exists.");
            return false;
        }
        user = new User(username, password, fullname, 50);
        users.put(username, user);
        System.out.println("\nUser registered successfully.");
        return true;
    }

    /*** method for user login */
    static boolean login() {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successfully.");
//            System.out.println(user.getFullname());
//            System.out.println(user.getBalance());
            active = user;
            return true;
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
        return false;
    }

    /*** method for purchasing books */
    static void purchase(BookStore b) {
        System.out.println("Enter the Book ID for purchasing: ");

        int bid = scanner.nextInt();
        int result = b.sellBook(bid, active);
        if(result == 1) {
            System.out.println("Book Purchased successfully");
        }
        else if (result == -1) {
            System.out.println("Your wallet balance is not sufficient");
        }
        else {
            System.out.println("Book !!Out of stock");
        }
    }

    /*** method for resetting password */
    static boolean resetPassword() {
        System.out.print("Enter your fullname: ");
        String fullname = scanner.next();
        System.out.print("Enter your username: ");
        String username = scanner.next();
        User user = users.get(username);
        /*** Existing user can reset the password. */
        if (user != null && user.getUsername().equals(username) && user.getFullname().equals(fullname)) {
            System.out.print("Enter your new password: ");
            String password = scanner.next();
            user.setPassword(password);
            System.out.println("Password reset successfully.");
            return true;
        }
        System.out.println("No such user exists.");
        return false;
    }

    //HashMap iterator for debugging.
    public static void printUser() {
        Iterator<Entry<String, User>> new_Iterator = users.entrySet().iterator();
        while (new_Iterator.hasNext()) {
            Map.Entry<String, User> new_Map = (Map.Entry<String, User>)
                    new_Iterator.next();
            User temp = new_Map.getValue();
            // Displaying HashMap
            System.out.println(new_Map.getKey()+"  fn:"+temp.getFullname()+" u:"+temp.getUsername()+" p:"+temp.getPassword()+"\n");
        }
    }
}
