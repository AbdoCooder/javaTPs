import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
{

	public static void main(String[] args)
	{
		if (args.length > 0 && Integer.parseInt(args[0]) > 0)
		{
			System.out.println("positive");
		}
		else
		{
			System.out.println("negative");
		}
	}
}
