import javax.ejb.Local;

@Local
public class ShoppingCart {
    private String customer_name;
    private String bookname;
    private String bookauthor;
    private int bookprice;

    public ShoppingCart(String customer_name, String bookname, String bookauthor, int bookprice) {
        this.customer_name = customer_name;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookprice = bookprice;
    }

    public ShoppingCart() {
        super();
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getBookname() {
        return bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public int getBookprice() {
        return bookprice;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public void setBookprice(int bookprice) {
        this.bookprice = bookprice;
    }
}
