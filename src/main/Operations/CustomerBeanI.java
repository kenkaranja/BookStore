import javax.ejb.Local;

@Local
public interface CustomerBeanI {
    public boolean addCustomer(Customer c);
    public boolean authenticateCustomer(String email, String password);
}
