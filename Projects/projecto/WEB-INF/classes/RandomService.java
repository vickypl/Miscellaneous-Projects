
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
 

public class RandomService extends GenericServlet{ 
  
		 int totalRadomHit =0; //instance variable 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
		  	ServletContext context  = getServletContext();
		  //if not exist create 
		  if(context.getAttribute("RandomServiceTotalHit")==null){
			  context.setAttribute("RandomServiceTotalHit",new Integer(0));
			  context.setAttribute("RandServiceFistHitTime",new Date());
		 }
		  
		  
		  
		  
		java.util.Random rand  = new java.util.Random();
		int num = rand.nextInt();
		totalRadomHit++;
		//update  for share to all 
		Integer temp =(Integer) context.getAttribute("RandomServiceTotalHit");
		temp++;
		context.setAttribute("RandomServiceTotalHit",temp);
		
		
		
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("<style>");
		htmlCode.append("tr:hover{background-color:pink;}");
		htmlCode.append("</style>");
		htmlCode.append("</head>");
		htmlCode.append("<body bgcolor='lime'>");
		htmlCode.append("<h3>random = "+num+"</h3>");
		htmlCode.append("<h3>totalRadomHit = "+ (totalRadomHit)+"</h3>");
	 
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
