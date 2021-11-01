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

public class ShowAllDeptServlet2 extends GenericServlet{ 
  
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
 
		PrintWriter out  = response.getWriter();
     	response.setContentType("text/html");

	  
//	StringBuilder htmlCode = new StringBuilder("");
    out.print("<html>");
	out.print("<head>");
	out.print("<title>Sis</title>");
	out.print("</head>");
	out.print("<body>");
	out.print("<a href= \"sis.html\" >goto home</a>");
	out.print("<hr>");
	//jdbc code for fetch record 
	out.print("<table border='1' width=\'100%\' >");
	out.print("<tr>");
	out.print("<th>id</th>");
	out.print("<th>name</th>");
	out.print("<th>location</th>");
	out.print("<th>Action</th>");
	out.print("</tr>");


	
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
			out.print("</tr>");
			out.print("<td>"+id+"</td>");
			out.print("<td>"+name+"</td>");
			out.print("<td>"+location+"</td>");
			out.print("<td>");
			out.print("<a href= \"#\" >update</a> ");
			out.print("<a href= \"#\" >delete</a>");
			out.print("</td>");
			out.print("</tr>");
		}
		
	 }catch(ClassNotFoundException e){
	   out.print("Driver Not Loaded....." + e.getMessage());
	 }catch(SQLException e){
	   out.print("DB ERROR : " +e.getMessage());
	   e.printStackTrace();
	 }catch(Exception e){
	   out.print("Other ERROR " + e.getMessage());
	 }finally{
	     //release resoucer
	      if(con!=null){
		          try{
				     con.close();  //#5 close connection 
					}catch(SQLException e){
						out.print("DB Con CLosing ERROR : "+ e.getMessage());
				  }//catch
		  }//if
	 }//finally

//jdbc done
	
	out.print("</body>");
	out.print("</html>");

     	//send dhtml code to browser
//     	response.setContentType("text/html");
//		PrintWriter pw  = response.getWriter();
//		pw.print(htmlCode);
	
	

	}//end service	  
  
}//End of class 
