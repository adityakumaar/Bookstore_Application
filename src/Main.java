/**
 * Bookstore Application Java Project
 * Developed by:
 *              Team Charlie
 *              Aditya Kumar (202212046)
 *              Harsh Mangroliya (202212084)
 *              Gaurav Bardia (202212069)
 *              Denish Vaghasiya (202212028)
 */


/**
 * Created a separate package for classes
 *      Book,
 *      Bookstore,
 *      User,
 *      PurchaseDetails,
 *      UserOperations,
 * and imported the package in Main.java file
 * Package name: BookPack
 */
import BookPack.Book;
import BookPack.BookStore;
import BookPack.PurchaseDetails;
import BookPack.UserOperations;

public class Main {
    public static void main(String[] args) {
        /** A BookStore object is created and some books are added to it. */
        BookStore bookstore = new BookStore();
        bookstore.addBook(new Book(1,"Harry Potter", 20, 3));
        bookstore.addBook(new Book(2,"The Lord    ", 30, 2));
        bookstore.addBook(new Book(3,"The Hobbit  ", 40, 3));
        //bookstore.addBook(new Book(3,"Jack Ryan   ", 20, 5));

        boolean f1 = true;
        while(f1) {
            // The main menu is displayed in the beginning, this menu is wrapped inside an infinite while loop,
            // It will break when the user chooses to Exit the program
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Forgot password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = UserOperations.scanner.nextInt();

            /** Nested switch begins here. */
            switch (choice) {
                case 1:
                    // The register method from the UserOperations class is called
                    UserOperations.register();
                    break;
                case 2:
                    // If the login method from the UserOperations class returns true, the user is allowed to move ahead
                    if (UserOperations.login()) {
                        boolean f2 = true;
                        while(f2){
                            // The menu is displayed after the user has successfully logged in,
                            // This menu is wrapped inside an infinite while loop
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
                                        // This menu is displayed after the user selects the Show Profile option
                                        // This menu is also wrapped inside an infinite while loop
                                        System.out.println("\nPurchase History :");

                                        // The complete list of the books bought by the user is displayed from the purchaseDB ArrayList
                                        for(int i = 0 ; i < bookstore.purchaseDB.size() ; i++){
                                            PurchaseDetails pd =  bookstore.purchaseDB.get(i);
                                            if(pd.returnUsername().equals(UserOperations.active.getUsername())){
                                                if(!flag)
                                                    System.out.println("Book ID\tBook Name\t\tPrice");

                                                // The printRecord method is called which returns the books purchased by the current user
                                                pd.printRecord();
                                                flag = true;
                                            }
                                        }
                                        // The following if block handles the case when there are no books purchased by the current user
                                        if(!flag)
                                            System.out.println("No record found");

                                        // The wallet balance of the current user is displayed
                                        System.out.println("\nYour wallet balance : " + UserOperations.active.getBalance());

                                        // The following menu is displayed to the user
                                        System.out.println("\n1. Back to catalog");
                                        System.out.println("2. Logout");
                                        System.out.print("Enter your choice: ");
                                        choice = UserOperations.scanner.nextInt();
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

                                    // All the books are displayed that are available in the books ArrayList in the BookStore class
                                    bookstore.displayBooks();

                                    // The user is asked for the book id for purchasing
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
