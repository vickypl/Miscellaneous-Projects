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

public class ShowAllStudentCheckBoxOptionServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
 
    List<Student> studentList  = new ArrayList<Student>(); 
  
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
	 	String sql="select * from my_stu" ; 
		pstmt  = con.prepareStatement(sql);
		 
     	 rs  =  pstmt.executeQuery();
		while(rs.next() ){
	       
			  long id =rs.getLong("id");
			  String name =rs.getString("name");
			  String gender =rs.getString("gender");
			  int age =rs.getInt("age");
			  
			  //create student object if found
			  Student  stu  = new Student();
			  //fill 
			  stu.setId(id);
			  stu.setName(name);
			  stu.setGender(gender);
			  stu.setAge(age);
			 studentList.add(stu);
			  
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
  
      htmlCode.append("<hr><hr color='blue'>");
	htmlCode.append("<a href=\"sis.html\" >goto home</a>&nbsp ");	
	htmlCode.append("<a href=\"addstuform\">get add  student form</a> &nbsp ");	
	htmlCode.append("<a href=\"showallstu\" >show all studdent</a>");	
	htmlCode.append("<a href='showallcheckbox'>show all student with Check box option</a> &nbsp;");	
	htmlCode.append("<hr><hr color='blue'>");
	
	htmlCode.append("<form action=\"deletemanystudentrecord\">");

	
	htmlCode.append("<table border='1' width='100%' >");
	htmlCode.append("<tr>");
	htmlCode.append("<th>id</th>");
	htmlCode.append("<th>name</th>");
	htmlCode.append("<th>gender</th>");
	htmlCode.append("<th>age</th>");
	htmlCode.append("<th>action</th>");
	htmlCode.append("</tr>");
	for(Student stu: studentList){
		htmlCode.append("<tr>");
		htmlCode.append("<td>"+stu.getId()+"</td>");
		htmlCode.append("<td>"+stu.getName()+"</td>");
		htmlCode.append("<td>"+stu.getGender()+"</td>");
		htmlCode.append("<td>"+stu.getAge()+"</td>");
		htmlCode.append("<td>");
	 
 	    htmlCode.append("<input type=\"checkbox\" name=\"stu_ids\"  value=\""+stu.getId()+"\">");
		htmlCode.append("</td>");
		htmlCode.append("</tr>");
	}

		htmlCode.append("<tr>");
		htmlCode.append("<td colspan='5'>");
		htmlCode.append("<input type=\"submit\" value=\"Delete Seleted Student\">");
		htmlCode.append("</td>");
		htmlCode.append("</tr>");
	
	htmlCode.append("</table>");
	htmlCode.append("</form>");
		  
	
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
