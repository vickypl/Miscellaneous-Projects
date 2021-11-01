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

public class AddStudentFormServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
   
 
 //presentation logic 
	StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<hr><hr color='blue'>");
		htmlCode.append("<a href=\"sis.html\" >goto home</a>&nbsp ");	
		htmlCode.append("<a href=\"addstuform\">get add  student form</a> &nbsp ");	
		htmlCode.append("<a href=\"showallstu\" >show all studdent</a>");	
		htmlCode.append("<a href='showallcheckbox'>show all student with Check box option</a> &nbsp;");	
		htmlCode.append("<hr><hr color='blue'>");
	
		htmlCode.append("<fieldset> <legend>Add Stduent Form</legend>");
		
		htmlCode.append("<form  action=\"addsturecord\" >");
		htmlCode.append("<table border='1' width='100%' >");
		htmlCode.append("<tr>");
		
		htmlCode.append("<td>id</td>");
		htmlCode.append("<td><input type=\"text\" name=\"stu_id\" ></td>");
		htmlCode.append("<tr>");
		
		htmlCode.append("<td>name</td>");
		htmlCode.append("<td><input type=\"text\" name=\"stu_name\" ></td>");
		htmlCode.append("<tr>");
		
		htmlCode.append("<td>age</td>");
		htmlCode.append("<td><input type=\"text\" name=\"stu_age\" ></td>");
		htmlCode.append("<tr>");
		
		
		htmlCode.append("<td>gender</td>");
		htmlCode.append("<td>");
		htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"male\" > Male");
		htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"female\" > FeMale");
		htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"other\" > Other");
		htmlCode.append("</td>");
		
		htmlCode.append("<tr>");
		 
		
		htmlCode.append("<tr>");
		htmlCode.append("<td></td>");
		htmlCode.append("<td><input type=\"submit\" value=\"add Student\"></td>");
		htmlCode.append("<tr>");
		htmlCode.append("</table>");
		
		htmlCode.append("</form >");
		
		htmlCode.append("</fieldset>");
	
	htmlCode.append("</body>");
	htmlCode.append("</html>");

	//send dhtml code to browser
	response.setContentType("text/html");
	PrintWriter pw  = response.getWriter();
	pw.print(htmlCode);
	
	}//end service	  
  
}//End of class 
