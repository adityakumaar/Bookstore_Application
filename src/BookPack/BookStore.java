package BookPack;

import java.util.ArrayList;

public class BookStore {
    /**
     * The BookStore class is used to manage a list of books, which is implemented using an ArrayList.
     * The class has methods to add books to the list, sell a book (decrementing its quantity), and display all the books in the list.
     */
    public ArrayList<Book> books;
    public ArrayList<PurchaseDetails> purchaseDB;

    public BookStore() {
        books = new ArrayList<Book>();
        purchaseDB = new ArrayList<PurchaseDetails>();
    }

    /**
     * This method populates the Bookstore inventory.
     * It is called from the Main method whenever the program is initiated.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     *  This method is used for fetching book details and assigning the book to the user
     *  This method takes the book id and the current user object as input
     *  This method returns -1 when the purchase is unsuccessful, 1 is the purchase is successful, 0 otherwise
     */
    public int sellBook(int bid, User u) {
        for (int i = 0; i < books.size(); i++) {

            // It calls the ArrayList books and tries to fetch the entries that matches the book id
            Book b = books.get(i);
            if (b.bid == bid) {
                // If a match is found and the quantity is more than 0, it checks if the user has sufficient balance to make the transaction
                if (b.quantity > 0 ) {
                    if(!(u.getBalance() >= b.price))
                        return -1;

                    // If the transaction is successful, the user's balance is updated by subtracting the book's price
                    u.updateBalance((int)b.price);
                    // Quantity of the book is reduced by 1
                    b.quantity--;
                    // A new object is made for the PurchaseDetails for the current user
                    PurchaseDetails pd = new PurchaseDetails(u.getUsername(), b.bid, b.title, b.price);
                    // This object is now inserted into the PurchaseDB ArrayList
                    purchaseDB.add(pd);
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
        return 0;
    }

    /*** This method displays all the books available in the inventory. */
    public void displayBooks() {
        System.out.println("------------------ List of Books -----------------------");
        System.out.println("Book ID         Title           Price           Quantity");

        // It iterates through the books ArrayList and display all the books
        for (int i = 0 ; i < books.size() ; i++)
            System.out.println(books.get(i));
    }

    /*** Method for displaying all the purchases. (for debugging purpose only.) */
    public void DisplayPurchaseRecords(){
        for(int i=0;i<purchaseDB.size();i++){
            purchaseDB.get(i).printRecord();
        }
    }
}
