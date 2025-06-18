package jdbc;

 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Version1 {
	public static void main(String[] args) {
		Statement stmt = null;
		Connection con = null;
		ResultSet res = null;
		// step:1 Loading and registering the driver.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// step:2 Establishing the collection

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
			System.out.println("Connection established");
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		String sql = "SELECT * FROM student";
		try {
			stmt = con.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			res = stmt.executeQuery(sql);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (res.next()) {
				System.out.println(res.getInt(1) + "   " + res.getString(2) + "   " +  res.getString(3));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
}








/*
first jdbc
program to
connect will
sql and
fetch the
entire table*/