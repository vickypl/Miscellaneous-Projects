
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

  //Date march/2021

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
 
//for all user 

public class ShowAllStudentServlet extends HttpServlet{ 
  
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
	 request.getRequestDispatcher("sessionvalidatorhelper").include(request, response);
	 HttpSession session  = request.getSession();
       User user  = (User) session.getAttribute("user");  
       
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
  	
  	 
       
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<hr>");
		htmlCode.append("<hr>");

		if("super admin".equalsIgnoreCase(user.getRole())){
		  htmlCode.append("<a href=\"addstu\">Add student</a> &nbsp ");
		}
		
		htmlCode.append("<a href='showallstu'>show all Student</a> &nbsp;");
		htmlCode.append("<a href='showemp'>show all emp</a>&nbsp; ");
		htmlCode.append("<a href='showdept'>show all dept</a>&nbsp; ");
		htmlCode.append("<a href='logout'>User Logout</a>&nbsp; ");
		htmlCode.append("<hr>");
 
		htmlCode.append("<h3>Welcome user"+user.getName()+"");
		htmlCode.append("("+user.getId()+")::("+user.getRole()+") </h3>");
		htmlCode.append("<hr>");
		
		htmlCode.append("<hr>");
		//TODO
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

			if("super admin".equalsIgnoreCase(user.getRole())){
				htmlCode.append("<a href=\"updatestu?stu_id="+stu.getId()+"\">Update</a> &nbsp &nbsp");
				htmlCode.append("<a href=\"delstu?stu_id="+stu.getId()+"\">delete</a>");
			}else if("admin".equalsIgnoreCase(user.getRole())){
			 
			}else{
				
			}
			
			htmlCode.append("</td>");
			htmlCode.append("</tr>");
		}

		htmlCode.append("</table>");
			  
		
		if(errorCode.length()>0){
			htmlCode.append(errorCode);	
		}
		
		htmlCode.append("<hr>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");

	
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service	  
}//End of class 
