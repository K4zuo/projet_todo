package serveur;

import java.sql.*;

public class SQLiteJDBC {
	private SQLiteJDBC sqLiteJDBC = null;

	private SQLiteJDBC() {

	}

	public SQLiteJDBC getInstance() {
		if (sqLiteJDBC == null)
			sqLiteJDBC = new SQLiteJDBC();
		return sqLiteJDBC;
	}

	public void connect() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:todo.db");
//			statement = connection.createStatement();
//			statement.setQueryTimeout(30);  // set timeout to 30 sec.
//
//			statement.executeUpdate("drop table if exists person");
//			statement.executeUpdate("create table person (id integer, name string)");
//			statement.executeUpdate("insert into person values(1, 'leo')");
//			statement.executeUpdate("insert into person values(2, 'yui')");
//			rs = statement.executeQuery("select * from person");
//			while(rs.next()) {
//				// read the result set
//				System.out.println("name = " + rs.getString("name"));
//				System.out.println("id = " + rs.getInt("id"));
//			}
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			if(rs != null)
				try {
					rs.close();
				}
				catch(SQLException e) {
					System.err.println(e);
				}
			if(statement != null)
				try {
					statement.close();
				}
				catch(SQLException e) {
					System.err.println(e);
				}
			if(connection != null)
				try {
					connection.close();
				}
				catch(SQLException e) {
					System.err.println(e);
				}
		}
	}
}
