import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class UserAddServlet extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		//user data fetching form html
		String id=request.getParameter("user_id");
		String name=request.getParameter("name");
		String username=request.getParameter("user_name");
		String password=request.getParameter("user_password");
		String role=request.getParameter("user_role");


		//neccessary objects
		StringBuilder errorCode = new StringBuilder();
		StringBuilder addInfo = new StringBuilder();
		List<User> userList = new ArrayList<User>();

			//db connection
			Connection connection = null;
			Statement statement = null;
			PreparedStatement preStatement = null;
			ResultSet resultSet = null;
			String sql=null;

			try {

				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String dbUser="sis";
				String dbPass="root";

				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection=DriverManager.getConnection(url, dbUser, dbPass);
				//adding user data in to database
				if (id!=null && name!=null && username!=null && password!=null && role!=null) {			

						sql="insert into userdata(id, name, username, password, role) values(?,?,?,?,?)";
						
						preStatement=connection.prepareStatement(sql);
						preStatement.setString(1, id);
						preStatement.setString(2, name);
						preStatement.setString(3, username);
						preStatement.setString(4, password);
						preStatement.setString(5, role);

						int result=preStatement.executeUpdate();

						if (result>0) {
							addInfo.append("<h4 style='color: green;'>Successfully added</h4>");
							addInfo.append("<fieldset style='paddin: 60px; margin-top: 100px; margin-left: 300px; margin-right: 300px;'>");
							addInfo.append("<legend align='center'>UserDataAdded:</legend>");
							addInfo.append("<h1>"+id+"</h1>");
							addInfo.append("<hr>");
							addInfo.append("<h1>"+name+"</h1>");
							addInfo.append("<hr>");
							addInfo.append("<h1>"+username+"</h1>");
							addInfo.append("<hr>");
							addInfo.append("<h1>"+password+"</h1>");
							addInfo.append("<hr>");
							addInfo.append("<h1>"+role+"</h1>");
							addInfo.append("</fieldset>");
						} else {
							errorCode.append("<h4 style='color: red;'>Failed to add the data.</h4>");
						}

				} else {
					errorCode.append("<h1 style='red'>Null values not allowed..</h1>");
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
		if (addInfo.length()>0) {
			htmlCode.append(addInfo);
		} else if(errorCode.length()>0) {
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


		//sending the html code to browser
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(htmlCode);

	}//servie end
}//classend