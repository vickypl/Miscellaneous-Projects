
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

public class MainPageService extends HttpServlet{ 
  
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
	 
	 HttpSession session  = request.getSession(false);
	 if(session==null||(  session!=null && session.getAttribute("user")==null)){
		 response.sendRedirect("logout");
		 return;
	 }
	 
	 	User user  = (User) session.getAttribute("user");     
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<hr>");
		htmlCode.append("<a href='showemp'>show all emp</a>");
		htmlCode.append("<a href='showdept'>show all dept</a>");
		htmlCode.append("<a href='logout'>User Logout</a>");
		htmlCode.append("<hr>");
		htmlCode.append("<h1>Main page Service</h1>");
		htmlCode.append("<h1>Welcome user"+user.getName()+" </h1>");
		htmlCode.append("<h1>"+user.getId()+"("+user.getRole()+") </h1>");
		htmlCode.append("<h1>Login imte "+session.getAttribute("userLogintime")+ "</h1>");
		htmlCode.append("<hr>");
		
		htmlCode.append("<hr>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");

	
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
