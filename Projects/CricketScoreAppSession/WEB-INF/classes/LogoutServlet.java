import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		if (session==null) {
			response.sendRedirect("home");
/*			out.print("<h1 style='color: red;'>Logged-Reqired</h1>");
			out.print("<h1 style='color: red;'>Session already expired...</h1>");*/
		} else if (session!=null && request.isRequestedSessionIdValid()) {
			session.invalidate();
			out.print("<html>");
			out.print("<head>");
			out.print("<title>Wel-Come Home</title>");
			out.print("<body style='background-color: yellow; color: black;'>");
			out.print("<fieldset style='height: 300px; width: 300px; margin-top: 100px; margin-left: 300px; margin-right: 300px;'>");
			out.print("<h1 style='color: green;'>Logging out successfully</h1>");
			out.print("<h1><a href='login'>Re-login</h1>");
			out.print("<h1><a href='home'>Home</h1>");
			out.print("<h5 style='color: red;'>loading home in 3 seconds...</h5>");
			out.print("</fieldset>");
			out.print("</body>");
			out.print("</html>");
			response.setHeader("refresh", "3;url=home");
		}
	}	
}