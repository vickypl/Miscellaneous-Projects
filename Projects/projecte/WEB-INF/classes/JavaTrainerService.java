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

public class JavaTrainerService extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
     //sis logo   for all dynamic pages
     //sis msg	  for all dynamic pages
     //sis mobile	  for all dynamic pages
     String sisLogo="sis.jpg";//sis2.jpg
	 String sisMsg="happy programming";
	 String sisContact="9009442844";
   
     String trainerName="sk";
     String trainerExp="+12";
     String trainerImg="sk.jpg";
	 String topic="data type , String,Array loop"; 
	  
	  
	PrintWriter pw  = response.getWriter();
	response.setContentType("text/html");
	pw.print("<html>");
	pw.print("<head>");
	pw.print("<title>Sis</title>");
	pw.print("</head>");
	pw.print("<body bgcolor=\'pink\' >");
	pw.print("<a href= \"sis.html\" >goto home</a>");
	pw.print("<h1>java Service </h1><hr>");
	
    pw.print("<img src=\'"+sisLogo+"\'  width=\'200\' height=\'200\'>");
	pw.print("<h1>sis Msg "+sisMsg+ "</h1><hr>");
	pw.print("<h1>sis Contact "+sisContact+ "</h1><hr><hr>");

	pw.print("<h1>-java-------Trainer Details-------</h1><br>");
	pw.print("<h1>trainerName "+trainerName+ "</h1><br>");
	pw.print("<h1>trainerExp "+trainerExp+ "</h1><br>");
	pw.print("<h1>topic"+topic+ "</h1><br>");
    pw.print("<img src=\'"+trainerImg+"\'  width=\'200\' height=\'200\'>");
 

	pw.print("</body>");
	pw.print("</html>");
 }//end service	  
  
}//End of class 
