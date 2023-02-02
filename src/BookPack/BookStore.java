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

    public void addBook(Book book) {
        books.add(book);
    }

    public int sellBook(int bid, User u) {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.bid == bid) {
                if (b.quantity > 0 ) {
                    if(!(u.getBalance() >= b.price))
                        return -1;

                    u.updateBalance((int)b.price);
                    b.quantity--;
                    PurchaseDetails pd = new PurchaseDetails(u.getUsername(), b.bid, b.title, b.price);
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
    public void displayBooks() {
        System.out.println("Book ID         Title           Price           Quantity");
        for (int i = 0; i < books.size(); i++)
            System.out.println(books.get(i));
    }

    public void DisplayPurchaseRecords(){
        for(int i=0;i<purchaseDB.size();i++){
            purchaseDB.get(i).printRecord();
        }
    }
}
