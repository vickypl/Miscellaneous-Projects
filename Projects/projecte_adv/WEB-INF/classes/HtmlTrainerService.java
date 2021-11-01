
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

public class HtmlTrainerService extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
	  
	  
     ServletContext context  =getServletContext();
	 //fetch context param    context.getInitParameter("key");
	
     String sisLogo = context.getInitParameter("sis_logo");  //"sis.jpg";//sis2.jpg
	 String sisMsg = context.getInitParameter("sis_msg");  //"happy programming";
	 String sisContact = context.getInitParameter("sis_contact"); //"9009442844";

   
   
//   how to fetch init parameter cofig
     ServletConfig config = getServletConfig();	 
     String trainerName=config.getInitParameter("trainer_name");//"Ramesh";
     String trainerExp=config.getInitParameter("trainer_ex");//"+5";
     String trainerImg=config.getInitParameter("trainer_img");//"ramesh.jpg";
	 String htmlTopic=config.getInitParameter("html_topic");//table,form
	 String javaTopic=config.getInitParameter("java_topic");//"null
	  
   
	  
	PrintWriter pw  = response.getWriter();
	response.setContentType("text/html");
	pw.print("<html>");
	pw.print("<head>");
	pw.print("<title>Sis</title>");
	pw.print("</head>");
	pw.print("<body bgcolor=\'black\'  text='white' >");
	pw.print("<a href= \"sis.html\" >goto home</a>");
	pw.print("<h1>Html Service </h1><hr>");

	pw.print("<img src=\'"+sisLogo+"\'  width=\'200\' height=\'200\'>");
	pw.print("<h1>sis Msg "+sisMsg+ "</h1><hr>");
	pw.print("<h1>sis Contact "+sisContact+ "</h1><hr>");
 

    pw.print("<h1>--------Html Trainer Details-------</h1><br>");
	pw.print("<h1>trainerName "+trainerName+ "</h1><br>");
	pw.print("<h1>trainerExp "+trainerExp+ "</h1><br>");
	pw.print("<h1>javaTopic "+ javaTopic+ "</h1><br>");
	pw.print("<h1>htmlTopic "+ htmlTopic+ "</h1><br>");
 
    pw.print("<img src=\'"+trainerImg+"\'  width=\'200\' height=\'200\'>");
	pw.print("</body>");
	pw.print("</html>");
 }//end service	  
  
}//End of class 
