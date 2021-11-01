import javax.servlet.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class DbConnector extends GenericServlet{ 
  
 @Override  
 public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException {
	PrintWriter out  = response.getWriter();
	java.util.Date date = new java.util.Date();

	ServletContext context = getServletContext();
	
	ServletConfig conf = getServletConfig();

	String user = conf.getInitParameter("user");
	String pass = conf.getInitParameter("pass");
	String className = context.getInitParameter("class");
	String admin = context.getInitParameter("admin");

	Connection conObject = connectDb("system", "root");
	Statement stmtObject = getStmt(conObject);

	String sql="select * from emp;";

	response.setContentType("text/html");
	out.print("<html>");
	out.print("<head>");
	out.print("<title>Sis</title>");
	out.print("</head>");
	out.print("<body style='background-color: black; color: white;'>");
	out.print("<a href='index.html'>Home</a>");
	out.print("<hr>");
	out.print("<h1>TODO "+date+"</h1>");
	out.print("<hr>");
	out.print("Data of Employee table from database(System):::");
	out.print("<hr>");
	out.print("<h2> DbUser: "+user+"<h2>");
	out.print("<hr>");
	out.print("<h2> DbPass: "+pass+"<h2>");
	out.print("<hr>");
	out.print("<h2> Servlet ClassName: "+className+"<h2>");
	out.print("<hr>");
	out.print("<h2> Admin: "+admin+"<h2>");
	out.print("<hr>");
	try {
		ResultSet resultSet = stmtObject.executeQuery(sql);
		
		while(resultSet.next()) {
			out.print("<h5>"+resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t"+resultSet.getString(6)+"\t"+resultSet.getString(7)+"\t"+resultSet.getString(8)+"</h5>");
			//out.print("")
		}

		conObject.close();
	} catch (SQLException e) {
		System.out.println(e);
	}

	out.print("</body>");
	out.print("</html>");
 }//end service	  
  
  public static Connection connectDb(/*String url, */String username, String password) {
  		Connection connection = null;
  		try {

  		  	Class.forName("oracle.jdbc.driver.OracleDriver");
  		  	String url="jdbc:oracle:thin:@localhost:1521:XE";
  		  	//String username=username;
  		  	//String password=password;
  		  	connection=DriverManager.getConnection(url, username, password);

  		} catch(ClassNotFoundException e){
	   		System.out.println("Driver Not Loaded....." + e.getMessage());
	 	}catch(SQLException e){
	   		System.out.println("DB ERROR : " +e.getMessage());
	   		e.printStackTrace();
	 	}catch(Exception e){
	   		System.out.println("Other ERROR " + e.getMessage());
	 	} /*finally {
  		  	if (connection!=null) {
  		  		try {
  		  			connection.close();
  		  		} catch (SQLException ed) {
  		  			System.out.println("Closing exp:: "+ed);
  		  		}
  		  	}
  		}*/
  		return connection;
	}//end of connection method

	public static Statement getStmt(Connection connection) {
		Statement statement=null;
		try {
		 	statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return statement;
	}
}//End of class 
