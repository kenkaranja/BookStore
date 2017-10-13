import javax.ejb.Local;
import java.util.List;

@Local
public interface ShoppingBeanI {
    public List<ShoppingCart> viewShoppingCart();
}
