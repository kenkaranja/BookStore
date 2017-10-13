import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addbook")
public class AddBook extends HttpServlet {
    @EJB
    ProductBeanI p;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String n = req.getParameter("name");
        String a = req.getParameter("author");
        int pr = Integer.parseInt(req.getParameter("price"));
        Product bk = new Product(n, a, pr);
        if (p.addBook(bk) == true) {
            resp.sendRedirect("viewbook");
        } else {
            out.println("Error during adding");
            resp.sendRedirect("AddBook.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AddBook.jsp");
        rd.forward(req,resp);
    }
}
