package sqlexamples;

import java.sql.*;
public class SelectMySqlDB {
public static void main(String args[]) throws SQLException,Exception {
	//register the driver to connect to mysql environment
	Class.forName("com.mysql.cj.jdbc.Driver");
	//Establish the connection
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false","root","root");
	//enable the STatement object to pass sql queries.
	Statement stmt = con.createStatement();
	//use the ResultSet
	ResultSet rs = stmt.executeQuery("select * from dept");
	
	//iterate the rows
	while(rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
	}
	
	rs.close();
	stmt.close();
	con.close();
   }
}
