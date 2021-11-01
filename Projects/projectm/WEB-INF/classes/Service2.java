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

public class Service2 extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
		  //fetch give request attribute
	Object obj1 = request.getAttribute("trainername");//String
	Object obj2 = request.getAttribute("mynumbers");//[]
	Object obj3 = request.getAttribute("mywords");//List
	Object obj4 = request.getAttribute("requestdate");//Date
	String name = (String)obj1;
	  double [] numbers  =(  double [] ) obj2;
	List<String> wordList = (List<String>)obj3;
	Date reqTime  =(Date) obj4;	  
		  
	//view presentation logic foucs 	  
		 
		   	  
	StringBuilder htmlCode = new StringBuilder("");
    htmlCode.append("<html>");
	htmlCode.append("<head>");
	htmlCode.append("<title>Sis</title>");
	htmlCode.append("</head>");
	htmlCode.append("<body>");
	htmlCode.append("<a href= \"sis.html\" >goto home</a>");
	htmlCode.append("<h1>"+name+"</h1>");
	htmlCode.append("<h1>"+Arrays.toString(numbers)+"</h1>");
	htmlCode.append("<h1>"+wordList+"</h1>");
	htmlCode.append("<h1>"+reqTime+"</h1>");
	htmlCode.append("</body>");
	htmlCode.append("</html>");
	//send dhtml code to browser
	response.setContentType("text/html");
	PrintWriter pw  = response.getWriter();
	pw.print(htmlCode);
		 
 }//end service	  
  
}//End of class 
