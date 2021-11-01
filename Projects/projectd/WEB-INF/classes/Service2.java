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

public class Service2 extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
	  //get config object
	  ServletConfig conf = getServletConfig();//each servlet has personal object
	  //get context object
	  ServletContext context = getServletContext();//all servlet has common object
	  
	  
	PrintWriter pw  = response.getWriter();
	response.setContentType("text/html");
	pw.print("<html>");
	pw.print("<head>");
	pw.print("<title>Sis</title>");
	pw.print("</head>");
	pw.print("<body bgcolor=\'brown\' >");
	pw.print("<a href= \"sis.html\" >goto home</a>");
	pw.print("<h1>Service 1 called </h1><hr>");
	pw.print("Request Object  = "+request +"<br>"  );
	pw.print("reqsponse Object  = "+response +"<br>"  );
	pw.print("Servlet config Object  = "+conf +"<br>"  );
	pw.print("servlet context Object  = "+context +"<br>"  );
		pw.print("servlet Object  = "+this +"<br>"  );
	Thread t  = Thread.currentThread();
	pw.print("Thread detals  = "+t.getId()+" "+t.getName() +":: "+ t.toString() +"<br>"  );
	pw.print("</body>");
	pw.print("</html>");
 }//end service	  
  
}//End of class 
