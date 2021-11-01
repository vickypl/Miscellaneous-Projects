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

public class ShowAllDeptServlet1 extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
     //jdbc
	Connection con = null;
	Statement stmt  =null;
	ResultSet rs =null;
	//declare required type 
	String user="system";
	String password="root";
	String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
 
	  
	StringBuilder htmlCode = new StringBuilder("");
    htmlCode.append("<html>");
	htmlCode.append("<head>");
	htmlCode.append("<title>Sis</title>");
	htmlCode.append("</head>");
	htmlCode.append("<body>");
	htmlCode.append("<a href= \"sis.html\" >goto home</a>");
	htmlCode.append("<hr>");
	//jdbc code for fetch record 
	htmlCode.append("<table border='1' width=\'100%\' >");
	htmlCode.append("<tr>");
	htmlCode.append("<th>id</th>");
	htmlCode.append("<th>name</th>");
	htmlCode.append("<th>location</th>");
	htmlCode.append("<th>Action</th>");
	htmlCode.append("</tr>");


	
	 try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con  = DriverManager.getConnection(url,user,password);
		stmt  = con.createStatement();
		//******************************************
		String sql="select * from Dept" ; 
     	 rs  =  stmt.executeQuery(sql);
		while( rs.next() ){
	          long id  =rs.getLong("deptno");
			  String name  = rs.getString("dname");
			  String location  = rs.getString("loc");
			  //todo print into browser
			htmlCode.append("<tr>");
			htmlCode.append("<td>"+id+"</td>");
			htmlCode.append("<td>"+name+"</td>");
			htmlCode.append("<td>"+location+"</td>");
			htmlCode.append("<td>");
			htmlCode.append("<a href= \"#\" >update</a> ");
			htmlCode.append("<a href= \"#\" >delete</a>");
			htmlCode.append("</td>");
			htmlCode.append("</tr>");
		}
		
	 }catch(ClassNotFoundException e){
	   htmlCode.append("Driver Not Loaded....." + e.getMessage());
	 }catch(SQLException e){
	   htmlCode.append("DB ERROR : " +e.getMessage());
	   e.printStackTrace();
	 }catch(Exception e){
	   htmlCode.append("Other ERROR " + e.getMessage());
	 }finally{
	     //release resoucer
	      if(con!=null){
		          try{
				     con.close();  //#5 close connection 
					}catch(SQLException e){
						htmlCode.append("DB Con CLosing ERROR : "+ e.getMessage());
				  }//catch
		  }//if
	 }//finally

//jdbc done
	
	htmlCode.append("</body>");
	htmlCode.append("</html>");

	//send dhtml code to browser
	response.setContentType("text/html");
	PrintWriter pw  = response.getWriter();
	pw.print(htmlCode);
	
	

	}//end service	  
  
}//End of class 
