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

public class DeleteManyStudentsServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
      //get stu id
	  String []stuIdsList  = request.getParameterValues("stu_ids");
	  StringBuilder deleHold = new StringBuilder();

	  // deleHold.append("<h1 style='color: red;'> deleted: "+Integer.parseInt(stuIdsList[0])+"</h1>");
	  // deleHold.append("<h1 style='color: red;'> deleted: "+stuIdsList[1]+"</h1>");
	  // deleHold.append("<h1 style='color: red;'> deleted: "+stuIdsList[2]+"</h1>");
	  //deleHold.append("<h1 style='color: red;'> deleted: "+stuIdsList[3]+"</h1>");
	  //db delete
	  Connection connection=null;
	  PreparedStatement preStatement=null;

	  try {

	  	Class.forName("oracle.jdbc.driver.OracleDriver");
	  	String url="jdbc:oracle:thin:@localhost:1521:XE";
	  	String dbUser="system";
	  	String dbPass="root";

	  	connection=DriverManager.getConnection(url, dbUser, dbPass);

	  	for (int i=0; i<stuIdsList.length; i++) {
	  		int del=Integer.parseInt(stuIdsList[i]);
	  		String sql="delete from my_stu where id=?";
	  		preStatement=connection.prepareStatement(sql);
	  		preStatement.setInt(1, del);

	  		int r=preStatement.executeUpdate();

	  		if (r>0) {
	  			deleHold.append("<h1 style='color: red;'> deleted: "+del+"</h1>");
	  		} 
	  	
	  	}

	  } catch (ClassNotFoundException e) {
	  	System.out.println(e);
	  } catch (SQLException e) {
	  	System.out.println(e);
	  } catch (Exception e) {
	  	System.out.println(e);
	  } finally {
	  		//resource
		  	if (connection!=null) {
		  		try {
		  			connection.close();
		  		} catch (SQLException e) {
		  			System.out.println(e);
		  		}
		  	}
	  }
	  
	  //show message
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
	htmlCode.append("<hr><hr color='blue'>");	
	htmlCode.append(Arrays.toString(stuIdsList) +" DELETE TODO .....");	
	htmlCode.append("<h1>"+deleHold.length()+"<h1>");	
	if (deleHold.length()>0) {
		htmlCode.append(deleHold);
	}
	
	htmlCode.append("</body>");
	htmlCode.append("</html>");

	//send dhtml code to browser
	response.setContentType("text/html");
	PrintWriter pw  = response.getWriter();
	pw.print(htmlCode);
	}//end service	  
  
}//End of class 
