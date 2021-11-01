import javax.servlet.*;
import java.util.*;
import java.io.*;

public class NumberServ extends GenericServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		Random rand = new Random();
		PrintWriter out = response.getWriter();
		Date date = new Date();

		long number=Long.parseLong(request.getParameter("num"));

		long noOfDigits=noOfDigit(number);
		long sumOfDigits=numSum(number);

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
		out.print("<h2>"+date+"</h2>");
		out.print("<center>");
		out.print("<fieldset style='height: 270px; width: 400px;'>");
		out.print("<hr>");
		out.print("<h1> Number is: "+number+"</h1>");
		out.print("<hr>");
		out.print("<h2> Number of Digits: "+noOfDigits+"</h2>");
		out.print("<hr>");
		out.print("<h2> Sum of Digits: "+sumOfDigits+"</h2>");
		out.print("<hr>");
		out.print("</fieldset>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
	}

	public static long noOfDigit(long number) {

		long count=0;

		while(number!=0) {
			count++;
			long xxx=number%10;
			number=number/10;
		}

		return count;
	}


	public static long numSum(long number) {

		long sum=0;

		while(number!=0) {
			long xxx=number%10;
			number=number/10;
			sum=sum+xxx;
		}

		return sum;
	}
}