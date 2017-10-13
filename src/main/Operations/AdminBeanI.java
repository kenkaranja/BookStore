import javax.ejb.Local;
import java.util.List;

@Local
public interface AdminBeanI {
    public boolean authenticateAdmin(String email, String password);
    public List<Customer> viewCustomer();
}
