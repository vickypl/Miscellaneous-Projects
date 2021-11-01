
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
 

public class CalcController extends GenericServlet{ 
  
		 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
		
		Integer number1 =null; 
		Integer number2 =null; 
		
		StringBuilder  errorCode  = new StringBuilder("");
		 try{
			 number1  = Integer.parseInt(request.getParameter("n1"));
			 number2  = Integer.parseInt(request.getParameter("n2"));
		 }catch(Exception e){
			 errorCode.append("<b style='color:red;'>ERROR : invalid input number <b>");
		 } 
  
		//fail 
		if(errorCode.length()>0){
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(errorCode+"<hr>");
		//add same form here
		request.getRequestDispatcher("calc.html").include(request,response);
		return;
		}
		
		
		
		Integer sum =number1+number2;
		Integer sub=number1 - number2;
		Float div=number1 /new Float (number2);
		Integer mul=number1*number2;
		Integer mode=number1%number2; 
		
		
		//send process data
		request.setAttribute("number1",number1);
		request.setAttribute("number2",number2);
		request.setAttribute("sum",sum);
		request.setAttribute("sub",sub);
		request.setAttribute("div",div);
		request.setAttribute("mul",mul);
		request.setAttribute("mode",mode);
		request.getRequestDispatcher("calresult").forward(request,response);
		
		
	}//end service	  
}//End of class 
