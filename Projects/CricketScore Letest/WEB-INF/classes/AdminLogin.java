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
		boolean loginStatus=false;
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
				String key1=resultSet.getString("username");
				String key2=resultSet.getString("password");
				if (usr.equals(key1) && pwd.equals(key2)) {
					loginStatus=true;
					//response.sendRedirect("http://localhost:8088/CricketScore%20Letest/update.html");
					response.sendRedirect("update.html");
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

		if (!loginStatus) {
				response.sendRedirect("adminLogin.html");
		}
	}
	
}