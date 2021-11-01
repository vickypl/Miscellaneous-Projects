import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class MyServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//session mangment
		HttpSession session = request.getSession(false);
		if (session==null || (session!=null && session.getAttribute("user")==null)) {
			response.sendRedirect("login");
			return;
		}

		PrintWriter out  = response.getWriter();
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		String pattern = "EE DD/MM/YYYY HH:MM:SS";
		sdf.applyPattern(pattern);
		sdf.format(date);


		response.setContentType("text/html");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>CricketScoreCheck</title>");
		out.print("<style>");
		out.print("tr:hover{ background-color: black; color: white;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body style='background: pink; color: blue;'>");
		out.print("<hr style='color: red;'>");
		out.print("<h2 style='color: blue;'><a href='mainServ'>MainPage</a>&nbsp;&nbsp;&nbsp;<a href='homeLogged'>home</a>&nbsp;&nbsp;&nbsp;<a href='logout'>logout</a></h2>&nbsp;&nbsp;&nbsp;");
		out.print("<hr style='color: red;'>");
		out.print("<center>");
		out.print("<h1 style='color: blue;'>"+date+"</h1>");
		out.print("<h3 style='color: black;'>Live Score Board</h3>");
		out.print("</center>");
		out.print("<hr style='color: red;'>");

		//dbLOgic
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String dbUser="sis";
				String dbPass="root";

			connection=DriverManager.getConnection(url, dbUser, dbPass);
			statement=connection.createStatement();
			String sql="select * from score";
			resultSet=statement.executeQuery(sql);
			out.print("<table border='1' width='100%' style='color: black;'>");
			out.print("<tr>");
			out.print("<td><b>SerialNo.</b></td>");
			out.print("<td><b>Over:</b></td>");
			out.print("<td><b>Ball:</b></td>");
			out.print("<td><b>Run:</b></td>");
			out.print("<td><b>Total Runs:</b></td>");
			out.print("</tr>");
			int totalScore=0;
			while(resultSet.next()) {
				out.print("<tr>");
				out.print("<td>"+resultSet.getString(1)+"</td>");
				out.print("<td>"+resultSet.getString(2)+"</td>");
				out.print("<td>"+resultSet.getString(3)+"</td>");
				out.print("<td>"+resultSet.getString(4)+"</td>");
				totalScore=totalScore+Integer.parseInt(resultSet.getString(4));
				out.print("<td style='color: red;'>"+totalScore+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");

		} catch(ClassNotFoundException e) {
			out.print(e);
		} catch(SQLException e) {
			out.print(e);
		} catch (Exception e) {
			out.print(e);
		} finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					out.print(e);
				}
			}
		}



		response.setHeader("refresh", "1");
		out.print("</body>");
		out.print("</html>");
	}

}