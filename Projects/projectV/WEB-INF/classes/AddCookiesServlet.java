
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

  //Date march/2021

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.*;
 

public class AddCookiesServlet extends HttpServlet{ 
  
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	   //how to create cookie object
  
	 String sisKey1 = "sis_"+((int)(Math.random()*1000));//sis_435
	 String sisValue1 = Math.random()+"";
	 Cookie sisCookie  = new Cookie(sisKey1, sisValue1);
	 
	 //add into response  how??
	 response.addCookie(sisCookie);
	 
	 
		
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<hr>");
		htmlCode.append("info added "+sisKey1+" = " +sisValue1+"<hr>" );
		 
		htmlCode.append("<a href=\"addcookie\">Add info cookies </a><br>");
		htmlCode.append("<hr>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");

	
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
