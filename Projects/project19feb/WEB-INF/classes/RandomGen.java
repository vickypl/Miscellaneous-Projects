import javax.servlet.*;
import java.util.*;
import java.io.*;

public class RandomGen extends GenericServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {


		Random rand = new Random();
		PrintWriter out = response.getWriter();

		java.util.Date date = new java.util.Date();

		response.setContentType("text/html");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("This is Random Number Genrator..");
		out.print("</title>");
		out.print("</head>");
		out.print("<body style='color: white; background: black;'>");
		out.print("<h1><a style='color: white;' href='index.html'>Home</a></h1>");
		out.print("<hr>");
		out.print("<h2>"+date+"</h2>");
		out.print("<hr>");
		out.print("<fieldset style='padding-left: 300px; padding-right: 300px; padding-top: 10px;'>");
		out.print("<form action='random'>");
		out.print("<h3>Enter Number:<input type='text' style='height: 25px; width: 20px;' name='nunu' maxlength='2' value='' placeholder='Enter number of randome you want to print' required></h3>");
		out.print("<input type='submit' style='padding: 10px; border-radius: 10px; width: 150px; height: 30px;' value='getRandomNumbers'>");
		out.print("</form>");
		out.print("<hr>");
		out.print("<h2> Randome Number: "+rand.nextInt(999999)+100000+"</h2>");
		out.print("</fieldset>");
		int num=0;
		num=Integer.parseInt(request.getParameter("nunu"));
		if (num!=0) {
			out.print("<h4>"+num+" random number genrated..</h4>");
			for (int i=1; i<=num; i++) {
				out.print("<h3> Randome Number#"+i+":- "+rand.nextInt(999999)+100000+"</h3>");
				out.print("<hr>");
				//try { Thread.sleep(1000); } catch(Exception e) { out.println(e);}
			}
		}
		out.print("<hr>");
		out.print("</body>");
		out.print("</html>");
	}
}