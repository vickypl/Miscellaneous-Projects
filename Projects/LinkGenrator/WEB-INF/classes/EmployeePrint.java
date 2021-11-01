import javax.servlet.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class EmployeePrint extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {

		java.util.Date date = new java.util.Date();
		List<Employee> empList = new ArrayList<Employee>();
		PrintWriter out = response.getWriter();

		int id=-1;
		if (request.getParameter("id")!=null) {	
			id=Integer.parseInt(request.getParameter("id"));
		}
		response.setContentType("text/html");

		out.print("<h1>"+id+"</h1>");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>DeptLinks</title>");
		out.print("</head>");
		out.print("<body style='background-color: black; color: white;'>");
		out.print("<hr>");
		out.print("<h1>"+date+"</h1>");
		out.print("<hr>");

		String dbUser="system";
		String dbPass="root";


		Connection connection =null;
		Statement statement = null;
		ResultSet resultSet =null;
		try {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost";
		connection=DriverManager.getConnection(url, dbUser, dbPass);
		statement = connection.createStatement();
		String sql="select * from emp where deptno="+id;

		out.print("<table border='1' width='100%'>");
		out.print("<tr>");
		out.print("<th>Employee Number</th>");
		out.print("<th>Employee Number</th>");
		out.print("<th>Job</th>");
		out.print("<th>MGR</th>");
		out.print("<th>HireDate</th>");
		out.print("<th>Salary</th>");
		out.print("<th>Comm</th>");
		out.print("<th>Department no</th>");
		out.print("</tr>");


			resultSet = statement.executeQuery(sql);
			
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
			
/*				int empnum=Integer.parseInt(resultSet.getString(1));
				String ename=resultSet.getString(2);
				String ejob=resultSet.getString(3);
				int emgr=Integer.parseInt(resultSet.getString(4));
				String edate=resultSet.getString(5);
				Long esalary=Long.parseLong(resultSet.getString(6));
				int ecomm=Integer.parseInt(resultSet.getString(7));
				int edpt=Integer.parseInt(resultSet.getString(8));

				Employee emp = new Employee();

				emp.setEmpno(empnum);
				emp.setEname(ename);
				emp.setJob(ejob);
				emp.setMgr(emgr);
				emp.setDate(edate);
				emp.setSalary(esalary);
				emp.setComm(ecomm);
				emp.setDeptNo(edpt);*/

/*				emp.setEmpno(Integer.parseInt(resultSet.getString(1)));
				emp.setEname(resultSet.getString(2));
				emp.setJob(resultSet.getString(3));
				emp.setMgr(Integer.parseInt(resultSet.getString(4)));
				emp.setDate(resultSet.getString(5));
				emp.setSalary(Long.parseLong(resultSet.getString(6)));
				emp.setComm(Integer.parseInt(resultSet.getString(7)));
				emp.setDeptNo(Integer.parseInt(resultSet.getString(8)));*/
//				empList.add(emp);
			}
		out.print("</table>");
		
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

		out.print("<hr style='height: 6px; color: red;'>");
		out.print("<h1>Printed using Objects of Employee</h1>");
		out.print("<h1>"+empList.size()+"</h1>");
		

			if (empList.size()>0) {
				
				for (Employee em : empList) {
					if (em.getDeptNo()==id) {
						out.print("<h5>"+em.getEmpNo()+":"+em.getEname()+":"+em.getJob()+":"+em.getMgr()+":"+em.getDate()+":"+em.getSalary()+":"+em.getComm()+":"+em.getDeptNo()+"</h5>");
					}
				}
			}
		
		out.print("<hr style='height: 6px; color: red;'>");
		

		out.print("</body>");
		out.print("</html>");
	}
}