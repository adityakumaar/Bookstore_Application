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
import BookPack.Book;
import BookPack.BookStore;
import BookPack.User;

/**
 * Created a separate package for classes Book, Bookstore, and User and imported the package in Main.java file
 * Package name: BookPack
 */


public class Main {
    static Scanner scanner = new Scanner(System.in);
    /**
     * HashMap stores all the registered users, where the username is the key and the User object is the value.
     */
    static HashMap<String, User> users = new HashMap<>();
    public static void main(String[] args) {
        /**
         * a BookStore object is created and some books are added to it.
         * Then the books are displayed, a book is sold, and the books are displayed again to show the updated quantity.
         */
        BookStore bookstore = new BookStore();
        bookstore.addBook(new Book(1,"Harry Potter", 20, 3));
        bookstore.addBook(new Book(2,"The Lord of.", 30, 2));
        bookstore.addBook(new Book(3,"The Hobbit..", 40, 3));

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
            System.out.println("1. Register");
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
                case 2:
                    if (login()) {
                        boolean f2 = true;
                        while(f2){
                            //BookStore bookstore = new BookStore();
                            bookstore.displayBooks();
                            //bookstore.sellBook("Harry Potter");
                            //bookstore.displayBooks();
                            System.out.println("1. Show Profile");
                            System.out.println("2. Purchase");
                            System.out.println("3. Logout");
                            System.out.println("Enter your choice: ");
                            choice = scanner.nextInt();

                            switch (choice) {
                                case 1:
                                    //show_profile();
                                    boolean f3 = true;
                                    while(f3){
                                        System.out.println("1. Back to catalog");
                                        System.out.println("2. Logout");
                                        System.out.println("Enter your choice: ");
                                        choice = scanner.nextInt();

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
                                    if(purchase(bookstore)){
                                        System.out.println("Book sold!");
                                    }
                                    else {
                                        System.out.println("Book out of stock!");
                                    }
                                    bookstore.displayBooks();
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
                    //resetPassword();
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
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        User user = new User(username, password);
        users.put(username, user);
        System.out.println("User registered successfully.");
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
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
        return false;
    }

    /*** method for purchasing books */
    static boolean purchase(BookStore b) {
        System.out.println("Enter the Book ID for purchasing: ");
        int bid = scanner.nextInt();
        if(b.sellBook(bid)) {
            return true;
        }
        else {
            return false;
        }
    }
}
