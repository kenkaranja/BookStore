import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductBeanI {
    public boolean addBook(Product book);
    public List<Product> viewBook();
}
