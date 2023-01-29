import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.io.Console;

class User {
    /**
     * User class that stores the username and password of a user.
     */
    private String username;
    private String password;
    User(String username, String password) {
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
class Book {
    /**
     * Book class stores information about a book, such as its title, author, price, and quantity.
     */
    String title;
    String author;
    double price;
    int quantity;
    Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nPrice: " + price + "\nQuantity: " + quantity;
    }
}
class BookStore {
    /**
     * The BookStore class is used to manage a list of books, which is implemented using an ArrayList.
     * The class has methods to add books to the list, sell a book (decrementing its quantity), and display all the books in the list.
     */
    ArrayList<Book> books;
    BookStore() {
        books = new ArrayList<Book>();
    }
    void addBook(Book book) {
        books.add(book);
    }
    void sellBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).title.equals(title)) {
                if (books.get(i).quantity > 0) {
                    books.get(i).quantity--;
                    System.out.println("Book sold!");
                    return;
                } else {
                    System.out.println("Book out of stock!");
                    return;
                }
            }
        }
        System.out.println("Book not found!");
    }
    void displayBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
}

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
        bookstore.addBook(new Book("Harry Potter", "J.K. Rowling", 15.99, 10));
        bookstore.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", 20.99, 5));
        bookstore.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 12.99, 8));

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
        while(true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (register()) continue;
                case 2:
                    if (login()) {
                        //BookStore bookstore = new BookStore();
                        bookstore.displayBooks();
                        bookstore.sellBook("Harry Potter");
                        bookstore.displayBooks();
                        break;
                    }
                    continue;
                default:
                    System.out.println("Invalid choice.");
                        break;
            }
        }
    }

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
}
