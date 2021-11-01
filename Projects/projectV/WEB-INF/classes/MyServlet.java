import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;

public class MyServlet extends GenericServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException{

		java.util.Date date = new java.util.Date();

		java.util.Random rand = new java.util.Random();

		java.io.PrintWriter out  = response.getWriter();
		
		response.setContentType("text/html");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("This is myServolet...");
		out.print("</title>");
		out.print("</head>");


		out.print("<body style='color: white; backgroud: black;'>");
		out.print("<hr>");
		out.print("<h2>"+date+"</h2>");
		for (int i=0; i<15; i++) {
			double digit=rand.nextInt(19999999)+10000000;
			// System.out.println("Randome digit#"+i+": "+digit);
			out.print("<hr>");
			out.print("Randome digit#"+i+": "+digit);
			out.print("<hr>");
		}

		out.print("</body>");
		out.print("</html>");
	}

}