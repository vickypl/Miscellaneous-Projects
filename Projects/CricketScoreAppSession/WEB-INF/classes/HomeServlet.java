import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class HomeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		java.util.Date date = new java.util.Date();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Wel-Come Home</title>");
		out.print("<body style='background-color: yellow; color: black;'>");
		out.print("<hr style='color: red; height: 10px;'>");
		out.print("<h1>Wel-Come to CrickBuzz::::"+date+"</h1>");
		out.print("<hr style='color: red; height: 10px;'>");
		out.print("<fieldset style='border-color: red; border-radius: 24px; height: 100px; width: 300px; margin-top: 100px; margin-right: 300px; margin-left: 300px;'>");
		out.print("<h1><a align='center' href='login'>Sign-In</h1>");
		out.print("</fieldset>");
		out.print("<hr style='color: red; height: 10px;'>");

		//this is here because false will return either the privous session or the null value;
		HttpSession oldSession = request.getSession(false);

		if (oldSession==null) {
			out.print("<h1 style='red;'>login required..</h1>");
		} else {
			response.sendRedirect("mainServ");
		}

		out.print("</body>");
		out.print("</head>");
		out.print("</html>");

		/*HttpSession oldSession  = request.getSession(false);
		//give old one or NULL if not exist
		if(oldSession==null ||  oldSession.getAttribute("user")==null){
			htmlCode.append("<a href=\"login\">User Login</a>&nbsp;");
		}else{
			//if logged in user redirect to main service page  
			response.sendRedirect("mainservice");
		}*/
	}	
}