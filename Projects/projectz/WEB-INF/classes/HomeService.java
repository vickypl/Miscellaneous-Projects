
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
 
//for all user 

public class HomeService extends HttpServlet{ 
  
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
	 
	     
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<hr>");
		htmlCode.append("<h1>Sis Home Page</h1>");
		htmlCode.append("<hr>");
		//login if not loged in
		//else redirct to main service  page
		//get old session for redire 
/*HttpSession oldSession  = request.getSession();
  HttpSession oldSession  = request.getSession(true);
  exist give old session or not exist then create new one
*/		
		HttpSession oldSession  = request.getSession(false);
		//give old one or NULL if not exist
		if(oldSession==null ||  oldSession.getAttribute("user")==null){
			htmlCode.append("<a href=\"login\">User Login</a>&nbsp;");
		}else{
			//if logged in user redirect to main service page  
			response.sendRedirect("mainservice");
		}
		
		htmlCode.append("<hr>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");

	
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
