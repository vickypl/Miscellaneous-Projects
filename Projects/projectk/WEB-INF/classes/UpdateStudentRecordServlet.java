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

public class UpdateStudentRecordServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
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

	
	htmlCode.append(updateMsg +"<hr>");	
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
