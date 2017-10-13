import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "viewcustomer")
public class ViewCustomer extends HttpServlet {
    @EJB
    AdminBeanI admin;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Customer> lt = admin.viewCustomer();
        req.setAttribute("viewcustomerbyadmin", lt);
        RequestDispatcher dispatcher = req.getRequestDispatcher("viewCustomer.jsp");
        dispatcher.forward(req, resp);
    }
}
