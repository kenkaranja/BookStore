import javax.ejb.Local;

@Local
public class Product {
    private String book_name;
    private String book_author;
    private int book_price;

    public Product() {
        super();
    }

    public Product(String book_name, String book_author, int book_price) {
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_price = book_price;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public void setBook_price(int book_price) {
        this.book_price = book_price;
    }

    public void setBook_name(String book_name) {

        this.book_name = book_name;
    }

    public int getBook_price() {

        return book_price;
    }


}
