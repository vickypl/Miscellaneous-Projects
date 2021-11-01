import javax.servlet.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class UserHandle extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		String username=null;
		String password=null;

		if (context.getInitParameter("usr")!=null && context.getInitParameter("pass")!=null) {	
			username=context.getInitParameter("usr");
			password=context.getInitParameter("pass");
		}

		java.util.Date date = new java.util.Date();
		
		String usern=request.getParameter("username");
		String pass=request.getParameter("password");


		Connect connect = new Connect();
		Connection connection = connect.toConnect(username, password);
		Statement statement = connect.getStatement(connection);

		String query="select * from users";

		boolean flag=false;
		try {


		ResultSet rs = connect.getSet(statement, query);

		while(rs.next()) {
			if (rs.getString(2).equals(usern) && rs.getString(3).equals(pass)) {
				flag=true;
				break;
			} else {
				flag=false;
			}
		}

		} catch (SQLException e) {
			System.out.println(e);
		}

		response.setContentType("text/html");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("This is Number Servolet...");
		out.print("</title>");
		out.print("</head>");
		out.print("<body style='color: white; background: black;'>");
		out.print("<h1><a style='color: white;' href='index.html'>Home</a></h1>");
		out.print("<hr>");
		out.print("<h1>"+date+"</h1>");
		out.print("<hr>");
		if (flag) {
			out.print("Login successfull...");
			out.print("<hr>");
			out.print("<h1>Username: "+usern+"</h1>");

			try {		
			String sql="select * from users";
			ResultSet resultSet = connect.getSet(statement, sql);
				out.print("<table border='1' width='100%'>");
				out.print("<tr>");
				out.print("<th>id</th>");
				out.print("<th>username</th>");
				out.print("<th>password</th>");
				out.print("</tr>");
				while(resultSet.next()) {
					//out.print("<h3>"+resultSet.getString(1)+resultSet.getString(2)+resultSet.getString(3)+"</h1>");
					out.print("<tr>");
					out.print("<td>"+resultSet.getString(1)+"</td>");
					out.print("<td>"+resultSet.getString(2)+"</td>");
					out.print("<td>"+resultSet.getString(3)+"</td>");
					out.print("</tr>");
				}
				out.print("</table>");
			} catch (SQLException e) {
				System.out.println(e);
			}

/*			String one=request.getParameter("ide");
			String two=request.getParameter("usr");
			String three=request.getParameter("pwd");
			out.print("<fieldset>");
			out.print("<form action='page1'>");
			out.print("id:<input type='text' name='ide' value='' placeholder='id' required>");
			out.print("Username:<input type='text' name='usr' value='' placeholder='username' required>");
			out.print("Password:<input type='text' name='pwd' value='' placeholder='password' required>");
			out.print("<input type='submit' name='sub' value='submit'>");
			out.print("</form>");
			out.print("</fieldset>");

			out.print("<h1>"+one+"</h1>");
			out.print("<h1>"+two+"</h1>");
			out.print("<h1>"+three+"</h1>");*/
			//sql="insert into users values("+one+","+two+","+three+")";

		} else {
			out.print("<center><h1>Email/password wrong ...try again..</h1></center>");
		}
		out.print("</body>");
		out.print("</html>");

	}
}