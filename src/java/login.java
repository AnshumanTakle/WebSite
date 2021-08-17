//
//import java.sql.*;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import java.io.*;
//
//public class login extends HttpServlet {
//
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        //out.print("<h2>Welcome to Register</h2>");
//        String s1 = req.getParameter("E");
//        String s2 = req.getParameter("P");
//
//        PrintWriter out = resp.getWriter();
//        resp.setContentType("text/html");
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String db_url = "jdbc:mysql://localhost:3306/Gym?allowPublickeyRetrieval=true&useSSL=false";
//            String db_uname = "root";
//            String db_upass = "@root";
//            Connection con = DriverManager.getConnection(db_url, db_uname, db_upass);
//          
//            Statement st = con.createStatement();
//            String q = "select * from detail Where Email='" + s1 + "'AND Password='" + s2 + "'";
//           
//            ResultSet rs = st.executeQuery(q);
//           
//            
//            if (rs.next()) {
//                 resp.sendRedirect("Videos.html");
//              
//            } 
//            else {
//                resp.sendRedirect("Membership.html");
//            }
//            con.close();
//        } catch (Exception e) {
//            out.println(e);
//        }
//    }
//}

////https://github.com/mr-ankush https:
////github.com/mr-ankush/resume-builder/blob/main/ResumeCreta/src/java/dao/ProfileDAO.java


import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.Cookie;
import java.sql.*;


public class login extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
{
	String s1=request.getParameter("E");
	String s2=request.getParameter("P");
	PrintWriter out=response.getWriter();
    out.println("<html>");
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Gym","root","@root");
	Statement st=con.createStatement();
	String q="select * from Detail where Email='"+s1+"' AND Password='"+s2+"'";
	ResultSet rs=st.executeQuery(q);
	if(rs.next())
	{      
         Cookie ck=new Cookie("Email",s1);
		 ck.setMaxAge(60*60);
		 response.addCookie(ck);
		 response.sendRedirect("Videos.html");
	}
	else
	{
		out.println("<h1>invalid user name and password</h1>");
	}
	con.close();
}
catch(  IOException | ClassNotFoundException | SQLException e1)
{
	out.println(e1);
}
out.println("</body>");
out.println("</html>");
}
}		

