import javax.servlet.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class EmpServlet extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException,ServletException {

		java.util.Date date = new java.util.Date();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		Connect connect = new Connect();
		Connection connection = connect.toConnect();
		Statement stmt = connect.getStatement(connection);

		String sql="select * from emp";

		try {
			ResultSet resultSet = connect.getSet(stmt, sql);

		out.print("<html>");
		out.print("<head>");
		out.print("<title>EmployeeInfo</title>");
		out.print("</head>");
		out.print("<body style='background-color: black; color: white;'>");
		out.print("<hr>");
		out.print("<h3><a href='index.html'>Home</a></h3>");
		out.print("<hr>");
		out.print("<h1>"+date+"</h1>");
		out.print("<hr>");
		out.print("<table border='1' width='100%'>");
		out.print("<tr>");
		out.print("<td>EmpNo</td>");
		out.print("<td>EmpName</td>");
		out.print("<td>Job</td>");
		out.print("<td>MGR</td>");
		out.print("<td>HireDate</td>");
		out.print("<td>Salary</td>");
		out.print("<td>Comm</td>");
		out.print("<td>DeptNo</td>");
		out.print("</tr>");
		while(resultSet.next()) {
			out.print("<tr>");
			out.print("<td>"+resultSet.getString(1)+"</td>");
			out.print("<td>"+resultSet.getString(2)+"</td>");
			out.print("<td>"+resultSet.getString(3)+"</td>");
			out.print("<td>"+resultSet.getString(4)+"</td>");
			out.print("<td>"+resultSet.getString(5)+"</td>");
			out.print("<td>"+resultSet.getString(6)+"</td>");
			out.print("<td>"+resultSet.getString(7)+"</td>");
			out.print("<td>"+resultSet.getString(8)+"</td>");
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