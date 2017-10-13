import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("logincustomer")
public class LoginCustomer extends HttpServlet {
    @EJB
    CustomerBeanI customerOperation;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("LoginCustomer.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String e = req.getParameter("email");
        String p = req.getParameter("password");

        if (customerOperation.authenticateCustomer(e, p) == true) {
            HttpSession session = req.getSession();
            session.setAttribute("mail", e);
            resp.sendRedirect("CustomerPage.jsp");
        } else {
            out.println("Invalid inputs <a href='LoginCustomer.jsp'>Try Again</a>");

        }

    }
}
