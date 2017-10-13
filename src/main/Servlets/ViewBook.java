import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "viewbook")
public class ViewBook extends HttpServlet {
    @EJB
    ProductBeanI operation;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> productList = operation.viewBook();
        req.setAttribute("products", productList);
        RequestDispatcher rd = req.getRequestDispatcher("ViewBook.jsp");
        rd.forward(req, resp);
    }
}
