
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
 

public class ReportServlet extends GenericServlet{ 
  
		 int totalDiceHit =0; //instance variable 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
		 //int totalDiceHit =0;
		java.util.Random rand  = new java.util.Random();
		int dice = rand.nextInt(6)+1;
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");

		ServletContext context  = getServletContext();
		Object ob1=context.getAttribute("RandomServiceTotalHit");
		Object ob2=context.getAttribute("DiceServiceTotalHit");
		Object ob3=context.getAttribute("RandServiceFistHitTime");
		Object ob4=context.getAttribute("DiceServiceFistHitTime");
     
     	Integer rth = null;
     	Integer dth = null;
	
		Date firstRandomHitTime=null;	
		Date firstDiceHitTime=null;	
		 if(ob1!=null){
			 rth =(Integer) ob1;
		 }
		 
		 if(ob2!=null){
			 dth =(Integer) ob2;
		 }
		  if(ob3!=null){
			 firstRandomHitTime =(Date) ob3;
		 }
		 
		  if(ob4!=null){
			 firstDiceHitTime =(Date) ob4;
		 }
	  
		
		htmlCode.append("<h3>total Dice service hit ="+dth+" </h3>");
		htmlCode.append("<h3>total Rand service hit ="+rth+" </h3>");
		htmlCode.append("<h3>firstRandomHitTime ="+firstRandomHitTime+" </h3>");
		htmlCode.append("<h3>firstDiceHitTime ="+firstDiceHitTime+" </h3>");
	  
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
