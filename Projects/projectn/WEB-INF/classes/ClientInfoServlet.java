
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
import java.sql.*;

public class ClientInfoServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
 
       
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("<style>");
		htmlCode.append("tr:hover{background-color:pink;}");
		htmlCode.append("</style>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<h3>getScheme= "+request.getScheme()+"</h3>");
		htmlCode.append("<h3>getServerName= "+request.getServerName()+"</h3>");
		htmlCode.append("<h3>getProtocol= "+request.getProtocol()+"</h3>");
		htmlCode.append("<h3>isSecure="+request.isSecure()+"</h3><hr>");
		
		htmlCode.append("<h3>getRemoteAddr= "+request.getRemoteAddr()+"</h3>");
		htmlCode.append("<h3>getRemoteHost= "+request.getRemoteHost()+"</h3>");
		htmlCode.append("<h3>getRemotePort="+request.getRemotePort()+"</h3><hr>");
		
		htmlCode.append("<h3>getLocalAddr="+request.getLocalAddr()+"</h3>");
		htmlCode.append("<h3>getLocalName="+request.getLocalName()+"</h3>");
		htmlCode.append("<h3>getLocalPort="+request.getLocalPort()+"</h3>");
	 
 
 
	 
	 
	response.setContentType("text/html");//MIME TYPE
	PrintWriter pw  = response.getWriter();
	pw.print(htmlCode);
 
  
	}//end service	  
}//End of class 
