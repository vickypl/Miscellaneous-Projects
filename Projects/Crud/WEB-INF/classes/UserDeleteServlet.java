import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class UserDeleteServlet extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		//user data fetching form html
		String id=null;
		String name=null;
		String username=null;
		String password=null;
		String role=null;


		//presentation reqs
		StringBuilder errorcode = new StringBuilder();
		StringBuilder deletedInfo = new StringBuilder();
		StringBuilder printer = new StringBuilder();
		List<User> userList = new ArrayList<User>();

		boolean flag=false;
		if (request.getParameter("id")!=null) {
			
			id=request.getParameter("id");
			name=request.getParameter("name");
			username=request.getParameter("user");
			password=request.getParameter("pass");
			role=request.getParameter("role");

		}

			//database logic
			Connection connection = null;
			PreparedStatement preStatement = null;
			Statement statement = null;
			ResultSet resultSet = null;
			try {
					
					int toDel=-1;
					toDel=Integer.parseInt(id);
					Class.forName("oracle.jdbc.driver.OracleDriver");

					String url="jdbc:oracle:thin:@localhost:1521:xe";
					String dbUser="sis";
					String dbPass="root";
					connection=DriverManager.getConnection(url, dbUser, dbPass);
					String sql="delete from userdata where id=?";
					preStatement = connection.prepareStatement(sql);
					preStatement.setInt(1, toDel);
					int result=preStatement.executeUpdate();
					if (result>0) {
						deletedInfo.append("<h1 style='color: green;'>Successfully Deleted...</h1>");
						deletedInfo.append("<fieldset style='border-color: red; border-radius: 5px; margin-left: 300px; margin-right: 300px; margin-top: 70px;'>");
						deletedInfo.append("<legend style='background-color: red;'>Deleted Data</legend>");
						deletedInfo.append("<h1>UserId: "+id+"</h1>");
						deletedInfo.append("<h1>Name: "+name+"</h1>");
						deletedInfo.append("<h1>Username: "+username+"</h1>");
						deletedInfo.append("<h1>Password: "+password+"</h1>");
						deletedInfo.append("<h1>Role: "+role+"</h1>");
						deletedInfo.append("</fieldset>");
					} else {
						deletedInfo.append("<h1 style='color: red;'>Failed to Delete...</h1>");
					}

					//print rest of the table logic by storing it in list;
					sql="select * from userdata";
					statement=connection.createStatement();
					resultSet = statement.executeQuery(sql);
					while(resultSet.next()) {

						User user = new User();
						user.setId(resultSet.getString(1));
						user.setName(resultSet.getString(2));
						user.setUsername(resultSet.getString(3));
						user.setPassword(resultSet.getString(4));
						user.setRole(resultSet.getString(5));
						userList.add(user);
					}
			} catch(ClassNotFoundException e) {
				errorcode.append("<h1 style='color: red;'>"+e+"</h1>");
			} catch (SQLException e) {
				errorcode.append("<h1 style='color: red;'>"+e+"</h1>");
			} catch (Exception e) {
				errorcode.append("<h1 style='color: red;'>"+e+"</h1>");
			} finally {
				if (connection!=null) {
					try {
						connection.close();
					} catch (SQLException e) {
						errorcode.append("<h1 style='color: red;'>"+e+"</h1>");
					}
				}
			}

			//presentaion logic
			StringBuilder htmlCode = new StringBuilder("");
		    htmlCode.append("<html>");
			htmlCode.append("<head>");
			htmlCode.append("<title>Sis</title>");
			htmlCode.append("</head>");
			htmlCode.append("<body style='background-color: black; color: white;'>");
			htmlCode.append("<hr>");
			htmlCode.append("<h1>Crud App</h1>");
			htmlCode.append("<h3 style='color: white;'><a href='http://localhost:8088/Crud/useradd.html'>AddUser</a></h3>&nbsp;");
			htmlCode.append("<h3 style='color: white;'><a href='add'>ViewUsers</a></h3>&nbsp;");
			htmlCode.append("<h3 style='color: white;'><a href= \"index.html\" >goto home</a></h3>");
			htmlCode.append("<hr>");
			htmlCode.append("<hr>");
			if (errorcode.length()>0) {
				htmlCode.append(errorcode);
			} else if (deletedInfo.length()>0) {
				htmlCode.append(deletedInfo);
			}
			htmlCode.append("<hr>");
			htmlCode.append("<table border='1' width='100%'>");
			htmlCode.append("<tr>");
			htmlCode.append("<th>UserID</th>");
			htmlCode.append("<th>Name</th>");
			htmlCode.append("<th>UserName</th>");
			htmlCode.append("<th>PassWord</th>");
			htmlCode.append("<th>Role</th>");
			htmlCode.append("<th>Action</th>");
			htmlCode.append("</tr>");
			for (User usr: userList) {
				htmlCode.append("<tr>");
				htmlCode.append("<td>"+usr.getId()+"</td>");
				htmlCode.append("<td>"+usr.getName()+"</td>");
				htmlCode.append("<td>"+usr.getUsername()+"</td>");
				htmlCode.append("<td>"+usr.getPassword()+"</td>");
				htmlCode.append("<td>"+usr.getRole()+"</td>");
				htmlCode.append("<td><a href='update?id="+usr.getId()+"&name="+usr.getName()+"&user="+usr.getUsername()+"&pass="+usr.getPassword()+"&role="+usr.getRole()+"'>Update</a></td>");
				htmlCode.append("<td><a href='delete?id="+usr.getId()+"&name="+usr.getName()+"&user="+usr.getUsername()+"&pass="+usr.getPassword()+"&role="+usr.getRole()+"'>Delete</a></td>");
				htmlCode.append("</tr>");
			}
			htmlCode.append("</table>");
			htmlCode.append("</body>");
			htmlCode.append("</html>");
			//send dhtml code to browser
			response.setContentType("text/html");
			PrintWriter pw  = response.getWriter();
			pw.print(htmlCode);

	}//servie end
}//classend