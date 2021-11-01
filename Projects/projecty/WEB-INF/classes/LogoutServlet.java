
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
 

public class LogoutServlet extends HttpServlet{ 
  
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
	   
	  
	  
	  //add data related service1  in session object
	  
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body bgcolor='pink'>");
		HttpSession session = request.getSession(false);
		if(session==null){
			htmlCode.append("session already expired </h1>");
		}else{
			session.invalidate();
			htmlCode.append("Logout successfuly </h1>");
			htmlCode.append("<a href='login'>Re-login</a>");
			htmlCode.append("<a href='sishome'>back to home</a>");
		}
		htmlCode.append("</body>");
		htmlCode.append("</html>");
		
	
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
