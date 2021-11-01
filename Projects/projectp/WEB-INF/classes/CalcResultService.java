
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
 

public class CalcResultService extends GenericServlet{ 
  
		 int totalDiceHit =0; //instance variable 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
	 
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");

		ServletContext context  = getServletContext();
	 

	    Integer number1 =(Integer)request.getAttribute("number1");
	    Integer number2 =(Integer)request.getAttribute("number2");
	    Integer sum =(Integer)request.getAttribute("sum");
		Integer sub=(Integer)request.getAttribute("sub");
		Float div=(Float)request.getAttribute("div");
		Integer mul=(Integer)request.getAttribute("mul");
		Integer mode=(Integer)request.getAttribute("mode");

	 
		htmlCode.append("<h3>number1="+number1+" </h3>");
		htmlCode.append("<h3>number2="+number2+" </h3>");
		htmlCode.append("<h3>sum="+sum+" </h3>");ss
		htmlCode.append("<h3>sub="+sub+" </h3>");
		htmlCode.append("<h3>div="+div+" </h3>");
		htmlCode.append("<h3>mul="+mul+" </h3>");
		htmlCode.append("<h3>mode="+mode+" </h3>");

 
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
