package BookPack;

public class PurchaseDetails {
    /**
     * PurchaseDetails class stores the username, bid, title, price.
     */

    // Stores the username of the current user
    String username;
    // Stores the book id of the book that is purchased
    int bid;
    // Stores the title of the book that is purchased
    public String title;
    // Stores the price of the book that is purchased
    double price;

    /**
     *  This constructor assigns the values of the parameters to the local variables for creating an entry in the purchaseDB ArrayList.
     */
    public PurchaseDetails(String username, int bid, String title, double price){
        this.username = username;
        this.bid = bid;
        this.title = title;
        this.price = price;
    }

    /**
     * This method returns the username of the current user
     */
    public String returnUsername(){
        return this.username;
    }

    /**
     * This method displays the book id, book title, book price for the books purchased by the current user
     */
    public void printRecord(){
        System.out.println(this.bid + "\t\t" + this.title + "\t" + this.price);
    }
}
