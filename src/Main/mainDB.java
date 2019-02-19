package Main;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class mainDB 
{

	static String newLine = System.getProperty("line.separator");
	static Scanner in = new Scanner(System.in);
	static Logger logger = Logger.getLogger("BlackJack");
	
	public static void main(String args[]) throws Exception
	{
		//System.out.println("");
		//in.nextLine()
	 	
		
		if(System.getProperty("java.util.config.class")==null && System.getProperty("java.util.logging.config.file")==null)
		{
			try
			{
				Logger.getLogger("").setLevel(Level.ALL);
				final int LOG_ROTATION_COUNT=10;
				Handler handler =new FileHandler("C:/Users/wills/eclipse-workspace/CustomerDB",0,LOG_ROTATION_COUNT);
				Logger.getLogger("").addHandler(handler);
			}
			catch(IOException e)
			{
				logger.log(Level.SEVERE, "Unable to find log file hanlder", e);
			}
		}
		 
		
			

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//String connectionURL="jdbc:sqlserver:DESKTOP-AFHCP3M\\sqlexpress;" +
              //      "database=MMABooks;";
                   // "user=UserName;" +
                    //"password=Password"; 
			//String connectionURL = "jdbc:sqlserver://DESKTOP-AFHCP3M\\SQLEXPRESS;databaseName=MMABooks;integratedSecurity=true";
			String connectionURL="jdbc:sqlserver://127.0.0.1:1433;databaseName=MMABooks;user=user;password=password";
			//"jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";
			Connection con=DriverManager.getConnection(connectionURL);
			System.out.println("Connected");
			
			
		
		//catch(Exception e)
	//	{
		//	logger.log(Level.SEVERE, "Failed to connect to databse");
		//}
	}
}
