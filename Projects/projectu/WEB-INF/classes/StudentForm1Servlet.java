
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
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
 

public class StudentForm1Servlet extends HttpServlet{ 
  //generat form1
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<h1>Student form (Step1/3)</h1>");
		
		htmlCode.append("<form action='sf1' method='post'>");
		htmlCode.append("Name:<input name=\"stu_name\"><br>");
		htmlCode.append("age:<input name=\"stu_age\"><br>");
		htmlCode.append("<input type=\"submit\" value=\"next\"><br>");
		htmlCode.append("</form>");
		
		htmlCode.append("</body>");
		
		htmlCode.append("</html>");
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
	
	
	
	//submit form1  
	 @Override  
 public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
	  //TODO get param
	  
	  String  stuName= request.getParameter("stu_name");//found
	  String  stuAge= request.getParameter("stu_age");//found
	  
	  //TODO then save into db ::In our case NOT Required do in last form
	   
	 //then generate next form 
	StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<h1>Student form (Step2/3)</h1>");

		htmlCode.append("<form action='sf2' method='post'>");
		//hide given data  using hidden form field
		htmlCode.append("<input name=\"stu_name\"   type=\"hidden\"   value=\""+stuName+"\">");
		htmlCode.append("<input name=\"stu_age\" type=\"hidden\" value=\""+stuAge+"\">");
		
		htmlCode.append("Mobile:<input name=\"stu_mobile\"><br>");
		htmlCode.append("Email:<input name=\"stu_email\"><br>");
		htmlCode.append("<input type=\"submit\" value=\"next\"><br>");
		htmlCode.append("</form>");
		htmlCode.append("</body>");
 
		htmlCode.append("</html>");
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	
	
	 }//end service 	
	
	
}//End of class 
