import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryStudentTable
{

	private static final String DATABASE = "jdbc_learning";
	private static final String URL = "jdbc:mysql://localhost:3306/"+DATABASE;
	private static final String USER = "root";
	private static final String PASSWORD = "abdocooder";

	public static void main(String[] args)
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{
			// Establish a connection to the database
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connected to the database!");

			// Create a statement
			statement = connection.createStatement();

			// Query to retrieve data from the student table
			String query = "SELECT * FROM student;";
			resultSet = statement.executeQuery(query);

			// Display the results
			System.out.println("ID | Name         | Email                  | Note");
			System.out.println("-----------------------------------------------");
			while (resultSet.next())
			{
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				float note = resultSet.getFloat("note");

				System.out.printf("%2d | %-12s | %-20s | %.2f%n", id, name, email, note);
			}
		}
		catch (SQLException e)
		{
			System.err.println("Error while accessing the database:");
			e.printStackTrace();
		}
		finally
		{
			// Close resources
			try {
				if (resultSet != null) resultSet.close();
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
