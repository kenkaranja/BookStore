import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
public class ShoppingOperation implements ShoppingBeanI {
    DBConnectI db=new DbConnectBean();
    public List<ShoppingCart> viewShoppingCart() {

        List<ShoppingCart> slist = new ArrayList<ShoppingCart>();
        String sql = "SELECT * FROM shopping";
        ResultSet rs = db.dbRead(sql);
        try {
            while (rs.next() && rs != null) {
                ShoppingCart sc = new ShoppingCart();
                sc.setCustomer_name(rs.getString("Customer_name"));
                sc.setBookname(rs.getString("Book"));
                sc.setBookprice(rs.getInt("Price"));
                sc.setBookauthor(rs.getString("Author"));
                slist.add(sc);
            }

        } catch (SQLException e) {
            System.out.println("Error occured" + e);
            e.printStackTrace();
        }
        return slist;
    }


}
