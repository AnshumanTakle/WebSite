import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Website extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //out.print("<h2>Welcome to Register</h2>");
        String name = req.getParameter("usname");
        String age = req.getParameter("usage");
        String address = req.getParameter("usaddress");
        String email = req.getParameter("usemail");
        String pass = req.getParameter("uspass");
        String Gender = req.getParameter("usgender");

        try {
            
            Class.forName("com.mysql.jdbc.Driver");

          
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gym", "root", "@root");

          
            Statement st = con.createStatement();

         
            String q = "insert into Detail values('" + name + "','" + age + "','" + address + "','" + email + "','" + pass + "','" + Gender + "')";
            st.executeUpdate(q);
            resp.sendRedirect("login.html");
//            out.print("<h1>Data insert</h1>");
          
            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }
}
