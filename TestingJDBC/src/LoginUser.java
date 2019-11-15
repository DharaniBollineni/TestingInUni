import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginUser {

	public LoginUser() {
		// TODO Auto-generated constructor stub

		try {
			// mysql -u myuser -pmypass mydb
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

			Scanner myObj = new Scanner(System.in); // Create a Scanner object
			System.out.println("Enter username");
			String userName = myObj.nextLine(); // Read user input

			System.out.println("Enter Password");
			String Password = myObj.nextLine(); // Read user input

			// check whether user record is present or not
			String sql = "Select * from User where UserName = \"" + userName + "\" and Password =\"" + Password + "\"";

			System.out.println(sql);

			// STEP 4: Execute a query
			// String sqlupdate = "select * from teams";
			// String sql = "select * from User";
			// ResultSet rs = stmt.executeQuery(sql);

			// Dynamically generating SQL strings is not recommend however since it can
			// expose your application to sql injection.

			// Instead use a PreparedStatement:
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				System.out.println("Loged in successfully");
			} else
				System.out.println("Errrrro!");

			rs.close();
			stmt.close();
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new LoginUser();
	}
}
