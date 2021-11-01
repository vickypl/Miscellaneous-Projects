
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

public class DeleteStudentServlet extends HttpServlet{ 
  
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
		 request.getRequestDispatcher("sessionvalidatorhelper").include(request, response);
		 HttpSession session  = request.getSession();
	 	 User user  = (User) session.getAttribute("user");
	 	 
		// get stu id
		String stuIdStr = request.getParameter("stu_id");
		long stuId = Long.parseLong(stuIdStr);
		// delete record from db
		StringBuilder errorCode = new StringBuilder();
		StringBuilder deleteMsg = new StringBuilder();
		Connection con = null;
		PreparedStatement pstmt = null;
		 
		//declare required type 
		String dbuser="system";
		String dbpassword="root";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";	

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url,dbuser,dbpassword);
		 	String sql="delete from my_stu where id=?" ; 
			pstmt  = con.prepareStatement(sql);
			//set 
			pstmt.setLong(1,stuId);  //delete from my_stu where id=1004
		 
			int result  = pstmt.executeUpdate();
	        if(result ==1){
				deleteMsg.append("<span style=\"color:green;\">Record  Deleted Successfuly</span>");
			}else{
				deleteMsg.append("<span style=\"color:red;\">Record  NOt Deleted </span>");
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
		
		htmlCode.append("<h1>Delete Message</h1>");
		htmlCode.append("<hr>");
		htmlCode.append(deleteMsg);	
		
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
