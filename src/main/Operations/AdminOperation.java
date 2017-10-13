import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class AdminOperation  implements AdminBeanI{
    @EJB
    DBConnectI db;
    public boolean authenticateAdmin(String email, String password) {


        String sql = "SELECT * FROM admin WHERE Email='" + email + "' and Password ='" + password + "'";
        ResultSet rs = db.dbRead(sql);
        try {
            if (rs.next() && rs != null) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error occured" + e);
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public List<Customer> viewCustomer() {

        List<Customer> list = new ArrayList<Customer>();
        String sql = "SELECT * FROM customer";
        ResultSet rs = db.dbRead(sql);
        try {
            while (rs.next() && rs != null) {
                Customer c = new Customer();
                c.setCustomer_name(rs.getString("Name"));
                c.setCustomer_email(rs.getString("Email"));
                c.setCustomer_password(rs.getString("Password"));
                list.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error occured" + e);
            e.printStackTrace();
        }
        return list;
    }

}
