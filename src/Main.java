import java.util.ArrayList;

class Book {
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
    public static void main(String[] args) {
        BookStore bookstore = new BookStore();
        bookstore.addBook(new Book("Harry Potter", "J.K. Rowling", 15.99, 10));
        bookstore.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", 20.99, 5));
        bookstore.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 12.99, 8));

        bookstore.displayBooks();
        bookstore.sellBook("Harry Potter");
        bookstore.displayBooks();
    }
}
