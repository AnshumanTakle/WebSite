
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Website extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //out.print("<h2>Welcome to Register</h2>");
        String name = req.getParameter("usname");
        String age = req.getParameter("usage");
        String address = req.getParameter("usaddress");
        String email = req.getParameter("usemail");
        String Gender = req.getParameter("usgender");

        try {
            //2
            Class.forName("com.mysql.jdbc.Driver");

            //3
//           String url="jdbc:mysql://localhost:3306/Register?useSSL=false";
//           String uname="root";
//           String upassword="@root";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gym", "root", "@root");

            //4
            Statement st = con.createStatement();

            //5
            String q = "insert into Detail values('" + name + "','" + age + "','" + address + "','" + email + "','" + Gender + "')";
            st.executeUpdate(q);
            out.print("<h1>Data insert</h1>");
            //6.
            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }
}
