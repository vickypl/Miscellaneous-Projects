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

public class LoginServlet extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response)
	  throws ServletException,IOException{
     	  
		  //get param
String  loginId  = request.getParameter("login_id");
String  loginPassword  = request.getParameter("login_password");
		  
boolean isLoginSuccess =false;
User user  = null;
StringBuilder errorCode = new StringBuilder();

  //jdbc for validation
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
	 	String sql="select * from my_user  where login_id=? and login_password=?" ; 
		pstmt  = con.prepareStatement(sql);
		//set 
		pstmt.setString(1,loginId);
		pstmt.setString(2,loginPassword);
	 
     	 rs  =  pstmt.executeQuery();
		if(rs.next() ){//check for only one record if true means found user
	          isLoginSuccess=true;//rs.getXxx("col");
			  //id name  u_id u_pass role 
			  long id =rs.getLong("id");
			  String name =rs.getString("name");
			  String roleType =rs.getString("role");
			  java.sql.Timestamp created = rs.getTimestamp("when_created");
			  //create user object when login success 
			  user = new User();
			  user.setId(id);
			  user.setName(name);
			  user.setLoginId(loginId);
			  user.setLoginPassword(loginPassword);
			  user.setRole(roleType);
			  user.setCreated(created);
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
	htmlCode.append("<a href=\"sis.html\" >goto home</a><hr>");	
	
	if(isLoginSuccess==true){
		htmlCode.append("<h1>Login Successfull</h1>");
		htmlCode.append("<h1>Welcome user "+user.getName()+"</h1>");
		htmlCode.append("<h1>"+user.getRole()+"</h1>");
		htmlCode.append("<h1>"+user.getLoginId()+"</h1>");
		htmlCode.append("<h1>"+user.getCreated()+"</h1>");
		
	}else{
		htmlCode.append("<h1 style='color:red;' >Invalid login</h1>");
		htmlCode.append("<a href=\"login_form.html\" >Re-Login</a><hr>");	
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
