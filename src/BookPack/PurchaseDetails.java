package BookPack;

public class PurchaseDetails {
    /**
     * PurchaseDetails class stores the username, bid, title, price of the buyer.
     */

    String username;
    int bid;
    public String title;
    double price;

    public PurchaseDetails(String username, int bid, String title, double price){
        this.username = username;
        this.bid = bid;
        this.title = title;
        this.price = price;
    }

    public String returnUsername(){
        return this.username;
    }

    public void printRecord(){
        System.out.println(this.bid + "\t\t" + this.title + "\t" + this.price);
    }
}
