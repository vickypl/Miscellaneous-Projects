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

public class TableService extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{

	StringBuilder htmlCode = new StringBuilder("");
     htmlCode.append("<html>");
	htmlCode.append("<head>");
	htmlCode.append("<title>Sis</title>");
	htmlCode.append("</head>");
	htmlCode.append("<body>");
	htmlCode.append("<a href= \"sis.html\" >goto home</a>");
	htmlCode.append("<hr>");
	htmlCode.append("<h1>today is "+new Date()+"</h1>");
	//table1
	htmlCode.append("<table border='1' width='100%'>");
	for(int r=1;r<=5;r++){
		htmlCode.append("<tr>");
		htmlCode.append("<td>sno#"+r+"</td>");
		htmlCode.append("<td>"+Math.random()+"</td>");
		htmlCode.append("</tr>");
	}
	htmlCode.append("</table>");


	//table2
	htmlCode.append("<table border='1' width='100%'>");
	for(int r=1;r<=10;r++){
		htmlCode.append("<tr>");
		for(int c=1;c<=10;c++){
			htmlCode.append("<td>"+(r*c)+"</td>");
		}
		htmlCode.append("</tr>");
	}
	
	htmlCode.append("</table>");


	
   String str  ="SURENDRA";	
   
	//table3
	htmlCode.append("<table border='1' width='100%'>");
	for(int r=1;r<=str.length();r++){
		htmlCode.append("<tr>");
		for(int c=1;c<=str.length();c++){
			htmlCode.append("<td>"+str+"</td>");
		}
		htmlCode.append("</tr>");
	}
	
	htmlCode.append("</table>");


	//table4
	
	htmlCode.append("<table border='1' >");
	for(int r=1;r<=str.length();r++){
		htmlCode.append("<tr>");
		for(int c=1;c<=str.length();c++){
		     if(c<=r){
			htmlCode.append("<td>"+str.charAt(c-1)+"</td>");
			}else{
			htmlCode.append("<td>  </td>");
			}
		}
		htmlCode.append("</tr>");
	}
	
	htmlCode.append("</table>");



	htmlCode.append("</body>");
	htmlCode.append("</html>");

	//send dhtml code to browser
     	response.setContentType("text/html");
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	
	

	}//end service	  
  
}//End of class 
