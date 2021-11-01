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

public class DeptartmentLinkServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
     	  
		  
	List<Department> deptList = new ArrayList<Department>(); 
		  
		 //if any error found append on errorCode 
	StringBuilder errorCode = new StringBuilder();
	
     //jdbc   db logic
	Connection con = null;
	Statement stmt  =null;
	ResultSet rs =null;
	//declare required type 
	String user="system";
	String password="root";
	String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
   try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con  = DriverManager.getConnection(url,user,password);
		stmt  = con.createStatement();
		//******************************************
		String sql="select * from Dept order by deptno" ; 
     	 rs  =  stmt.executeQuery(sql);
		while( rs.next() ){
	          long id  =rs.getLong("deptno");
			  String name  = rs.getString("dname");
			  //String location  = rs.getString("loc");
			   //create dept object
			   Department dept  = new Department();
			   //fill data
			   dept.setId(id);
			   dept.setName(name);
			  // dept.setLocation(location);
			   //add dept object  into list
			   deptList.add(dept);
		 
		}//end while 
		
	 }catch(ClassNotFoundException e){
	   errorCode.append("<h1 style='color:red'>Driver Not Loaded....." + e.getMessage()+"</h1>");
	 }catch(SQLException e){
	   errorCode.append("<h1 style='color:red'>DB ERROR : " +e.getMessage()+"</h1>");
	   e.printStackTrace();
	 }catch(Exception e){
	   errorCode.append("<h1 style='color:red'>Other ERROR " + e.getMessage()+"</h1>");
	 }finally{
	     //release resoucer
	      if(con!=null){
		          try{
				     con.close();  //#5 close connection 
					}catch(SQLException e){
						 errorCode.append("DB Con CLosing ERROR : "+ e.getMessage());
				  }//catch
		  }//if
	 }//finally

//jdbc done
	
 
 //presentation logic 
	StringBuilder htmlCode = new StringBuilder("");
	htmlCode.append("<html>");
	htmlCode.append("<head>");
	htmlCode.append("<title>Sis</title>");
	htmlCode.append("</head>");
	htmlCode.append("<body>");
	htmlCode.append("<a href=\"sis.html\" >goto home</a><hr>");	
	//create dynamic link to fetch employees by deptno
	//url genrated:-getallempbydeptno?dept_no=10
	for(Department d : deptList){
		htmlCode.append("<a href=\"getallempbydeptno?dept_no="+d.getId()+"\"> get all emp by dept no = " +d.getId() +d.getName()+"</a><br>");
	}
		

	htmlCode.append("</body>");
	htmlCode.append("</html>");

	//send dhtml code to browser
	response.setContentType("text/html");
	PrintWriter pw  = response.getWriter();
	pw.print(htmlCode);
	}//end service	  
  
}//End of class 
