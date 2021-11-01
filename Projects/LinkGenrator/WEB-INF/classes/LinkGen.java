import java.util.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class LinkGen extends GenericServlet{
	
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {

		java.util.Date date = new java.util.Date();

		PrintWriter out = response.getWriter();

		String dbUser="system";
		String dbPass="root";

		List<Department> deptList = new ArrayList<Department>();
		Connection connection =null;

		out.print("<html>");
		out.print("<head>");
		out.print("<title>DeptLinks</title>");
		out.print("</head>");
		out.print("<body style='background-color: black; color: white;'>");

		try {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost";
		connection=DriverManager.getConnection(url, dbUser, dbPass);
		Statement statement = connection.createStatement();
		response.setContentType("text/html");

		out.print("<hr>");
		out.print("<h1>"+date+"</h1>");
		out.print("<hr>");
		out.print("<table border='1' width='100%'>");
		out.print("<tr>");
		out.print("<th>Department no.</th>");
		out.print("<th>Department Name.</th>");
		out.print("<th>Department Location.</th>");
		out.print("</tr>");


			String sql="select * from dept";
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				out.print("<tr>");
				out.print("<td>"+resultSet.getString(1)+"</td>");
				out.print("<td>"+resultSet.getString(2)+"</td>");
				out.print("<td>"+resultSet.getString(3)+"</td>");
				out.print("</tr>");
			
				Department dept = new Department();
				dept.setDeptNo(Integer.parseInt(resultSet.getString(1)));
				dept.setDeptName(resultSet.getString(2));
				dept.setLocation(resultSet.getString(3));
				deptList.add(dept);
			}
			out.print("</table>");
			out.print("<h1> dept list size: "+deptList.size()+"</h1>");
			if (deptList.size()>0) {
				//http://localhost:8088/LinkGenrator
				for (Department dd : deptList) {
					out.print("<h1><a href='http://localhost:8088/LinkGenrator/send?id="+dd.getDeptNo()+"'>printFor["+dd.getDeptNo()+"]</a></h1>");
					out.print("<hr>");
				}
			}


		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
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
		///searchproducts?search_product_name=10

/*		out.print("<hr>");
		out.print("<fieldset>");
		out.print("<form action='send'>");
		out.print("<input type='text' name='id' value=''>");
		out.print("<input type='submit' name='submit' value='submit'>");
		out.print("</form>");
		out.print("</fieldset>");
		out.print("<hr>");*/

			out.print("</body>");
			out.print("</html>");

	}
}