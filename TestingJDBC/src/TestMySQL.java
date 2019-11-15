import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestMySQL {
	public TestMySQL() {
		// TODO Auto-generated constructor stub

		try {
			String dbUser = "studentUsr";
			String usrPass = "WhoCares12345";
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = null;

			String url = "jdbc:mysql://10.140.169.253/testjdbc";
			//String url="jdbc:mysql://localhost/testjdbc";  // like IP address

			con = DriverManager.getConnection(url, dbUser, usrPass);

			Statement stmt = con.createStatement();

			String sql = "select * from users";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println("User Id: " + rs.getInt("userID"));
				System.out.println("User Name: " + rs.getString("userName"));
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
		// TODO Auto-generated method stub

		new TestMySQL();
	}
}