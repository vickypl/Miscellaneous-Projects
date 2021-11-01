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

public class ShowAllEmployeeControllerHelper extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
 
   //fetch required parameter 
		 
	 	List<Employee> empList =(List<Employee>) request.getAttribute("allemps");
		StringBuilder errorCode = (StringBuilder)  request.getAttribute("errorCode"); 
 
		                   
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("<style>");
		htmlCode.append("tr:hover{background-color:pink;}");
		htmlCode.append("</style>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		  
		htmlCode.append("<table border='1' width='100%' >");
		htmlCode.append("<tr>");
		htmlCode.append("<th>id</th>");
		htmlCode.append("<th>name</th>");
		htmlCode.append("<th>job</th>");
		htmlCode.append("<th>hiredate</th>");
		htmlCode.append("<th>salary</th>");
		htmlCode.append("<th>com</th>");
		htmlCode.append("<th>deptno</th>");
		htmlCode.append("</tr>");
	
	for(Employee emp: empList){
		htmlCode.append("<tr>");
			htmlCode.append("<td>"+emp.getId()+"</td>");
			htmlCode.append("<td>"+emp.getName()+"</td>");
			htmlCode.append("<td>"+emp.getJob()+"</td>");
			htmlCode.append("<td>"+emp.getHireDate()+"</td>");
			htmlCode.append("<td>"+emp.getSalary()+"</td>");
			htmlCode.append("<td>"+emp.getCommition()+"</td>");
			htmlCode.append("<td>"+emp.getDeptNo()+"</td>");
		htmlCode.append("</tr>");
	}

	htmlCode.append("</table>");
	response.setContentType("text/html");//MIME TYPE
	PrintWriter pw  = response.getWriter();
	pw.print(htmlCode);
 
  
	}//end service	  
}//End of class 
