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

@WebServlet(urlPatterns = "loginadmin")
public class LoginAdmin extends HttpServlet {
    @EJB
    AdminBeanI adminOperation;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String em = req.getParameter("email");
        String pp = req.getParameter("password");

        if (adminOperation.authenticateAdmin(em, pp) == true) {
            HttpSession s = req.getSession();
            s.setAttribute("adminEmail", em);
            resp.sendRedirect("AdminPage.jsp");
        } else {
            out.println("Invalid inputs <a href='LoginAdmin.jsp'>Try Again</a>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("LoginAdmin.jsp");
        rd.forward(req, resp);
    }
}
