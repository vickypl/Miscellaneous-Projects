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

public class ShowAllEmployeeController extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
 
       //fetch required parameter 
		String deptNoStr  =	request.getParameter("dept_no");
	 	long deptNo =  Long.parseLong(deptNoStr);
	 	List<Employee> empList = new ArrayList<Employee>(); 
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
		String sql="select * from emp where deptno="+deptNo ; 
     	 rs  =  stmt.executeQuery(sql);
		while( rs.next() ){
	
			long id  =rs.getLong("empno");
	         // long deptNo  =rs.getLong("deptno"); already send by client
			String name  = rs.getString("ename");
			String job  = rs.getString("job");
			float salary  = rs.getFloat("sal");
			float com  = rs.getFloat("comm");
			java.sql.Date hireDate  = rs.getDate("hiredate");
			
			//create emp object
			  Employee e   = new Employee();
			   //fill data
			   e.setId(id);
			   e.setName(name);
			   e.setJob(job);
			   e.setSalary(salary);
			   e.setCommition(com);
			   e.setHireDate(hireDate);
			   e.setDeptNo(deptNo);
				//add into list
			   empList.add(e);
		 
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

 
     //forward to helper servlet 
	//ShowAllEmployeeControllerHelper   viewallemp

	request.setAttribute("allemps",empList);
	request.setAttribute("errorCode",errorCode);
	RequestDispatcher rd  =request.getRequestDispatcher("viewallemp");
	rd.forward(request,response);
	 
  
	}//end service	  
}//End of class 
