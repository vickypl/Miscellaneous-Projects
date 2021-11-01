import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class ScoreUpdate extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


		HttpSession session = request.getSession(false);
		if (session==null || (session!=null && session.getAttribute("user")==null)) {
			response.sendRedirect("login");
			return;
		}


		//fetching parameteres
		String over=request.getParameter("over");
		String ball=request.getParameter("ball");
		String run=request.getParameter("run");

		//db LOgic

		Connection connection = null;
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		boolean loginStatus=false;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String dbUser="sis";
			String dbPass="root";

			connection=DriverManager.getConnection(url, dbUser, dbPass);
			String sql="insert into score(id, over, ball, run) values(sc_id.nextval, ?, ?, ?)";
			prepStatement=connection.prepareStatement(sql);
			prepStatement.setString(1, over);
			prepStatement.setString(2, ball);
			prepStatement.setString(3, run);
			
			int result=prepStatement.executeUpdate();

			if (result>0) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.print("<h1>done<h1>");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(e);
				}
				session.setAttribute("msg", "Successfully updated");
				response.sendRedirect("updateFormServ");
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

	}
	
}