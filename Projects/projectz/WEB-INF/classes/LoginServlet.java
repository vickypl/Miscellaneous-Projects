
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

public class LoginServlet extends HttpServlet{ 
  //create login form 
 @Override  
 public void doGet(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
	 
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>Sis</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body>");
		htmlCode.append("<hr>");
		htmlCode.append("<form method='post' action='login'>");
		htmlCode.append("Login id<input type='text' name='login_id' required autofocus><br>");
		htmlCode.append("Login password<input type='password' name='login_password' required><br>");
		htmlCode.append("<input type='submit' value='Login'><br>");
		htmlCode.append("</form>");
	 
		htmlCode.append("</body>");
		htmlCode.append("</html>");
		
		response.setContentType("text/html");//MIME TYPE
		PrintWriter pw  = response.getWriter();
		pw.print(htmlCode);
	}//end service
 
 
 //fetch user logindata and validate
 @Override  
 public void doPost(HttpServletRequest request,HttpServletResponse response)
	  throws ServletException,IOException{
	  String loginId = request.getParameter("login_id");
	  String loginPassword = request.getParameter("login_password");
	  
	  
	  User loginUser  = null;
	  //validate in dabase
	  Connection con = null;
		 Statement stmt  =null;
		 ResultSet rs =null;
			 //declare required type 
		String user="system";
		String password="root";//if you password id diff change it
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
	 
		StringBuilder errorCode = new StringBuilder("");
		 try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url,user,password);
			stmt  = con.createStatement();
			 
			String sql="select  * from  my_user where login_id='"+loginId+"' and login_password='"+loginPassword+"'" ; 
	     	 rs  =  stmt.executeQuery(sql);
			if( rs.next() ){
		          long id  =rs.getLong("id");
				  String name  = rs.getString("name");
				  String role  = rs.getString("role");
				  loginUser= new User();
				  loginUser.setId(id);
				  loginUser.setName(name);
				  loginUser.setLoginId(loginId);
				  loginUser.setLoginPassword(loginPassword);
				  loginUser.setRole(role);
			}
			
		 }catch(ClassNotFoundException e){
		   errorCode.append("Driver Not Loaded....." + e.getMessage());
		 }catch(SQLException e){
		   errorCode.append("DB ERROR : " +e.getMessage());
		   e.printStackTrace();
		 }catch(Exception e){
		   errorCode.append("Other ERROR " + e.getMessage());
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
	  
	  
	//if user found means login successfull
		 //if user not found invalid user/password 

   if(loginUser!=null){
	   
	   
	   
		 //if user found means login successfull
	    //create session object
		 HttpSession session = request.getSession();
		 
		// int intervalSecond=10*60;//10min 
		//set session time
		// session.setMaxInactiveInterval(intervalSecond);
		 
		//add required attribute for next service
		 session.setAttribute("user", loginUser);
		 session.setAttribute("userLogintime", new java.util.Date());
		 //then send to main service page
		 response.sendRedirect("mainservice");
		 
		 
	 }else{
		 //if user not found invalid user/password 
			response.setContentType("text/html");//MIME TYPE
			PrintWriter pw  = response.getWriter();
			if(errorCode.length()>0){
				pw.print(errorCode);
			}else{
				pw.print("Invalid  login id or passord  ");
			}
			
			response.setHeader("refresh", "2;url=login");
	 }
		 
	  
 
 }
 
 
}//End of class 
