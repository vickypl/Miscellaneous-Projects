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

//solution for way3 or way4  or way6 
public class ShowAllEmpByDeptWiseServlet1 extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
	//step1	  
		//get deptno from request param
	String deptNoStr=request.getParameter("dept_no");
    long deptNo = Long.parseLong(deptNoStr);	
	


	//step2 and print	  
	//jdbc
	 Connection con = null;
	 Statement stmt  =null;
	 ResultSet rs =null;
		 //declare required type 
	String user="system";
	String password="root";//if you password id diff change it
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
	htmlCode.append("<th>job</th>");
	htmlCode.append("<th>hiredate</th>");
	htmlCode.append("<th>salary</th>");
	htmlCode.append("<th>deptno</th>");
	htmlCode.append("</tr>");
	
	 try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con  = DriverManager.getConnection(url,user,password);
		stmt  = con.createStatement();
		//******************************************
		//add where clause
		String sql="select * from Emp where deptno="+deptNo; 
     	 rs  =  stmt.executeQuery(sql);
		while( rs.next()){
	          long id  =rs.getLong("empno");
			  String name  = rs.getString("ename");
			  String job  = rs.getString("job");
			  float salary  = rs.getFloat("sal");
			  java.sql.Date hireDate  = rs.getDate("hiredate");
	          long deptno =rs.getLong("deptNo");
			  //todo print into browser
			  
			String hireDateStr = new java.text.SimpleDateFormat("EEEE dd-MMM-yyyy").format(hireDate); 
			htmlCode.append("</tr>");
			htmlCode.append("<td>"+id+"</td>");
			htmlCode.append("<td>"+name+"</td>");
			htmlCode.append("<td>"+job+"</td>");
			htmlCode.append("<td>"+salary+"</td>");
			//htmlCode.append("<td>"+hireDate+"</td>");
			htmlCode.append("<td>"+hireDateStr+"</td>");
			htmlCode.append("<td>"+deptno+"</td>");

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
