package BookPack;

public class Book  {
    /**
     * Book class stores information about a book, such as its title, bid, price, and quantity.
     */
    // Stores the book id
    int bid;
    // Stores the book title
    public String title;
    // Stores the book price
    double price;
    // Stores the book quantity
    public int quantity;

    /**
     * This constructor assigns the values of parameters to the local variables for creating an entry in the books ArrayList.
     */
    public Book(int bid, String title, double price, int quantity) {
        this.bid = bid;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString() {
        return bid + "               " + title +  "    " + price + "            " + quantity;
    }
}
