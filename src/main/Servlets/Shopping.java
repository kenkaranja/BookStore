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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "shopping")
public class Shopping extends HttpServlet {
    @EJB
    DBConnectI db;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("mail") != null) {
            RequestDispatcher rd = req.getRequestDispatcher("viewBookCustomer.jsp");
            rd.forward(req, resp);
        } else {
            resp.sendRedirect("LoginCustomer.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String sessionName = String.valueOf(session.getAttribute("mail"));
        String[] products = req.getParameterValues("checkbook");
        for (int i = 0; i < products.length; i++) {
            String sql = "SELECT Name,Author,Price from product where Name='" + products[i] + "'";
            String add = "INSERT INTO shopping VALUES(?,?,?,?)";

            ResultSet rs = db.dbRead(sql);
            PreparedStatement ps = db.createPreparedStatement(add);
            try {
                while (rs.next()) {
                    String pro_name = rs.getString("Name");
                    String pro_Author = rs.getString("Author");
                    int pro_price = rs.getInt("Price");

                    ps.setString(1, sessionName);
                    ps.setString(2, pro_name);
                    ps.setInt(3, pro_price);
                    ps.setString(4, pro_Author);
                    db.dbWrite(ps);
                }
                resp.sendRedirect("viewBookBought");

            } catch (SQLException e) {
                PrintWriter out = resp.getWriter();
                out.println("Error occured" + e);
                e.printStackTrace();
            }

        }

    }
}
