package DBClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mmaBooks 
{

	public static Connection GetConnection() throws SQLException, ClassNotFoundException
	{


		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//String connectionURL="jdbc:sqlserver:DESKTOP-AFHCP3M\\sqlexpress;" +
          //      "database=MMABooks;";
               // "user=UserName;" +
                //"password=Password"; 
		//String connectionURL = "jdbc:sqlserver://DESKTOP-AFHCP3M\\SQLEXPRESS;databaseName=MMABooks;integratedSecurity=true";
		String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=MMABooks;user=user;password=password";
		//"jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";
		Connection con=DriverManager.getConnection(connectionURL);
		System.out.println("Connected");
		
		return con;
	}
}
