
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

  //Date march/2021

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.*;
 

public class ShowAllCookiesServlet extends HttpServlet{ 
  
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
	 
	    
		
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<hr>");
		htmlCode.append("<h1>User cookies details</h1>");
		
		//get all cookies
		Cookie[] cookieList = request.getCookies();
		if(cookieList!=null){
			for(int p=1;p<=cookieList.length;p++ ){
				Cookie temp = cookieList[p-1];
				String name = temp.getName();
				String value = temp.getValue();
				if(name.startsWith("sis")) {
				htmlCode.append("<h3>"+"$$$$$$ sno#"+p +" "+name+" = " + value+"</h3>");
				} else {
					htmlCode.append("<h3>+++++++</h3>");
					htmlCode.append("<h3>"+"sno#"+p +" "+name+" = " + value+"</h3>");
				}
			}
		}else{
			htmlCode.append("<h1>Cookies No Found</h1>");
			
		}
		
		
		
		htmlCode.append("<hr>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");

	
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
