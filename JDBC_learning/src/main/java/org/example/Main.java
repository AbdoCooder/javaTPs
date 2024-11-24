package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/jdbc_learning";
        String user = "root";
        String password = "root";
        try
        {
            Connection con = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}