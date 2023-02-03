package BookPack;

public class Book  {
    /**
     * Book class stores information about a book, such as its title, bid, price, and quantity.
     */
    int bid;
    public String title;
    double price;
    public int quantity;

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
