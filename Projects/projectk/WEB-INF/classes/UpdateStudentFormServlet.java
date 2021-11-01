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

public class UpdateStudentFormServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
     	  
     //get param
    String  stuIdStr  = request.getParameter("stu_id");
	long stuId = Long.parseLong(stuIdStr);
    //get record 
    //if found create edit form  else show no record 

     Student stu= null;  //if stu=null mean no record if not null record found
     StringBuilder errorCode = new StringBuilder();

     //jdbc   db logic
	Connection con = null;
	PreparedStatement pstmt  =null;
	ResultSet rs =null;
	//declare required type 
	String dbuser="system";
	String dbpassword="root";
	String url  = "jdbc:oracle:thin:@localhost:1521:XE";	

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con  = DriverManager.getConnection(url,dbuser,dbpassword);
	 	String sql="select * from my_stu where id=?" ; 
		pstmt  = con.prepareStatement(sql);
		//set 
		pstmt.setLong(1,stuId);
	 
     	 rs  =  pstmt.executeQuery();
		if(rs.next() ){//get record by given student id
	       
			  long id =stuId; //rs.getLong("id");
			  String name =rs.getString("name");
			  String gender =rs.getString("gender");
			  int age =rs.getInt("age");
			  stu  = new Student();
			  stu.setId(id);
			  stu.setName(name);
			  stu.setGender(gender);
			  stu.setAge(age);
		}//end if  
		
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
	htmlCode.append("<hr><hr color='blue'>");
	htmlCode.append("<a href=\"sis.html\" >goto home</a>&nbsp ");	
	htmlCode.append("<a href=\"addstuform\">get add  student form</a> &nbsp ");	
	htmlCode.append("<a href=\"showallstu\" >show all studdent</a>");	
	htmlCode.append("<a href='showallcheckbox'>show all student with Check box option</a> &nbsp;");	
	htmlCode.append("<hr><hr color='blue'>");
	
	if(stu!=null){  //found student
	 	
			htmlCode.append("<fieldset> <legend>Stduent Update Form</legend>");
			
			htmlCode.append("<form  action=\"updatesturecord\" >");
		
		    htmlCode.append("<table border='1' width='100%' >");
			htmlCode.append("<tr>");
			
			htmlCode.append("<td>ID</td>");
			htmlCode.append("<td><input type=\"text\" name=\"stu_id\"   value=\""+stu.getId()+"\" readonly='readonly'></td>");
			htmlCode.append("<tr>");
			
			htmlCode.append("<td>name</td>");
			htmlCode.append("<td><input type=\"text\" name=\"stu_name\"   value=\""+stu.getName()+"\" required></td>");
			htmlCode.append("<tr>");
			
			htmlCode.append("<td>age</td>");
			htmlCode.append("<td><input type=\"text\" name=\"stu_age\"   value=\""+stu.getAge()+"\" required></td>");
			htmlCode.append("<tr>");
			
			
			htmlCode.append("<td>gender</td>");
			htmlCode.append("<td>");
			
			if("male".equalsIgnoreCase(stu.getGender()) ){
				htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"male\" checked ='checked' > Male");
			}else{
				htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"male\" > Male");
			}
		 	if("female".equalsIgnoreCase(stu.getGender()) ){
				htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"female\" checked ='checked' > feMale");
			}else{
				htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"female\" > feMale");
			}
		 	
			if("other".equalsIgnoreCase(stu.getGender()) ){
				htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"other\" checked ='checked' > Other");
			}else{
				htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"other\" > Other");
			}
		  	 
			htmlCode.append("</td>");
			htmlCode.append("<tr>");
			  
			htmlCode.append("<tr>");
			htmlCode.append("<td></td>");
			htmlCode.append("<td><input type=\"submit\" value=\"Update Student\"></td>");
			htmlCode.append("<tr>");
			htmlCode.append("</table>");
			htmlCode.append("</form >");

		  
	}else{ //not found
		htmlCode.append("<h1 style='color:red;' >NO Record found</h1>");
		htmlCode.append("<a href=\"student_search_form.html\" > Search student again</a><hr>");	
	}
	
	if(errorCode.length()>0){
		htmlCode.append(errorCode);	
	}
	
	htmlCode.append("</body>");
	htmlCode.append("</html>");

	//send dhtml code to browser
	response.setContentType("text/html");
	PrintWriter pw  = response.getWriter();
	pw.print(htmlCode);
	}//end service	  
  
}//End of class 
