import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Connect {

		Connection connect = null;
		
		public Connection toConnect() {

			try {
				 //load driver;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("driver loaded");

				String url="jdbc:oracle:thin:@localhost";
				String username="system";
				String password="root";

				//conneting;
				connect=DriverManager.getConnection(url, username, password);
				System.out.println("connected");

				return connect;

			} catch(ClassNotFoundException e) {
				System.out.println(e);
			} catch(SQLException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println(e);
			}

			return connect;
		}

		public void closeConnection(Connection connect) {
				//closinConnection
				try {
					connect.close();
					System.out.println("Connection closed.");
				} catch (SQLException e) {
					System.out.println("Closing Exception");
				}
		}

		public Statement getStatement(Connection connect) {
			Statement statement = null;
			try {
				statement=connect.createStatement();
			} catch (Exception e) {
				System.out.println("statement Exception.."+e);
			}
			System.out.println("statement created.");
			return statement;
		}

		public ResultSet getSet(Statement stmt, String sql) {
			ResultSet set = null;
			try {
				set=stmt.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println(e);
			}
			return set;
		}
}