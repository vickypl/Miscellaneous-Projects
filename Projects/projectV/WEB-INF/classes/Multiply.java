import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.*;
import java.util.*;

public class Multiply extends GenericServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {


		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<h1>Hellow this is multiplication table genrator...</h1>");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("Multiplier..");
		out.print("</title>");
		out.print("</head>");
		out.print("<body style='color: white; background: black;'>");
		out.print("<p>Multiplication table from 1 to 10</p>");
		int i=0,j=0;
		//style='border: 2px solid white;'
		out.print("<table style='width:100%; border: 2px solid white;'>");
		for (i=1; i<=10; i++) {
			out.print("<tr style='padding: 5px; border: 2px solid white;'>");
			for (j=1; j<=10; j++) {
				out.print("<td style='padding: 5px; border: 2px solid white;'>");
				out.print(j+" * "+i+" = "+(i*j));
				out.print("</td>");
				//'i'+'*'+'j'+'='+i*j
			}
			out.print("<tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}
}