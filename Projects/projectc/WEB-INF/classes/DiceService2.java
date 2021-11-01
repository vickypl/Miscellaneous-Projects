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

public class DiceService2 extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
	PrintWriter pw  = response.getWriter();
	response.setContentType("text/html");
	pw.print("<html>");
	pw.print("<head>");
	pw.print("<title>Sis</title>");
	pw.print("</head>");
	pw.print("<body>");
	pw.print("<a href= \"sis.html\" >goto home</a>");
	pw.print("<hr>");
	java.util.Random rand  = new java.util.Random();
	for(int d=1;d<=5;d++){
		int dice  = rand.nextInt(6)+1;
		pw.print("<h1>dice number "+dice+"</h1>");
	}
	pw.print("</body>");
	pw.print("</html>");
 }//end service	  
  
}//End of class 
