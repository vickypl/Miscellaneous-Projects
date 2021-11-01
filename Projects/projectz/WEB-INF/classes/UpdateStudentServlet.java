
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

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
//for all user 

public class UpdateStudentServlet extends HttpServlet{ 
  
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
		 request.getRequestDispatcher("sessionvalidatorhelper").include(request, response);
		 HttpSession session  = request.getSession();
	 	 User user  = (User) session.getAttribute("user");     
		
	 	
	 	
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
		
	  	//TODO create seperate view for show form
		//using rd concept  forward 
	 	
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
		
		//TODO 

		if(stu!=null){  //found student
		 	
				htmlCode.append("<fieldset> <legend>Stduent Update Form</legend>");
				htmlCode.append("<form  action=\"updatestu\" method='post'>");
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
		
		
		htmlCode.append("<hr>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");

	
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end get
 
 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	 request.getRequestDispatcher("sessionvalidatorhelper").include(request, response);
	 HttpSession session  = request.getSession();
 	 User user  = (User) session.getAttribute("user"); 
	 
 	  //fetch id name  gender age 
	  //get param
	String  stuIdStr  = request.getParameter("stu_id");
	String  stuName  = request.getParameter("stu_name");
	String  stuGender  = request.getParameter("stu_gender");
	String  stuAgeStr  = request.getParameter("stu_age");
	
		//parse 
	long stuId = Long.parseLong(stuIdStr);
	int age  = Integer.parseInt(stuAgeStr);
	
//update  record  in db
StringBuilder errorCode = new StringBuilder();
StringBuilder updateMsg = new StringBuilder();

//jdbc   db logic
Connection con = null;
PreparedStatement pstmt  =null;

//declare required type 
String dbuser="system";
String dbpassword="root";
String url  = "jdbc:oracle:thin:@localhost:1521:XE";	

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con  = DriverManager.getConnection(url,dbuser,dbpassword);
	String sql="update my_stu set  name=? ,gender=?,age=? where id=?" ; 
	pstmt  = con.prepareStatement(sql);
	//set 
	pstmt.setString(1,stuName);
	pstmt.setString(2,stuGender);
	pstmt.setInt(3,age);
	pstmt.setLong(4,stuId);

	int result  = pstmt.executeUpdate();
   if(result ==1){
		updateMsg.append("<span style='color:green;'>Record  Updated Successfuly</span>");
	}else{
		updateMsg.append("<span style='color:red'>Record NOT  Updated</span>");
	}


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


htmlCode.append(updateMsg +"<hr>");	
if(errorCode.length()>0){
	htmlCode.append(errorCode);	
}

htmlCode.append("<hr>");
htmlCode.append("</body>");
htmlCode.append("</html>");



response.setContentType("text/html");//MIME TYPE
PrintWriter pw  = response.getWriter();
pw.print(htmlCode);

	 
	 
	 
	}
 
}//End of class 
