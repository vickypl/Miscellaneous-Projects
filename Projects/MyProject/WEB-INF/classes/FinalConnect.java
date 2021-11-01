import javax.servlet.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class FinalConnect extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException {
	PrintWriter out  = response.getWriter();
	java.util.Date date = new java.util.Date();

	ServletContext context = getServletContext();
	
	ServletConfig conf = getServletConfig();

	String user = conf.getInitParameter("user");
	String pass = conf.getInitParameter("pass");
	String className = context.getInitParameter("class");
	String admin = context.getInitParameter("admin");

	response.setContentType("text/html");
	out.print("<html>");
	out.print("<head>");
	out.print("<title>Sis</title>");
	out.print("</head>");
	out.print("<body style='background-color: black; color: white;'>");
	out.print("<a href='index.html'>Home</a>");
	out.print("<hr>");
	out.print("<h1>TODO "+date+"</h1>");
	out.print("<hr>");
	out.print("Data of Employee table from database(System):::");
	out.print("<hr>");
	out.print("<h2> DbUser: "+user+"<h2>");
	out.print("<hr>");
	out.print("<h2> DbPass: "+pass+"<h2>");
	out.print("<hr>");
	out.print("<h2> Servlet ClassName: "+className+"<h2>");
	out.print("<hr>");
	out.print("<h2> Admin: "+admin+"<h2>");
	out.print("<hr>");
	
	Connection connection = null;
	Statement stmt = null;
	ResultSet resultSet = null; 

	try {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "root");
		stmt = connection.createStatement();
		String sql="select * from emp";

		resultSet = stmt.executeQuery(sql);
		
			out.print("<table border='1' width=\'100%\'>");
			out.print("<tr>");
			out.print("<th>emp no</th>");
			out.print("<th>emp name</th>");
			out.print("<th>job</th>");
			out.print("<th>mgr</th>");
			out.print("<th>hiredate</th>");
			out.print("<th>sal</th>");
			out.print("<th>comm</th>");
			out.print("<th>deptno</th>");
			out.print("</tr>");
		while(resultSet.next()) {
			//out.print("<h5>"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t"+resultSet.getString(6)+"\t"+resultSet.getString(7)+"\t"+resultSet.getString(8)+"</h5>");
			
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
			out.print("</table>");


	} catch(ClassNotFoundException e) {
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

	out.print("</body>");
	out.print("</html>");
 }//end service	  
  
}//End of class 
