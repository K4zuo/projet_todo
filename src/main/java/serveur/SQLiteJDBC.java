package serveur;

import java.sql.*;

public class SQLiteJDBC {
	private SQLiteJDBC sqLiteJDBC = null;

	private SQLiteJDBC() {

	}

	/**
	 * Accessor of this singleton
	 * @return the instance of this controller
	 */
	public SQLiteJDBC getInstance() {
		if (sqLiteJDBC == null)
			sqLiteJDBC = new SQLiteJDBC();
		return sqLiteJDBC;
	}

	/**
	 * This method is called by the run method of the ThreadClient if the request
	 * doesn't start with "SELECT"
	 * It calls ThreadClient#sendRowsChanged(int) with the number of rows affected.
	 * @see ThreadClient#run()
	 * @see ThreadClient#sendRowsChanged(int)
	 * @param request The request sent by the client
	 * @param thread The client's thread that gets the answer
	 */
	public void executeUpdate(String request, ThreadClient thread) {
		Connection connection = null;
		Statement statement = null;
		int rowsChanged = -1;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:todo.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.
			rowsChanged = statement.executeUpdate(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			thread.sendRowsChanged(rowsChanged);
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

	/**
	 * This method is called by the run method of the ThreadClient if the request
	 * starts with "SELECT"
	 * It calls ThreadClient#sendResult(ResultSet) with the result of the request.
	 * @see ThreadClient#run()
	 * @see ThreadClient#sendResult(ResultSet)
	 * @param request The request sent by the client
	 * @param thread The client's thread that gets the answer
	 */
	public void executeQuery(String request, ThreadClient thread) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:todo.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.
			rs = statement.executeQuery(request);
			thread.sendResult(rs);
		} catch (SQLException e) {
			e.printStackTrace();
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
