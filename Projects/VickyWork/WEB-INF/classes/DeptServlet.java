import javax.servlet.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class DeptServlet extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException,ServletException {

		java.util.Date date = new java.util.Date();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		Connect connect = new Connect();
		Connection connection = connect.toConnect();
		Statement stmt = connect.getStatement(connection);

		String sql="select * from dept";

		try {
			ResultSet resultSet = connect.getSet(stmt, sql);

		out.print("<html>");
		out.print("<head>");
		out.print("<title>DeptInfo</title>");
		out.print("</head>");
		out.print("<body style='background-color: black; color: white;'>");
		out.print("<hr>");
		out.print("<h3><a href='index.html'>Home</a></h3>");
		out.print("<hr>");
		out.print("<h1>"+date+"</h1>");
		out.print("<hr>");
		out.print("<table border='1' width='100%'>");
		out.print("<tr>");
		out.print("<td>DepartmentNo</td>");
		out.print("<td>DeptName</td>");
		out.print("<td>Location</td>");
		out.print("</tr>");
		while(resultSet.next()) {
			out.print("<tr>");
			out.print("<td>"+resultSet.getString(1)+"</td>");
			out.print("<td>"+resultSet.getString(2)+"</td>");
			out.print("<td>"+resultSet.getString(3)+"</td>");
			out.print("</tr>");
		}

		} catch (SQLException e) {
			System.out.println(e);
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}
}