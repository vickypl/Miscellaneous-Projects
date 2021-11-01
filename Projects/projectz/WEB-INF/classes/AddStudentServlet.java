
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
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
//for all user 

public class AddStudentServlet extends HttpServlet{ 
  
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
	 
		 request.getRequestDispatcher("sessionvalidatorhelper").include(request, response);
		 HttpSession session  = request.getSession();
	 
	 	User user  = (User) session.getAttribute("user");     
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
		htmlCode.append("<hr>");
		htmlCode.append("<h1>Welcome user"+user.getName()+" </h1>");
		htmlCode.append("<h1>"+user.getId()+"("+user.getRole()+") </h1>");
		htmlCode.append("<h1>Login imte "+session.getAttribute("userLogintime")+ "</h1>");
		htmlCode.append("<h1>Show Dept Service</h1>");
		htmlCode.append("<hr>");
		htmlCode.append("<fieldset> <legend>Add Stduent Form</legend>");
		
		htmlCode.append("<form  action=\"addstu\" method=\"post\">");
		htmlCode.append("<table border='1' width='100%' >");
		htmlCode.append("<tr>");
		
		htmlCode.append("<td>id</td>");
		htmlCode.append("<td><input type=\"text\" name=\"stu_id\" ></td>");
		htmlCode.append("<tr>");
		
		htmlCode.append("<td>name</td>");
		htmlCode.append("<td><input type=\"text\" name=\"stu_name\" ></td>");
		htmlCode.append("<tr>");
		htmlCode.append("<td>age</td>");
		htmlCode.append("<td><input type=\"text\" name=\"stu_age\" ></td>");
		htmlCode.append("<tr>");
		htmlCode.append("<td>gender</td>");
		htmlCode.append("<td>");
		htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"male\" > Male");
		htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"female\" > FeMale");
		htmlCode.append("<input type=\"radio\" name=\"stu_gender\"   value=\"other\" > Other");
		htmlCode.append("</td>");
		htmlCode.append("<tr>");
		
		htmlCode.append("<tr>");
		htmlCode.append("<td></td>");
		htmlCode.append("<td><input type=\"submit\" value=\"add Student\"></td>");
		htmlCode.append("<tr>");
		htmlCode.append("</table>");
		
		htmlCode.append("</form >");
		
		htmlCode.append("</fieldset>"); 
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

	 //fetch id name  gender age 
	  //get param
	String  stuIdStr  = request.getParameter("stu_id");
	String  stuName  = request.getParameter("stu_name");
	String  stuGender  = request.getParameter("stu_gender");
	String  stuAgeStr  = request.getParameter("stu_age");
	
		//parse 
	long stuId = Long.parseLong(stuIdStr);
	int age  = Integer.parseInt(stuAgeStr);
	
	 
	
//insert   record  in db
StringBuilder errorCode = new StringBuilder();
StringBuilder addMsg = new StringBuilder();

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
	String sql="insert into my_stu (id,name,gender,age)values(?,?,?,?)" ; 
	pstmt  = con.prepareStatement(sql);
	//set 
	pstmt.setLong(1,stuId);
	pstmt.setString(2,stuName);
	pstmt.setString(3,stuGender);
	pstmt.setInt(4,age);

	int result  = pstmt.executeUpdate();
   if(result ==1){
		addMsg.append("<span style='color:green;'>Record  Added Successfuly</span>");
	}else{
		addMsg.append("<span style='color:red;'>Record  Not Added</span>");
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

	
	
	HttpSession session  = request.getSession();
 	User user  = (User) session.getAttribute("user");     
	StringBuilder htmlCode = new StringBuilder("");
	htmlCode.append("<html>");
	htmlCode.append("<head>");
	htmlCode.append("<title>Sis</title>");
	htmlCode.append("</head>");
	htmlCode.append("<body>");
	htmlCode.append("<hr>");
	htmlCode.append("<a href=\"addstu\">Add student</a> &nbsp ");
	htmlCode.append("<a href='showallstu'>show all Student</a> &nbsp;");
	htmlCode.append("<a href='showdept'>show all dept</a>&nbsp; ");
	htmlCode.append("<a href='logout'>User Logout</a>&nbsp; ");
	htmlCode.append("<hr>");
	htmlCode.append("<h1>Main page Service</h1>");
	htmlCode.append("<h1>Welcome user"+user.getName()+" </h1>");
	htmlCode.append("<h1>"+user.getId()+"("+user.getRole()+") </h1>");
	htmlCode.append("<h1>Login imte "+session.getAttribute("userLogintime")+ "</h1>");
	htmlCode.append("<hr>");
	
	htmlCode.append(addMsg +"<hr>");	
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
