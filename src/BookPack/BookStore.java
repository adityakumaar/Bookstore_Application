package BookPack;

import java.util.ArrayList;

public class BookStore {
    /**
     * The BookStore class is used to manage a list of books, which is implemented using an ArrayList.
     * The class has methods to add books to the list, sell a book (decrementing its quantity), and display all the books in the list.
     */
    ArrayList<Book> books;
    public BookStore() {
        books = new ArrayList<Book>();
    }
    public void addBook(Book book) {
        books.add(book);
    }

    /*** The sellBook returns true if the book is in inventory otherwise it returns false. */
    public boolean sellBook(int bid) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).bid == bid) {
                if (books.get(i).quantity > 0) {
                    books.get(i).quantity--;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    public void displayBooks() {
        System.out.println("Book ID         Title           Price           Quantity");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
}
