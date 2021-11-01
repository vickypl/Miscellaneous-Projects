import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;


public class RegisterUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(false);
		if (session==null || (session!=null && session.getAttribute("user")==null)) {
			response.sendRedirect("login");
			return;
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>AddUser</title>");
		out.print("<style type='text/css'>");
		if (session.getAttribute("msg")!=null) {
			out.print("<h4 style='margin-left: 500px; color: red;'>"+session.getAttribute("msg")+"</h4>");
			session.removeAttribute("msg");
		}
		out.print("fieldset {background-color: black; background-opacity: 0.9; background: transparent; border-radius: 24px; height: 200px; width: 300px; margin-top: 100px; margin-left: 470px; margin-right: 450px; padding: 40px; border-color: red;}");
		out.print("input[type=text], [type=password] {padding: 5px; border-radius: 24px; border-color: red; }");
		out.print("input[type=submit] { padding: 3px; border-color: red; border-radius: 24px; width: 190px; }");
		out.print("input[type=submit]:hover {border-color: blue;}");
		out.print("input[type=reset] { padding: 3px; border-color: red; border-radius: 24px; width: 90px; }");
		out.print("input[type=reset]:hover {border-color: blue;}");
		out.print("input[type=password]:hover {border-color: blue;}"); 
		out.print("input[type=text]:hover {border-color: blue;}");
		out.print("td {padding: 5px;}");
		out.print(".title {font-family: cursive; font-size: 22px;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body  style='background-color: pink; color='black'>");
		out.print("<h2 style='color: blue;'><a href='mainServ'>MainPage</a>&nbsp;&nbsp;&nbsp;<a href='homeLogged'>home</a>&nbsp;&nbsp;&nbsp;<a href='register'>Sign-Up</a>&nbsp;&nbsp;&nbsp;<a href='logout'>logout</a></h2>&nbsp;&nbsp;&nbsp;");
		out.print("<hr style='color: red; height: 10px;'>");
		out.print("<h3>userID::"+session.getAttribute("id")+"</h3>");
		out.print("<h3>Welcome user:"+session.getAttribute("user")+"</h3>");
		out.print("<h3>LogIn Time: "+session.getAttribute("timing")+"</h3>");
		out.print("<h3>UserType: "+session.getAttribute("role")+"</h3>");
		out.print("<hr style='color: red; height: 10px;'>");
		out.print("<fieldset>");
		if (request.getParameter("msg")!=null) {
			out.print("<h3 style='color: green;'>"+request.getParameter("msg")+"</h3>");
		}
		out.print("<table width='100%'>");
		out.print("<form action='register' method='post'>");
		out.print("<tr>");
		out.print("<td>Username</td>");
		out.print("<td><input type='text' name='username' value='' placeholder='Username' maxlength='10' required></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>Password</td>");
		out.print("<td><input type='text' name='password' value='' placeholder='Password' required></td>");
		out.print("</tr>");
		out.print("<tr>");
		// out.print("<td>Role</td>");
		// out.print("<td><input type='text' name='role' value='' placeholder='Role' required></td>");
		// out.print("</tr>");
		out.print("<tr>");
		out.print("<td><input type='reset' value='refresh'></td>");
		out.print("<td><input type='submit' value='Add User'></td>");
		out.print("</tr>");
		out.print("</form>");
		out.print("</table>");
		out.print("</fieldset>");
		out.print("</body>");
		out.print("</html>");
	}	


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(false);
		if (session==null || (session!=null && session.getAttribute("user")==null)) {
			response.sendRedirect("login");
			return;
		}


		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		//fetching form data;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role="user";

		Connection connection = null;
		PreparedStatement prepStatement = null;


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String dbUser="sis";
			String dbPass="root";
			connection=DriverManager.getConnection(url, dbUser, dbPass);
			String sql="insert into scoreupdater (id, username, password, role) values (scoupd.nextval, ?, ?, ?)";
			prepStatement=connection.prepareStatement(sql);
			prepStatement.setString(1, username);
			prepStatement.setString(2, password);
			prepStatement.setString(3, role);

			int r=prepStatement.executeUpdate();
			if (r>0) {
				//session.setAttribute("msg", "Added Successfully");
				response.sendRedirect("register?msg='Added Successfully'");
				//out.print("<h1 style='color: green;'>Data Successfully saved.");
				//request.setAttribute("msg", "Added Successfully");
				//RequestDispatcher rd = request.getRequestDispatcher("register");
				//rd.forward(request, response);

			} else {
				session.setAttribute("msg", "Failed to adduser.");
				//out.print("<h1 style='color: red;'>Failed to save the data.");
				response.sendRedirect("register");
			}


		} catch (ClassNotFoundException e) {
			out.print("<h1 style='color: red;'>Error in saving data 1>>"+e+"</h1>");
		} catch (SQLException e) {
			out.print("<h1 style='color: red;'>Error in saving data 2>>"+e+"</h1>");
		} catch (Exception e) {
			out.print("<h1 style='color: red;'>Error in saving data 3>>"+e+"</h1>");
		} finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					out.print("<h1 style='color: red;'>Error in saving data"+e+"</h1>");
				}
			}
		}
	}	

}