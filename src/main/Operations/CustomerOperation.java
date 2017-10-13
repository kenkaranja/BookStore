import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Local
@Stateless
public class CustomerOperation implements CustomerBeanI {
    @EJB
    DBConnectI db;
    public boolean addCustomer(Customer c) {

        String sql = "INSERT INTO customer(Name,Email,Password) VALUES(?,?,?)";
        PreparedStatement ps = db.createPreparedStatement(sql);
        try {
            ps.setString(1, c.getCustomer_name());
            ps.setString(2, c.getCustomer_email());
            ps.setString(3, c.getCustomer_password());
            db.dbWrite(ps);

        } catch (SQLException e) {
            System.out.println("Error occured" + e);
            e.printStackTrace();
            return false;

        }
        return true;
    }

    public boolean authenticateCustomer(String email, String password) {

        String sql = "SELECT * FROM customer WHERE Email='" + email + "' and Password ='" + password + "'";
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


}
