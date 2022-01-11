
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

