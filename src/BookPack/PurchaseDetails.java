package BookPack;

public class PurchaseDetails {
    String username;
    int bid;
    public String title;
    double price;

    public PurchaseDetails(String username,int bid,String title,double price){
        this.username = username;
        this.bid = bid;
        this.title = title;
        this.price = price;
    }

    public void printRecord(){
        System.out.println(this.username+" "+this.bid+" "+this.title+" "+this.price);
    }

//    public PurchaseDetails() {
//    }
}
