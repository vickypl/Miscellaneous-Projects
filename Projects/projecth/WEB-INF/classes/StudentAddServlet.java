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

//generate student form
public class StudentAddServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
	//fetch all data from client
	String  formNumStr  =request.getParameter("form_no");
	String  name  =request.getParameter("stu_name");
	String  ageStr  =request.getParameter("stu_age");
	long formNumber  = Long.parseLong(formNumStr);
	int age = Integer.parseInt(ageStr);
	
	
	//insert into db
	//TODO  Using JDBC Code insert into 
	//show result
	 
	
	StringBuilder htmlCode = new StringBuilder("");
    htmlCode.append("<html>");
	htmlCode.append("<head>");
	htmlCode.append("<title>Sis</title>");
	htmlCode.append("</head>");
	htmlCode.append("<body>");
	htmlCode.append("<a href=\"sis.html\" >goto home</a>");
   
	htmlCode.append("<h1>your data successfuly submitted..</h1>");
	htmlCode.append("<h1>"+formNumber+"::"+name+"::"+age+"</h1>");

     	//send dhtml code to browser
     	response.setContentType("text/html");
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	
	

	}//end service	  
  
}//End of class 
