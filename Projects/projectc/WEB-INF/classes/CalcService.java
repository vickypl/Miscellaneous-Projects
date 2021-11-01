/*   ########Surendra IT Solution############
	@copyright  Surendra 2021
	
  @Author:Surendra Kumar Sao
	>>Software Architect and Corporate Trainer
	>>+12 year exp in (mumbai,pune,hyd,bangaluru)  
	JPMorgan,Aurionpro,zycus...
	>>Java Certified SCJP & SCWCD with 98%
	Trained more than 5k students and employees.
    MCA from (NIT)National Institute of Technology Raipur(C.G.)
	Email : sur.nit.mca@gmail.com
	Mobile   9009442844 ,7987234544
	https://www.urbanpro.com/raipur/surendra-kumar-sao/reviews/7223178
	https://www.urbanpro.com/raipur/surendra-kumar-sao/1334109?_tp=
 */

  //Date  18/02/2021

import javax.servlet.*;
import java.io.*;
import java.util.*;

public class CalcService extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
	  //get input from user 
	  String num1Str  = request.getParameter("num_1");//  "10"
	  String num2Str  = request.getParameter("num_2");   //"20"
	  //parse
	  int num1  = Integer.parseInt(num1Str);
	  int num2  = Integer.parseInt(num2Str);
	  //process
	int sum  = num1+num2;
	  
	  //printing...
	PrintWriter pw  = response.getWriter();
	response.setContentType("text/html");
	pw.print("<html>");
	pw.print("<head>");
	pw.print("<title>Sis</title>");
	pw.print("</head>");
	pw.print("<body>");
	pw.print("<a href= \"sis.html\" >goto home</a>");
	pw.print("<hr>");
	pw.print("<h1>"+ num1+    " + "  +num2  +" = "  +sum  + "</h1>");
	
	pw.print("</body>");
	pw.print("</html>");
 }//end service	  
  
}//End of class 
