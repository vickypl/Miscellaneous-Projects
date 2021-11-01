import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class Service2 extends HttpServlet{ 
  
	@Override  
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	  	
	  	String userName  = request.getParameter("user_name");
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body bgcolor='lime'>");
		htmlCode.append("<hr>");
		/* htmlCode.append("<a href=\"s1\">service1</a>&nbsp;");
		htmlCode.append("<a href=\"s3\">service3</a>&nbsp;"); */
		htmlCode.append("<hr>");
		//URL RE-WRITING
		htmlCode.append("<hr>");
		htmlCode.append("<a href=\"s1?user_name="+userName+"&sis=success\">service1</a>&nbsp;");
		htmlCode.append("<a href=\"s2?user_name="+userName+"&sis=success\">service2</a>&nbsp;");
		htmlCode.append("<a href=\"s3?user_name="+userName+"&sis=success\">service3</a>&nbsp;");

		htmlCode.append("<hr>");
		htmlCode.append("<h1>reqparam: Hello User "+userName+"</h1>"); 
		htmlCode.append("<hr>");
		htmlCode.append("<h1>Service 2</h1>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");
	
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
