import javax.servlet.*;
import java.util.*;
import java.io.*;

public class StudentServ extends GenericServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		Random rand = new Random();
		PrintWriter out = response.getWriter();
		Date date = new Date();

		response.setContentType("text/html");

		int rollNum=Integer.parseInt(request.getParameter("roll"));
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String gender=request.getParameter("gender");
		String[] skills = request.getParameterValues("skill");

		int len=skills.length;

		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("This is Student Servolet...");
		out.print("</title>");
		out.print("</head>");
		out.print("<body style='color: white; background: black;'>");
		out.print("<h1><a style='color: white;' href='index.html'>Home</a></h1>");
		out.print("<hr>");
		out.print("<h2>"+date+"</h2>");
		out.print("<hr>");
		out.print("<center>");
		out.print("<fieldset style='height: 500px; width: 400px;'>");
		out.print("<h2> Roll Number: "+rollNum+"</h2>");
		out.print("<h2> Name: "+name+"</h2>");
		out.print("<h2> Subject: "+subject+"</h2>");
		out.print("<h2> Gender: "+gender+"</h2>");
		// 
		out.print("<h2> Skills: </h2>");
		if (skills.length!=0) {
			for (String s : skills) {
				out.print("<h2>"+s+"</h2>");			
			}
		} else {
			out.print("No skills available..");
		}
		// 
		out.print("<h4 style='color: red;'> Total Skills: "+len+"</h4>");
		out.print("</fieldset>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
	}
}