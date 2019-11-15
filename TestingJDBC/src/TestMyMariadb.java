import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestMyMariadb {

	public TestMyMariadb() {
		// TODO Auto-generated constructor stub

		try {
			//mysql -u myuser -pmypass mydb
			String dbUser = "myuser";
			String usrPass = "mypass";
			Class.forName("org.mariadb.jdbc.Driver"); // STEP 2: Register JDBC driver

			Connection con = null;

			// String url = "jdbc:mysql://10.140.169.253/testjdbc";
			String url = "jdbc:mariadb://localhost/mydb"; // like IP address

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			con = DriverManager.getConnection(url, dbUser, usrPass);
			Statement stmt = con.createStatement();

			// STEP 4: Execute a query
			//String sqlupdate = "select * from teams";
			String sql = "select * from User";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println("User Id: " + rs.getInt("UserID"));
				System.out.println("User Name: " + rs.getString("UserName"));
				System.out.println("User Password: " + rs.getString("Password"));

				System.out.println("===================");
			}
			rs.close();
			stmt.close();
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TestMyMariadb();
	}

}
