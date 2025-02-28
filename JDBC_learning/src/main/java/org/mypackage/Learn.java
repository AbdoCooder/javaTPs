package org.mypackage;

import java.sql.*;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class Learn
{
	public static void main(String[] args)
	{
		String dburl = System.getenv("DB_URL");
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");

		try
		{
			Connection connection = DriverManager.getConnection(dburl, user, password);
			Statement statement = connection.createStatement();
			String query = "DELETE FROM learners WHERE NAME='tomato'";
			int updated = statement.executeUpdate(query);
			if (updated > 0)
				System.out.println("Deleted " + updated + " row(s)");
			else
				System.out.println("No row deleted");
			query = "SELECT * FROM learners";
			ResultSet result = statement.executeQuery(query);
			while (result.next())
				System.out.println("Id: " + result.getInt(1) + "| Name " + result.getString(2) + "| Age " + result.getInt(3));

			result.close();
			statement.close();
			connection.close();
		}
		catch (SQLException e)
		{
			System.out.println("Error <SQLException> : " + e.getMessage() + "\nError code (" + e.getErrorCode() + ")\n SQLState: " + e.getSQLState());
		}
		finally
		{
			AbandonedConnectionCleanupThread.checkedShutdown();
		}
	}
}
