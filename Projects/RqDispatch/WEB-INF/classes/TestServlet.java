import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class TestServlet extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {

		String string = "This is Servlet One";

		PrintWriter out = response.getWriter();

		out.print("<h1 style='color: red;'>"+string+"</h1>");

		// RequestDispatcher reqDispatcher = null;
		// reqDispatcher = request.getRequestDispatcher("");
		// reqDispatcher.forward(request, response);


		// gotten by the texts..

		RequestDispatcher  rd = null;
	  	rd  = request.getRequestDispatcher("serv2");//for service2
	  	rd.include(request,response);
	  	//rd.forward(request,response);
	   	System.out.println("C from Service1");
	}
}