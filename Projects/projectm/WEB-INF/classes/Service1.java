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

public class Service1 extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
	  PrintWriter pw  = response.getWriter();
	  //create data 
	  String s1=new String("Surendra kumar sao");
	  double [] arr1 ={Math.random(),Math.random(),Math.random()};
	  List<String> list  = new ArrayList<String>();
	  list.add("java");
	  list.add("sis");
	  list.add("career");
	  list.add("success");
	  Date d1 = new Date();
	  
	  
	  
		request.setAttribute("trainername",s1);
		request.setAttribute("mynumbers",arr1);
		request.setAttribute("mywords",list);
		request.setAttribute("requestdate",d1);
		
	  RequestDispatcher  rd = null;
	  rd  = request.getRequestDispatcher("url2");//for service2
	  rd.forward(request,response);
		
 }//end service	  
  
}//End of class 
