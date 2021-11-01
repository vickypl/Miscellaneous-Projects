import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class LoggedHome extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		//this is here because false will return either the privous session or the null value;
		HttpSession session = request.getSession(false);

		if (session==null) {
			//out.print("<h1 style='red;'>login required..</h1>");
			response.sendRedirect("login");
		}

		java.util.Date date = new java.util.Date();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Wel-Come Home</title>");
		out.print("<body style='background-color: yellow; color: black;'>");
		out.print("<hr style='color: red; height: 10px;'>");
		out.print("<h3>userID::"+session.getAttribute("id")+"</h3>");
		out.print("<h3>Welcome user:"+session.getAttribute("user")+"</h3>");
		out.print("<h3>LogIn Time: "+session.getAttribute("timing")+"</h3>");
		out.print("<h3>UserType: "+session.getAttribute("role")+"</h3>");
		out.print("<hr style='color: red; height: 10px;'>");
		out.print("<h1>Wel-Come to CrickBuzz::::"+date+"</h1>");
		out.print("<hr style='color: red; height: 10px;'>");
		out.print("<fieldset style='border-color: red; border-radius: 24px; height: 100px; width: 500px; margin-top: 100px; margin-right: 300px; margin-left: 400px;'>");
		out.print("<h2 style='color: blue;'><a href='mainServ'>MainPage</a>&nbsp;&nbsp;&nbsp;<a href='home'>home</a>&nbsp;&nbsp;&nbsp;<a href='logout'>logout</a></h2>&nbsp;&nbsp;&nbsp;");
		out.print("</fieldset>");
		out.print("<hr style='color: red; height: 10px;'>");


		out.print("</body>");
		out.print("</head>");
		out.print("</html>");
	}	
}