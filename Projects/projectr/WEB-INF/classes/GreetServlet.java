
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
 

public class GreetServlet extends HttpServlet{ 
 
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
		 
		response.setContentType("text/html");//extra info to browser  Header
		PrintWriter pw  = response.getWriter();
		pw.print("get request called");
   
	}
 
 
 
 @Override  
 public void doPost(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
		 
		response.setContentType("text/html");//extra info to browser  Header
		PrintWriter pw  = response.getWriter();
		pw.print("POST******* request called");
   
	}
 
	
}//End of class 
