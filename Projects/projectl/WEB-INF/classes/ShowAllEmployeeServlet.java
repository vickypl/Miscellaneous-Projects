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

public class ShowAllEmployeeServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
 
   //fetch required parameter 
		String deptNoStr  =	request.getParameter("dept_no");
		String ouputFormatType  =	request.getParameter("output_type");
	//parse
	long deptNo =  Long.parseLong(deptNoStr);
	
	
	//emp list by dept no 
	List<Employee> empList = new ArrayList<Employee>(); 
		  
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

//jdbc done
    //control 
	
    if("text".equalsIgnoreCase(ouputFormatType)){
	  	StringBuilder textCode = new StringBuilder("");
	
	  for(Employee emp: empList){
			textCode.append(emp.getId()+",");
			textCode.append(emp.getName()+",");
			textCode.append(emp.getJob()+",");
			textCode.append(emp.getHireDate()+",");
			textCode.append(emp.getSalary()+",");
			textCode.append(emp.getCommition()+",");
			textCode.append(emp.getDeptNo()+"\n");
		}
	response.setContentType("text/plain");//MIME TYPE
	PrintWriter pw  = response.getWriter();
	pw.print(textCode);
	
		 
	}else  if("html".equalsIgnoreCase(ouputFormatType)){
		                   
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		  
		htmlCode.append("<table border='1' width='100%' >");
		htmlCode.append("<tr>");
		htmlCode.append("<th>id</th>");
		htmlCode.append("<th>name</th>");
		htmlCode.append("<th>job</th>");
		htmlCode.append("<th>hiredate</th>");
		htmlCode.append("<th>salary</th>");
		htmlCode.append("<th>com</th>");
		htmlCode.append("<th>deptno</th>");
		htmlCode.append("</tr>");
	
	for(Employee emp: empList){
		htmlCode.append("<tr>");
			htmlCode.append("<td>"+emp.getId()+"</td>");
			htmlCode.append("<td>"+emp.getName()+"</td>");
			htmlCode.append("<td>"+emp.getJob()+"</td>");
			htmlCode.append("<td>"+emp.getHireDate()+"</td>");
			htmlCode.append("<td>"+emp.getSalary()+"</td>");
			htmlCode.append("<td>"+emp.getCommition()+"</td>");
			htmlCode.append("<td>"+emp.getDeptNo()+"</td>");
		htmlCode.append("</tr>");
	}

	htmlCode.append("</table>");
	response.setContentType("text/html");//MIME TYPE
	PrintWriter pw  = response.getWriter();
	pw.print(htmlCode);

						   
	}else  if("excel".equalsIgnoreCase(ouputFormatType)){
		 
			StringBuilder excelCode = new StringBuilder("");

			for(Employee emp: empList){
				excelCode.append(emp.getId()+"\t");
				excelCode.append(emp.getName()+"\t");
				excelCode.append(emp.getJob()+"\t");
				excelCode.append(emp.getHireDate()+"\t");
				excelCode.append(emp.getSalary()+"\t");
				excelCode.append(emp.getCommition()+"\t");
				excelCode.append(emp.getDeptNo()+"\n");
			}
	response.setContentType("application/vnd.ms-excel");//MIME TYPE
	PrintWriter pw  = response.getWriter();
	pw.print(excelCode);
		 
		 
	}else  if("pdf".equalsIgnoreCase(ouputFormatType)){
		PrintWriter pw  = response.getWriter();
	    pw.print("comming soon  :  not support pdf format currently");
    }
  
  
	}//end service	  
}//End of class 
