import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class UpdateFormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		StringBuilder htmlCode = new StringBuilder();

		HttpSession session = request.getSession(false);
		if (session==null || (session!=null && session.getAttribute("user")==null)) {
			response.sendRedirect("login");
			return;
		}

		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>AdminLogin</title>");
		htmlCode.append("<style type='text/css'>");
		htmlCode.append("fieldset {background-color: black; background-opacity: 0.9; background: transparent; border-radius: 24px;height: 100px; width: 1000px; margin-top: 40px; margin-left: 70px; margin-right: 90px; padding: 40px;border-color: red;}");
		htmlCode.append("input[type=text], [type=password] {padding: 5px; border-radius: 24px; border-color: red;}");
		htmlCode.append("input[type=submit] {padding: 3px; border-color: red; border-radius: 24px; width: 90px;}");
		htmlCode.append("input[type=submit]:hover {border-color: blue; }");
		htmlCode.append("input[type=password]:hover {border-color: blue;}"); 
		htmlCode.append("input[type=text]:hover {border-color: blue;}");
		htmlCode.append("td {padding: 5px;}");
		htmlCode.append(".title {font-family: cursive; font-size: 22px;}</style>");
		htmlCode.append("</head>");
		htmlCode.append("<body style='background-color: pink; color: black'>");
		htmlCode.append("<h2 style='color: blue;'><a href='mainServ'>MainPage</a>&nbsp;&nbsp;&nbsp;<a href='homeLogged'>home</a>&nbsp;&nbsp;&nbsp;<a href='logout'>logout</a></h2>&nbsp;&nbsp;&nbsp;");
		htmlCode.append("<hr style='color: red; height: 10px;'>");
		htmlCode.append("<h3>userID::"+session.getAttribute("id")+"</h3>");
		htmlCode.append("<h3>Welcome user:"+session.getAttribute("user")+"</h3>");
		htmlCode.append("<h3>LogIn Time: "+session.getAttribute("timing")+"</h3>");
		htmlCode.append("<h3>UserType: "+session.getAttribute("role")+"</h3>");
		htmlCode.append("<hr style='color: red; height: 10px;'>");
		htmlCode.append("<hr style='color: red;'>");
		htmlCode.append("<hr style='color: red;'>");
		if (session.getAttribute("msg")!=null) {
			htmlCode.append("<h4 style='margin-left: 500px; color: green;'>"+session.getAttribute("msg")+"</h4>");
			session.removeAttribute("msg");
		}
		htmlCode.append("<fieldset>");
		htmlCode.append("<legend align='center'><b>Score Update Panel</b></legend>");
		htmlCode.append("<table width='100%'>");
		htmlCode.append("<form action='update' method='post'>");
		htmlCode.append("<tr>");
		htmlCode.append("<th align='left'>Over</th>");
		htmlCode.append("<th align='left'>Ball</th>");
		htmlCode.append("<th align='left'>Run</th>");
		htmlCode.append("</tr>");
		htmlCode.append("<tr>");
		htmlCode.append("<td><input type='text' name='over' value='' required placeholder='Enter Over'></td>");
		htmlCode.append("<td><input type='text' name='ball' value='' required placeholder='Ball'></td>");
		htmlCode.append("<td><input type='text' name='run' value='' required placeholder='Run'></td>");
		htmlCode.append("<td><input type='submit' value='update'></td>");
		htmlCode.append("</tr>");
		htmlCode.append("</form>");
		htmlCode.append("</table>");
		htmlCode.append("</fieldset>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");

		out.print(htmlCode);
	}	
}