import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
public class ProductOperation implements ProductBeanI{
    @EJB
    DBConnectI db;

    public boolean addBook(Product book) {
        String sql = "INSERT INTO product(Name,Author,Price) VALUES(?,?,?)";
        PreparedStatement ps = db.createPreparedStatement(sql);
        try {
            ps.setString(1, book.getBook_name());
            ps.setString(2, book.getBook_author());
            ps.setInt(3, book.getBook_price());
            db.dbWrite(ps);

        } catch (SQLException e) {
            System.out.println("Error occured" + e);
            e.printStackTrace();
            return false;

        }
        return true;
    }

    public List<Product> viewBook() {
        List<Product> list = new ArrayList<Product>();
        String sql = "SELECT * FROM product";
        ResultSet rs = db.dbRead(sql);
        try {
            while (rs.next() && rs != null) {
              Product bb = new Product();
                bb.setBook_name(rs.getString("Name"));
                bb.setBook_author(rs.getString("Author"));
                bb.setBook_price(rs.getInt("Price"));
                list.add(bb);
            }
        } catch (SQLException e) {
            System.out.println("Error occured" + e);
            e.printStackTrace();
        }
        return list;
    }


}
