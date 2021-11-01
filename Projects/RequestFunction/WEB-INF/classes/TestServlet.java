import java.util.*;
import java.sql.*;
import javax.servlet.*;
import java.io.*;

public class TestServlet extends GenericServlet {
	
	int totalHits=0;

	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException{

		//totol hits count logic
		ServletContext context = getServletContext();

		if (context.getAttribute("testServTotalHit")==null) {
			context.setAttribute("testServTotalHit", new Integer(0));
			context.setAttribute("time", new java.util.Date());
		}

		totalHits++;

		Integer temp = (Integer) context.getAttribute("testServTotalHit");
		temp++;
		context.setAttribute("testServTotalHit", temp);

		//req objects
		StringBuilder errorCode = new StringBuilder();
		StringBuilder serverDetail = new StringBuilder();
		List<Employee> empList = new ArrayList<Employee>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String dbUser="system";
			String dbPass="root";
			
			connection=DriverManager.getConnection(url, dbUser, dbPass);
			String sql="select * from emp";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);

			
			while(resultSet.next()) {
				Employee emp = new Employee();
				emp.setEmpno(resultSet.getString(1));
				emp.setEname(resultSet.getString(2));
				emp.setJob(resultSet.getString(3));
				emp.setMgr(resultSet.getString(4));
				emp.setDate(resultSet.getString(5));
				emp.setSalary(resultSet.getString(6));
				emp.setComm(resultSet.getString(7));
				emp.setDeptNo(resultSet.getString(8));
				empList.add(emp);
			}

		} catch (ClassNotFoundException e) {
			errorCode.append("<h1 style='color: red;'>"+e+"</h1>");
		} catch (SQLException e) {
			errorCode.append("<h1 style='color: red;'>"+e+"</h1>");
		} catch (Exception e) {
			errorCode.append("<h1 style='color: red;'>"+e+"</h1>");
		} finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					errorCode.append("<h1 style='color: red;'>"+e+"</h1>");
				}
			}
		}

		//server Details;
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");
		serverDetail.append("<h1 style='color: red;'>Total Number of Hits:"+totalHits+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");
		serverDetail.append("<h1 style='color: green;'>Attribute Names:"+request.getAttributeNames()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");
		serverDetail.append("<h1 style='color: green;'>Parameter Map:"+request.getParameterMap()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		
		serverDetail.append("<h1 style='color: green;'>Protocol: "+request.getProtocol()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		
		serverDetail.append("<h1 style='color: green;'>Scheme: "+request.getScheme()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		
		serverDetail.append("<h1 style='color: green;'>ServerName: "+request.getServerName()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		
		serverDetail.append("<h1 style='color: green;'>Server Port: "+request.getServerPort()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		
		serverDetail.append("<h1 style='color: green;'>Remote Address: "+request.getRemoteAddr()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		
		serverDetail.append("<h1 style='color: green;'>Remote Port: "+request.getRemotePort()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		
		serverDetail.append("<h1 style='color: green;'>Remote Host: "+request.getRemoteHost()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		
		serverDetail.append("<h1 style='color: green;'>Secure Status: "+request.isSecure()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		
		serverDetail.append("<h1 style='color: green;'>Local Name: "+request.getLocalName()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		
		serverDetail.append("<h1 style='color: green;'>Local Address: "+request.getLocalAddr()+"</h1>");
		serverDetail.append("<hr style='color: green; height: 10px; background-color: purple;'>");		


		request.setAttribute("empList", empList);
		request.setAttribute("errorCode", errorCode);
		request.setAttribute("serverDetail", serverDetail);
		RequestDispatcher rd = request.getRequestDispatcher("serv2");
		rd.forward(request, response);

	}
}