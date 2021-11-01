
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
 

public class Service3 extends  HttpServlet{ 
  
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
	 HttpSession session = request.getSession();
	  String userName =null;
	  Date userTime  = null;
	  Object obj1 = session.getAttribute("clientName");
	  Object obj2 = session.getAttribute("loginTime");
	  if(obj1!=null && obj1 instanceof String){
		  userName =  (String)obj1;
	  }
	  if(obj2!=null && obj2 instanceof Date){
		  userTime =  (Date)obj2;
	  }
	  
	  //add data related service3  in session object
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body bgcolor='pink'>");
		htmlCode.append("<hr>");
		htmlCode.append("<h1>Hello User "+userName+"</h1>");
		htmlCode.append("<h1>Login time  "+userTime+"</h1>");
		htmlCode.append("<h1>session.getId() "+session.getId()+"</h1>");
		htmlCode.append("<h1>session.isNew() "+session.isNew()+"</h1>");
	
		htmlCode.append("<hr>");
		htmlCode.append("<hr>");
		htmlCode.append("<h1>Service 3</h1>");
		htmlCode.append("<hr>");
		htmlCode.append("<a href=\"s1\">service1</a>&nbsp;");
		htmlCode.append("<a href=\"s2\">service2</a>&nbsp;");
		htmlCode.append("<a href=\"s3\">service3</a>&nbsp;");
		htmlCode.append("<a href=\"s4\">service4</a>&nbsp;");
		htmlCode.append("<hr>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");

	
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
