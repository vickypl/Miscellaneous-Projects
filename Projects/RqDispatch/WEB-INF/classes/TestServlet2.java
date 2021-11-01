import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class TestServlet2 extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {

		String string = "This is Servlet tWo";

		PrintWriter out = response.getWriter();

		out.print("<h1 style='color: green;'>"+string+"</h1>");

/*		RequstDispatcher reqDispatcher = null;
		reqDispatcher = request.getRequestDispatcher("serv2");
		reqDispatcher.forward(request, response);*/

/*
		RequestDispatcher  rd = null;
	  	rd  = request.getRequestDispatcher("serv");//for service2
	  	//rd.include(request,response);
	  	rd.forward(request,response);
	   	System.out.println("C from Service1");*/
	}
}