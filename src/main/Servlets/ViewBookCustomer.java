import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "viewbookcustomer")
public class ViewBookCustomer extends HttpServlet {
    @EJB
    ProductBeanI productBeanI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> bookList = productBeanI.viewBook();
        req.setAttribute("customerproducts", bookList);
        RequestDispatcher rd = req.getRequestDispatcher("viewBookCustomer.jsp");
        rd.forward(req, resp);
    }
}
