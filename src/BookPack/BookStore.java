package BookPack;

import java.util.ArrayList;

public class BookStore {
    /**
     * The BookStore class is used to manage a list of books, which is implemented using an ArrayList.
     * The class has methods to add books to the list, sell a book (decrementing its quantity), and display all the books in the list.
     */
    ArrayList<Book> books;
    ArrayList<PurchaseDetails> purchaseDB;

    public BookStore() {
        books = new ArrayList<Book>();
        purchaseDB = new ArrayList<PurchaseDetails>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean sellBook(int bid, String username) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).bid == bid) {
                if (books.get(i).quantity > 0) {
                    books.get(i).quantity--;
                    Book temp = books.get(i);
                    PurchaseDetails pd = new PurchaseDetails(username,temp.bid,temp.title,temp.price);

                    purchaseDB.add(pd);
                    DisplayPurchaseRecords();
                    //System.out.println("Book sold!");
                    return true;
                } else {
                   // System.out.println("Book out of stock!");
                    return false;
                }
            }
        }
        return false;
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
