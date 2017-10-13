import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addcustomer")
public class AddCustomer extends HttpServlet {
    @EJB
    CustomerBeanI customerOperation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AddCustomer.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        String n = req.getParameter("name");
        String e = req.getParameter("email");
        String p = req.getParameter("password");
        String cp = req.getParameter("cpassword");
        Customer customer = new Customer(n, e, p);
        if (p.equals(cp)) {
            if (customerOperation.addCustomer(customer) == true) {
                resp.sendRedirect("logincustomer");
            }
        } else {
            out.println("Password Doesn't match");
            out.println("<a href='AddCustomer.jsp'>Try Again</a>");
        }

    }
}
