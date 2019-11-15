package mycodeTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class note {
	try {
		String dbUser="studentUsr";
		String usrPass="abcdef1!";
		Class.forName("com.mysql.jdbc.Driver");  // driver details		
		Connection con=null;
		String url="jdbc:mysql://localhost/testjdbc";  // like IP address
		con=DriverManager.getConnection(url,dbUser,usrPass); // establis the connection
		Statement stmt=con.createStatement();//  helps to pass the statment
		String sql="select * form users";
		ResultSet rs=stmt.executeQuery(sql); // holds the set of results in that object set
		
		while(rs.next()) {
			System.out.println("User Id:"+ rs.getInt("userID"));
			System.out.println("User Name:"+ rs.getString("userName"));
			System.out.println("=============================");
		}
	}catch(Exception ex) {
		ex.printStackTrace();		
	}
	
}
