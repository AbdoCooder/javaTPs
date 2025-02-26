package org.mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class Main
{
	public static void main(String[] args)
	{
		String jdbcUrl = "jdbc:mysql://localhost:3306/JDBC";
		String username = "abenajib";
		String password = "abenajib42";

		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password))
		{
			if (connection != null)
			{
				System.out.println("Connected to the database!");

				String query = "SELECT * FROM users";
				try (Statement statement = connection.createStatement();
					 ResultSet resultSet = statement.executeQuery(query))
					 {

					while (resultSet.next())
					{
						int id = resultSet.getInt("id");
						String user = resultSet.getString("username");
						String email = resultSet.getString("email");
						System.out.println("ID: " + id + ", Username: " + user + ", Email: " + email);
					}
				}
			}
			else
				System.out.println("Failed to make connection!");
		}
		catch (SQLException e)
		{
			System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			AbandonedConnectionCleanupThread.checkedShutdown();
		}
	}
}
