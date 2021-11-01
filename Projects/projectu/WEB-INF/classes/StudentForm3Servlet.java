
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
 

public class StudentForm3Servlet extends HttpServlet{ 
 
	
	//submit form2  
	 @Override  
 public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
	  //TODO get param
	  String  stuName= request.getParameter("stu_name");//found  //dynamic code with value
	  String  stuAge= request.getParameter("stu_age");//found  //dynamic code with value
	  String  stuMobile= request.getParameter("stu_mobile");//found  //dynamic code with value
	  String  stuEmail= request.getParameter("stu_email");//found  //dynamic code with value
	  String  stuAddress= request.getParameter("stu_address");
	  String  stuPin= request.getParameter("stu_pin");
	  
	  //TODO then save into db  
	  //write databse insert code usig jdbc
	  
	 //TO show info 
	StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<h1>Student form submited</h1>");
		htmlCode.append("<h1>stuName="+ stuName+"</h1>");
		htmlCode.append("<h1>stu age ="+ stuAge+"</h1>");
		htmlCode.append("<h1>stu mob ="+ stuMobile+"</h1>");
		htmlCode.append("<h1>stu email ="+ stuEmail+"</h1>");
		htmlCode.append("<h1>stu address="+stuAddress+"</h1>");
		htmlCode.append("<h1>stu pin="+stuPin+"</h1>");

		 
		htmlCode.append("</html>");
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	
	
	 }//end service 	
	
	
}//End of class 
