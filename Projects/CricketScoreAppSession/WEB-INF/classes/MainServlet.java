import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class MainServlet extends HttpServlet {

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
		htmlCode.append("<title>MainServletPage</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body style='background-color: pink; color: black'>");
		htmlCode.append("<hr style='color: red; height: 10px;'>");
		htmlCode.append("<h3>userID::"+session.getAttribute("id")+"</h3>");
		htmlCode.append("<h3>Welcome user:"+session.getAttribute("user")+"</h3>");
		htmlCode.append("<h3>LogIn Time: "+session.getAttribute("timing")+"</h3>");
		htmlCode.append("<h3>UserType: "+session.getAttribute("role")+"</h3>");
		htmlCode.append("<h2 style='color: blue;'><a href='mainServ'>MainPage</a>&nbsp;&nbsp;&nbsp;<a href='homeLogged'>home</a>&nbsp;&nbsp;&nbsp;<a href='logout'>logout</a></h2>&nbsp;&nbsp;&nbsp;");
		htmlCode.append("<hr style='color: red; height: 10px;'>");
		htmlCode.append("<fieldset style='border-radius: 10px; border-color: red; background-color: pink; margin-right: 300px; margin-left: 300px; margin-top: 50px;'>");
		htmlCode.append("<legend align='center'><b>CrickkK BUzzz</b></legend>");
		htmlCode.append("<h1><a href='first'>Check Live Score</a></h1>");
		htmlCode.append("</fieldset>");
		htmlCode.append("<fieldset style='border-radius: 10px; border-color: red; background-color: pink; margin-right: 300px; margin-left: 300px; margin-top: 10px;'>");
		htmlCode.append("<legend align='center'><b>Admin(Live Updater)</b></legend>");
		htmlCode.append("<h1><a href='updateFormServ'>ToUpdateLiveScore</a></h1>");
		htmlCode.append("</fieldset>");
		htmlCode.append("<fieldset style='border-radius: 10px; border-color: red; background-color: pink; margin-right: 300px; margin-left: 300px; margin-top: 10px;'>");
		htmlCode.append("<legend align='center'><b>UserSign-Up</b></legend>");
		htmlCode.append("<h1><a href='register'>ToRegisterAsUser</a></h1>");
		htmlCode.append("</fieldset>");
		if ("admin".equals(session.getAttribute("role"))) {	
			htmlCode.append("<fieldset style='border-radius: 10px; border-color: red; background-color: pink; margin-right: 300px; margin-left: 300px; margin-top: 10px;'>");
			htmlCode.append("<legend align='center'><b>Visible to Admin User Only</b></legend>");
			htmlCode.append("<h1><a href='printer'>ToViewUsersList.</a></h1>");
			htmlCode.append("</fieldset>");
		}
		if ("admin".equals(session.getAttribute("role"))) {	
			htmlCode.append("<fieldset style='border-radius: 10px; border-color: red; background-color: pink; margin-right: 300px; margin-left: 300px; margin-top: 10px;'>");
			htmlCode.append("<legend align='center'><b>Add User</b></legend>");
			htmlCode.append("<h1><a href='adduser'>ToAddNewUserWithRole</a></h1>");
			htmlCode.append("</fieldset>");
		}
		htmlCode.append("</body>");
		htmlCode.append("</html>");
		out.print(htmlCode);
	}	
}