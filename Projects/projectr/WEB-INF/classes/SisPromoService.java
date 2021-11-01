
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
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
 

public class SisPromoService extends HttpServlet{ 
 
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
	
		htmlCode.append("</head>");
		htmlCode.append("<body'>");
		htmlCode.append("<hr>");
        htmlCode.append("<a href=\"sis.html\">Goto Home</a>&nbsp;");
        java.util.Random rand  = new java.util.Random();
		htmlCode.append("<h1>your dice service will start after 8 second</h1>");
        htmlCode.append("<a href=\"getdice\">Skip</a>&nbsp;<hr>");
		htmlCode.append("<img src=\"sispromo.jpg\">");
		htmlCode.append("</body>");
		htmlCode.append("</html>");
	  //refesh after 3 second and redirect in dice service
	   response.setHeader("refresh","8;url=getdice");  
	   //response.setHeader("refresh","8");  
		
		response.setContentType("text/html");//extra info to browser  Header
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
   
	}
 
 
	
}//End of class 
