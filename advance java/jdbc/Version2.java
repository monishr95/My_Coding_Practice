//A compact version of program1

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Version2 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to MySQL!");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");// or u can store the query in a string variable and
																	// then place that over here.

			while (rs.next()) {
				/*
				 * System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " +
				 * rs.getString(3));
				 */
				//we can even use column names to call that item

				System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email")
						+ " | " + rs.getString("courses"));
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}