import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class UpdateUserServlet extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		//user data fetching form html
		String uid=request.getParameter("id");
		String name=request.getParameter("name");
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		String role=request.getParameter("role");

		//neccessary objects
		StringBuilder errorCode = new StringBuilder();
		StringBuilder updateInfo = new StringBuilder();
		List<User> userList = new ArrayList<User>();


		//presentation of data logic using html servlet
		StringBuilder htmlCode = new StringBuilder("");
		htmlCode.append("<html>");
		htmlCode.append("<head>");
		htmlCode.append("<title>UserAdd</title>");
		htmlCode.append("</head>");
		htmlCode.append("<body style='background-color: black; color: white;'>");
		htmlCode.append("<hr>");
		htmlCode.append("<h1>Crud App</h1>");
		htmlCode.append("<h3 style='color: white;'><a href='http://localhost:8088/Crud/useradd.html'>AddUser</a></h3>&nbsp;");
		htmlCode.append("<h3 style='color: white;'><a href='add'>ViewUsers</a></h3>&nbsp;");
		htmlCode.append("<h3 style='color: white;'><a href= \"index.html\" >goto home</a></h3>");
		htmlCode.append("<hr>");
		htmlCode.append("<form action='update' method='post'>");
		htmlCode.append("<table style='padding: 20px; border-color: red;' border='1'>");
		htmlCode.append("<tr>");
		htmlCode.append("<td>");
		htmlCode.append("UserId: <input type='text' name='new_id' value='"+uid+"' readonly>");
		htmlCode.append("</td>");
		htmlCode.append("<td>");
		htmlCode.append("Name: <input type='text' name='new_name' value='"+name+"'>");
		htmlCode.append("</td>");
		htmlCode.append("<td>");
		htmlCode.append("Username: <input type='text' name='new_username' value='"+username+"'>");
		htmlCode.append("</td>");
		htmlCode.append("<td>");
		htmlCode.append("PassWord: <input type='text' name='new_pass' value='"+password+"'>");
		htmlCode.append("</td>");
		htmlCode.append("<td>");
		htmlCode.append("Role: <input type='text' name='new_role' value='"+role+"'>");
		htmlCode.append("</td>");
		htmlCode.append("<td>");
		htmlCode.append("<input type='submit' name='submit' value='update'>");
		htmlCode.append("</td>");
		htmlCode.append("</tr>");
		htmlCode.append("</table>");
		htmlCode.append("</form>");
		
		//tofetch new updated data;
		String newid=request.getParameter("new_id");
		String newName=request.getParameter("new_name");
		String newUsername=request.getParameter("new_username");
		String newPassword=request.getParameter("new_pass");
		String newRole=request.getParameter("new_role");

		if (newid!=null && newName!=null && newUsername!=null && newPassword!=null && newRole!=null) {
			
			//db connection
			Connection connection = null;
			Statement statement = null;
			PreparedStatement preStatement = null;
			ResultSet resultSet = null;

			//converting id string to number
			int toUpdateId=Integer.parseInt(newid);

			try {

				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String dbUser="sis";
				String dbPass="root";

				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection=DriverManager.getConnection(url, dbUser, dbPass);
				//adding user data in to database

				String sql="update userdata set name=?, username=?, password=?, role=? where id=?";
				
				preStatement=connection.prepareStatement(sql);
				preStatement.setString(1, newName);
				preStatement.setString(2, newUsername);
				preStatement.setString(3, newPassword);
				preStatement.setString(4, newRole);
				preStatement.setInt(5, toUpdateId);

				int result=preStatement.executeUpdate();

				if (result>0) {
					updateInfo.append("<h4 style='color: green;'>Successfully Updated</h4>");
					updateInfo.append("<fieldset style='color: green; padding: 60px; margin-top: 100px; margin-left: 300px; margin-right: 300px;'>");
					updateInfo.append("<legend style='color: green;' align='center'>Updated data:</legend>");
					updateInfo.append("<h1>"+newid+"</h1>");
					updateInfo.append("<hr>");
					updateInfo.append("<h1>"+newName+"</h1>");
					updateInfo.append("<hr>");
					updateInfo.append("<h1>"+newUsername+"</h1>");
					updateInfo.append("<hr>");
					updateInfo.append("<h1>"+newPassword+"</h1>");
					updateInfo.append("<hr>");
					updateInfo.append("<h1>"+newRole+"</h1>");
					updateInfo.append("</fieldset>");
				} else {
					errorCode.append("<h4 style='color: red;'>Failed to update the data.</h4>");
				}


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


			} catch (ClassNotFoundException e) {
				errorCode.append(e);
			} catch (SQLException e) {
				errorCode.append(e);
			} catch (Exception e) {
				errorCode.append(e);
			} finally {
				if (connection!=null) {
					try {
						connection.close();
					} catch (SQLException e) {
						errorCode.append(e);
					}
				}
			}		

		}
//db code end

		if (updateInfo.length()>0) {
			htmlCode.append(updateInfo);
		} else {
			htmlCode.append(errorCode);
		}
		htmlCode.append("<hr style='color: red; height: 1px;'>");
		htmlCode.append("<table border='1' width='100%'>");
		htmlCode.append("<tr>");
		htmlCode.append("<th>UserID</th>");
		htmlCode.append("<th>Name</th>");
		htmlCode.append("<th>UserName</th>");
		htmlCode.append("<th>PassWord</th>");
		htmlCode.append("<th>Role</th>");
		htmlCode.append("</tr>");
		for (User usr: userList) {
			htmlCode.append("<tr>");
			htmlCode.append("<td>"+usr.getId()+"</td>");
			htmlCode.append("<td>"+usr.getName()+"</td>");
			htmlCode.append("<td>"+usr.getUsername()+"</td>");
			htmlCode.append("<td>"+usr.getPassword()+"</td>");
			htmlCode.append("<td>"+usr.getRole()+"</td>");
			htmlCode.append("<td><a href='update'>Update</a></td>");
			htmlCode.append("<td><a href='delete'>Delete</a></td>");
			htmlCode.append("</tr>");
		}
		htmlCode.append("</table>");
		htmlCode.append("</body>");
		htmlCode.append("</html>");


		//sending the html code to browser
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(htmlCode);




	}//servie end
}//classend