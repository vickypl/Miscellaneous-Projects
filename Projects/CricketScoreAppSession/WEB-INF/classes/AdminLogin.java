import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class AdminLogin extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//fetching parameteres
		String usr=request.getParameter("user");
		String pwd=request.getParameter("pass");

		//db LOgic

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		UserUpdater loginUser = null;
		//boolean loginStatus=false;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String dbUser="sis";
			String dbPass="root";

			connection=DriverManager.getConnection(url, dbUser, dbPass);
			statement=connection.createStatement();
			String sql="select * from scoreupdater where username='"+usr+"' and password='"+pwd+"'";
			resultSet=statement.executeQuery(sql);
			resultSet.next();
				String id=resultSet.getString("id");
				String key1=resultSet.getString("username");
				String key2=resultSet.getString("password");
				String role=resultSet.getString("role");
				if (usr.equals(key1) && pwd.equals(key2)) {
					//loginStatus=true;
					//response.sendRedirect("http://localhost:8088/CricketScore%20Letest/update.html");
					loginUser = new UserUpdater();
					loginUser.setId(id);
					loginUser.setUsername(key1);
					loginUser.setPassword(key2);
					loginUser.setRole(role);
					PrintWriter out  = response.getWriter();
					response.setContentType("text/html");
					out.print("<html>");
					out.print("<head>");
					out.print("<title>Wel-Come Home</title>");
					out.print("<body style='background-color: yellow; color: black;'>");
					out.print("<fieldset style='border-color: green; margin-top: 90px; margin-left: 300px; margin-left: 300px;'>");
					out.print("<h1 style='color: green;'>UserID:"+loginUser.getId()+"</h1>");
					out.print("<h1 style='color: green;'>UserName:"+loginUser.getUsername()+"</h1>");
					//out.print("<h1 style='color: green;'>UserPassword:"+loginUser.getPassword()+"</h1>");
					out.print("<h1 style='color: green;'>UserRole:"+loginUser.getRole()+"</h1>");
					out.print("</fieldset>");
					out.print("</body>");
					out.print("</html>");
					
					//response.sendRedirect("mainServ");
				} 
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

		if (loginUser==null) {
			//if user is not valid:::
				// PrintWriter out  = response.getWriter();
				// response.setContentType("text/html");
				// out.print("Invalid login/password.... try again");
				//request.setAttribute("msg", "Invalid login/password..try again..");
				//RequestDispatcher rd = request.getRequestDispatcher("login");
				//rd.forward(request, response);
				response.setHeader("refresh", "0.1;url=login?msg='Invalid login/password..try again..'");
		} else {
			//if user is valid
			HttpSession session = request.getSession();
			session.setAttribute("id", loginUser.getId());
			session.setAttribute("user", loginUser.getUsername());
			session.setAttribute("role", loginUser.getRole());
			session.setAttribute("timing", new java.util.Date());
			PrintWriter out  = response.getWriter();
			response.setContentType("text/html");
			out.print("<h1 style='color: green;'>Logging in Successfullyyy..</h1>");
			response.setHeader("refresh", "2;url=mainServ");
		}
	}
	
}