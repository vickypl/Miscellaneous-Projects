import java.util.*;
import java.sql.*;
import javax.servlet.*;
import java.io.*;

public class PresentServlet extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException{

		//fetcching context data;
		ServletContext context = getServletContext();
		Object obj = context.getAttribute("testServTotalHit");
		Integer totalHits=(Integer)obj;

		//fetching from serv one to present;
		List<Employee> empList = (ArrayList<Employee>)request.getAttribute("empList");
		StringBuilder errorCode = (StringBuilder)request.getAttribute("errorCode");
		StringBuilder serverDetail = (StringBuilder)request.getAttribute("serverDetail");

		//req objects
		StringBuilder htmtCode = new StringBuilder();


		htmtCode.append("<html>");
		htmtCode.append("<head>");
		htmtCode.append("<title>Presenter</title>");
		htmtCode.append("<style>");
		htmtCode.append("tr:hover{ color: yellow; background-color: purple;}");
		htmtCode.append("th:hover{ color: green; background-color: red;}");
		htmtCode.append("</style>");
		htmtCode.append("</head>");
		htmtCode.append("<body style='background-color: yellow; color: purple;'>");
		htmtCode.append("<h1 style='color: purple;'>Servlet Details: <h1>");
		htmtCode.append("<fieldset style='color: purple;'>");
		htmtCode.append("<hr style='color: red; height: 10px; background-color: purple;'>");
		htmtCode.append("<marquee behavior='alternate'>");
		htmtCode.append("<h4 style='color: black;'>Total Number of Hits:"+totalHits+"</h4>");
		htmtCode.append("</marquee>");
		htmtCode.append("<hr style='color: red; height: 10px; background-color: purple;'>");
		htmtCode.append("</fieldset>");

		if (errorCode.length()>0) {
			htmtCode.append(errorCode);
		}

		htmtCode.append("<table border='1' width='100%' border-color: purple;>");
		htmtCode.append("<tr>");
		htmtCode.append("<td><b>EmpNo:</b></td>");
		htmtCode.append("<td><b>EmpName:</b></td>");
		htmtCode.append("<td><b>EmpJob:</b></td>");
		htmtCode.append("<td><b>EmpMgr:</b></td>");
		htmtCode.append("<td><b>HireDate:</b></td>");
		htmtCode.append("<td><b>Salary:</b></td>");
		htmtCode.append("<td><b>Comm:</b></td>");
		htmtCode.append("<td><b>DeptNO:</b></td>");
		htmtCode.append("<td colspan='2'><b>Options:</b></td>");
		htmtCode.append("</tr>");

		for (Employee emp : empList) {
			
			htmtCode.append("<tr>");
			htmtCode.append("<td>"+emp.getEmpNo()+"</td>");
			htmtCode.append("<td>"+emp.getEname()+"</td>");
			htmtCode.append("<td>"+emp.getJob()+"</td>");
			htmtCode.append("<td>"+emp.getMgr()+"</td>");
			htmtCode.append("<td>"+emp.getDate()+"</td>");
			htmtCode.append("<td>"+emp.getSalary()+"</td>");
			htmtCode.append("<td>"+emp.getComm()+"</td>");
			htmtCode.append("<td>"+emp.getDeptNo()+"</td>");
			htmtCode.append("<td style='color: blue;'><a href='#'>Update</a></td>");
			htmtCode.append("<td style='color: blue;'><a href='#'>Delete</a></td>");
			htmtCode.append("</tr>");
		}
			htmtCode.append("</table>");

		if (serverDetail.length()>0) {
			htmtCode.append(serverDetail);
		}


		htmtCode.append("</body>");
		htmtCode.append("</html>");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print(htmtCode);
	}
}