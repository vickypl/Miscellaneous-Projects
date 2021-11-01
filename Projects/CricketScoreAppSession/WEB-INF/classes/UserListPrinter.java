import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class UserListPrinter extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(false);
		if (session==null || (session!=null && session.getAttribute("user")==null)) {
			response.sendRedirect("login");
			return;
		}

		java.util.Date date = new java.util.Date();
		//db LOgic
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PrintWriter out  = response.getWriter();
		response.setContentType("text/html");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>UserListPrinter</title>");
		out.print("<style>");
		out.print("tr:hover {background-color: black; color: white;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body style='background-color: pink; color: blue;'>");
		out.print("<hr style='color: red;'>");
		out.print("<h2 style='color: blue;'><a href='mainServ'>MainPage</a>&nbsp;&nbsp;&nbsp;<a href='homeLogged'>home</a>&nbsp;&nbsp;&nbsp;<a href='adduser'>adduser</a>&nbsp;&nbsp;&nbsp;<a href='logout'>logout</a></h2>&nbsp;&nbsp;&nbsp;");
		out.print("<hr style='color: red;'>");
		out.print("<h3>userID::"+session.getAttribute("id")+"</h3>");
		out.print("<h3>Welcome user:"+session.getAttribute("user")+"</h3>");
		out.print("<h3>LogIn Time: "+session.getAttribute("timing")+"</h3>");
		out.print("<h3>UserType: "+session.getAttribute("role")+"</h3>");		
		out.print("<hr style='color: red;'>");
		out.print("<center>");
		out.print("<h1 style='color: blue;'>"+date+"</h1>");
		out.print("<h3 style='color: black;'>Registered User's list</h3>");
		out.print("</center>");
		out.print("<hr style='color: red;'>");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String dbUser="sis";
			String dbPass="root";

			connection=DriverManager.getConnection(url, dbUser, dbPass);
			statement=connection.createStatement();
			String sql="select * from scoreupdater order by id";
			resultSet=statement.executeQuery(sql);
				if (session.getAttribute("msg")!=null) {
						out.print("<h4 style='margin-left: 500px; color: green;'>"+session.getAttribute("msg")+"</h4>");
						session.removeAttribute("msg");
				}
			
				out.print("<table border='1' width='100%'>");
				out.print("<tr>");
				out.print("<th><b>UserID</b></th>");
				out.print("<th><b>UserName</b></th>");
				out.print("<th><b>UserPassWord</b></th>");
				out.print("<th><b>UserRole</b></th>");
				out.print("</tr>");
					while(resultSet.next()) {
						out.print("<tr>");
						out.print("<th><b>"+resultSet.getString(1)+"</b></th>");
						out.print("<th><b>"+resultSet.getString(2)+"</b></th>");
						out.print("<th><b>"+resultSet.getString(3)+"</b></th>");
						out.print("<th><b>"+resultSet.getString(4)+"</b></th>");
						out.print("</tr>");
					} 
				out.print("</table>");
				out.print("</body>");
				out.print("</html>");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
		}

	}
	
}