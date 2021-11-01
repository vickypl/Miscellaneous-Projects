
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
 

public class StudentForm2Servlet extends HttpServlet{ 
 
	
	//submit form2  
	 @Override  
 public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
	  //TODO get param
	  String  stuName= request.getParameter("stu_name");//found  //dynamic code
	  String  stuAge= request.getParameter("stu_age");//found    //dynamic code
	  String  stuMobile= request.getParameter("stu_mobile");
	  String  stuEmail= request.getParameter("stu_email");
	  
	  //TODO then save into db ::In our case NOT Required do in last form
	 
	 //then generate next form 
	StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<h1>Student form (Step3/3)</h1>");

		htmlCode.append("<form action='sf3' method='post'>");
		//form1data		
			//hide given data  using hidden form field
	    htmlCode.append("<input name=\"stu_name\"   type=\"hidden\"   value=\""+stuName+"\">");
		htmlCode.append("<input name=\"stu_age\" type=\"hidden\" value=\""+stuAge+"\">");
	   //form2 data
	   	//hide given data  using hidden form field
		htmlCode.append("Mobile:<input name=\"stu_mobile\"   type=\"hidden\"  value=\""+stuMobile+"\">");
		htmlCode.append("Email:<input name=\"stu_email\"   type=\"hidden\"  value=\""+stuEmail+"\">");
		
		htmlCode.append("address:<input name=\"stu_address\"><br>");
		htmlCode.append("Pin:<input name=\"stu_pin\"><br>");
		htmlCode.append("<input type=\"submit\" value=\"Finish>>\"><br>");
		htmlCode.append("</form>");
		htmlCode.append("</body>");
			 
		htmlCode.append("</html>");
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	
	
	 }//end service 	
	
	
}//End of class 
