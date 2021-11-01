import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class LoginFormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		StringBuilder htmlCode = new StringBuilder();

		HttpSession session = request.getSession(false);

		if (session!=null) {
			response.sendRedirect("mainServ");
			return;
		}

		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>AdminLogin</title>");
		htmlCode.append("<style type='text/css'>");
		htmlCode.append("fieldset {background-color: black; background-opacity: 0.9; background: transparent; border-radius: 24px; height: 200px; width: 300px; margin-top: 100px; margin-left: 470px; margin-right: 450px; padding: 40px; border-color: red;}");
		htmlCode.append("input[type=text], [type=password] {padding: 5px; border-radius: 24px; border-color: red; }");
		htmlCode.append("input[type=submit] { padding: 3px; border-color: red; border-radius: 24px; width: 90px; }");
		htmlCode.append("input[type=submit]:hover {border-color: blue;}");
		htmlCode.append("input[type=password]:hover {border-color: blue;}"); 
		htmlCode.append("input[type=text]:hover {border-color: blue;}");
		htmlCode.append("td {padding: 5px;}");
		htmlCode.append(".title {font-family: cursive; font-size: 22px;}");
		htmlCode.append("</style>");
		htmlCode.append("</head>");
		htmlCode.append("<body style='background-color: pink; color: black'>");
		htmlCode.append("<hr style='color: red;'>");
		htmlCode.append("<h1><a style='color: blue;' href='login'>Home</a></h1>");
		htmlCode.append("<hr style='color: red;'>");
		htmlCode.append("<fieldset>");
		if (request.getParameter("msg")!=null) {
			htmlCode.append("<h6 style='color: red;'>"+request.getParameter("msg")+"</h6>");
		}
		htmlCode.append("<legend align='center'><b>Admin Panel</b></legend>");
		htmlCode.append("<h1 align='center' style='font-size: 20px;'>Login</h1>");
		htmlCode.append("<table>");
		htmlCode.append("<form action='admin' method='post'>");
		htmlCode.append("<tr>");
		htmlCode.append("<td class='title'>Username</td>");
		htmlCode.append("<td><input type='text' name='user' value='' placeholder='Username' onfocus required=''></td>");
		htmlCode.append("</tr>");
		htmlCode.append("<tr>");
		htmlCode.append("<td class='title'>Password</td>");
		htmlCode.append("<td><input type='password' name='pass' value='' placeholder='password' required=''></td>");
		htmlCode.append("</tr>");
		htmlCode.append("<tr>");
		htmlCode.append("<td><a href='#'>ForgetPassword?</a></td>");
		htmlCode.append("<td align='right'><input type='submit' value='Login'></td>");
		htmlCode.append("</tr>");
		htmlCode.append("</form>");
		htmlCode.append("</table>");
		htmlCode.append("</fieldset>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");

		out.print(htmlCode);

	}	
}