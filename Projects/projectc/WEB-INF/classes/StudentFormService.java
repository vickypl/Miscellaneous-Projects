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

public class StudentFormService extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
	//get input(parameter) from user
	String   name = request.getParameter("stu_name");
	String   ageStr = request.getParameter("stu_age");
	String   gender= request.getParameter("stu_gender");
	String   address = request.getParameter("stu_address");
	
	String   []skillList = request.getParameterValues("stu_skill");
	//parse
	int age = Integer.parseInt(ageStr);

	PrintWriter pw  = response.getWriter();
	response.setContentType("text/html");
	pw.print("<html>");
	pw.print("<head>");
	pw.print("<title>Sis</title>");
	pw.print("</head>");
	pw.print("<body>");
	pw.print("<a href= \"sis.html\" >goto home</a>");
	pw.print("<hr>");
	 //todo store data in db or other place    TODO
	pw.print("<h1>Your follwing data saved.successfully..</h1>");
	pw.print("<h2>name="+name+"</h2>");
	pw.print("<h2>age="+age+"</h2>");
	pw.print("<h2>gender="+gender+"</h2>");
	pw.print("<h2>address="+address+"</h2>");
	if(skillList!=null){
		pw.print("<h2>total skill "+skillList.length+"</h2>");
		pw.print("<h2>skills are</h2>");
		for(String s: skillList){
		pw.print("<b>"+s+"</b><br>");
		  
		}
	}else{
		pw.print("<h2>NO skills selected</h2>");
	
	}	
	
	pw.print("</body>");
	pw.print("</html>");
 }//end service	  
  
}//End of class 
