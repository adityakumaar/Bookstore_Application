/**
 * Bookstore Application Java Project
 * Developed by:
 *              Team Charlie
 *              Aditya Kumar (202212046)
 *              Harsh Mangroliya (202212084)
 *              Gaurav Bardia (202212069)
 *              Denish Vaghasiya (202212028)
 */

import BookPack.Book;
import BookPack.BookStore;
import BookPack.PurchaseDetails;
import BookPack.UserOperations;

/**
 * Created a separate package for classes Book, Bookstore, and User and imported the package in Main.java file
 * Package name: BookPack
 */

public class Main {
    /*** HashMap stores all the registered users, where the username is the key and the User object is the value. */
    public static void main(String[] args) {
        /**
         * a BookStore object is created and some books are added to it.
         * Then the books are displayed, a book is sold, and the books are displayed again to show the updated quantity.
         */
        BookStore bookstore = new BookStore();
        bookstore.addBook(new Book(1,"Harry Potter", 20, 3));
        bookstore.addBook(new Book(2,"The Lord of ", 30, 2));
        bookstore.addBook(new Book(3,"The Hobbit  ", 40, 3));

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
            System.out.print("Enter your choice: ");
            int choice = UserOperations.scanner.nextInt();

            /** nested switch begins here. */
            switch (choice) {
                case 1:
                    if (UserOperations.register())
                        break;
                    else
                        continue;
                case 2:
                    if (UserOperations.login()) {
                        boolean f2 = true;
                        while(f2){
                            System.out.println("\nWelcome, "+UserOperations.active.getFullname());
                            bookstore.displayBooks();
                            System.out.println("\n1. Show Profile");
                            System.out.println("2. Purchase");
                            System.out.println("3. Logout");
                            System.out.print("Enter your choice: ");
                            choice = UserOperations.scanner.nextInt();

                            switch (choice) {
                                case 1:
                                    boolean f3 = true;
                                    boolean flag = false;
                                    while(f3){
                                        System.out.println("\nPurchase History :");

                                        for(int i = 0 ; i < bookstore.purchaseDB.size() ; i++){
                                            PurchaseDetails pd =  bookstore.purchaseDB.get(i);
                                            if(pd.returnUsername().equals(UserOperations.active.getUsername())){
                                                if(!flag)
                                                    System.out.println("Book ID\tBook Name\t\tPrice");
                                                pd.printRecord();
                                                flag = true;
                                            }
                                        }
                                        if(!flag)
                                            System.out.println("No record found");

                                        System.out.println("\nYour wallet balance : " + UserOperations.active.getBalance());

                                        System.out.println("\n1. Back to catalog");
                                        System.out.println("2. Logout");
                                        System.out.print("Enter your choice: ");
                                        choice = UserOperations.scanner.nextInt();
                                        //System.out.println("\n");
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
                                    System.out.println("\n");
                                    bookstore.displayBooks();
                                    UserOperations.purchase(bookstore);
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
                    //UserOperations.printUser();
                    UserOperations.resetPassword();
                    //UserOperations.printUser();
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
}
