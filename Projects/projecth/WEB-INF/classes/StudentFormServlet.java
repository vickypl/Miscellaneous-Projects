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
public class StudentFormServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
	StringBuilder htmlCode = new StringBuilder("");
    htmlCode.append("<html>");
	htmlCode.append("<head>");
	htmlCode.append("<title>Sis</title>");
	htmlCode.append("</head>");
	htmlCode.append("<body>");
	htmlCode.append("<a href=\"sis.html\" >goto home</a>");
	htmlCode.append("<fieldset> <legend>Stduent Form</legend>");
	
	
	htmlCode.append("<form  action=\"addstu\" >");
	htmlCode.append("<table>");
	
	long formNo = System.nanoTime();//create logic
	
	htmlCode.append("<tr>");
	htmlCode.append("<td>form no</td>");
	htmlCode.append("<td><input type=\"text\" name=\"form_no\"   value=\""+formNo+"\" required></td>");
	htmlCode.append("<tr>");
	
	htmlCode.append("<tr>");
	htmlCode.append("<td>name</td>");
	htmlCode.append("<td><input type=\"text\" name=\"stu_name\" required></td>");
	htmlCode.append("<tr>");
	
	htmlCode.append("<tr>");
	htmlCode.append("<td>age</td>");
	htmlCode.append("<td><input type=\"text\" name=\"stu_age\" required></td>");
	htmlCode.append("<tr>");
	  
	htmlCode.append("<tr>");
	htmlCode.append("<td></td>");
	htmlCode.append("<td><input type=\"submit\" value=\"Add student\"></td>");
	htmlCode.append("<tr>");
	 
	htmlCode.append("</table>");
	htmlCode.append("</form >");
	
	
	
	
htmlCode.append("</body>");
htmlCode.append("</html>");

//send dhtml code to browser
response.setContentType("text/html");
PrintWriter pw  = response.getWriter();
pw.print(htmlCode);
	
	

	}//end service	  
  
}//End of class 
