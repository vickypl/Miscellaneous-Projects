
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
 

public class DiceService extends HttpServlet{ 
 
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
		htmlCode.append("<p> Your Dice number is ::= "+(rand.nextInt(6)+1)+"</p>");
		
		
		htmlCode.append("</body>");
		htmlCode.append("</html>");
 
		
		response.setContentType("text/html");//extra info to browser  Header
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
   
	}
 
 
	
}//End of class 
