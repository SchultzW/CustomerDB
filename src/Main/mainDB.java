package Main;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import DBClasses.CustomerDB;
import DBClasses.validate;
import classes.Customer;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class mainDB 
{

	//https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
			//https://www.mkyong.com/jdbc/jdbc-preparestatement-example-select-list-of-the-records/
	static String newLine = System.getProperty("line.separator");
	static Scanner in = new Scanner(System.in);
	static Logger logger = Logger.getLogger("CustomerDB");
	
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
		 	
		System.out.println("Welcome to the Customer Database");
		System.out.println("Would you like to Update | Delete | View | Add | a customer?");
		handleChoice();
		
		
			
			
		
		//catch(Exception e)
	//	{
		//	logger.log(Level.SEVERE, "Failed to connect to databse");
		//}
		
	}
	public static void handleChoice()
	{
		System.out.println("Welcome to the Customer Database");
		System.out.println("Would you like to Update | Delete | View | Add | a customer?");
		String response=in.nextLine();
		response=response.toLowerCase();
		try 
		{
			switch(response)
			{
				case "update":
					updateCustomer();
					break;
				case "delete":
					deleteCustomer();
					break;
				case "view":
					selectCustomer();
					break;
				case "add":
					insertCustomer();
					break;		
			}
		}
		catch(Exception e)
		{
			System.out.println("That is not a valid response. Please try again.");
			handleChoice();
		}
		
		
	}
	public static void insertCustomer() throws ClassNotFoundException, SQLException
	{
		Customer c=new Customer();
		System.out.println("Enter new Customer's name (Last,first).");
		c.setName(in.nextLine());
		System.out.println("Enter the customer's address.");
		c.setAddress(in.nextLine());
		System.out.println("Enter new customer's city.");
		c.setCity(in.nextLine());
		System.out.println("Enter new customer's state.");
		c.setState(in.nextLine());
		System.out.println("Enter new customer's zipcode.");
		c.setZipCode(in.nextLine());
		CustomerDB.AddCustomer(c);
		System.out.println("New Customer has been added.");
	}
	public static void selectCustomer() throws NumberFormatException, ClassNotFoundException, SQLException
	{
		System.out.println("Enter the Customer ID of the cutomer you would like to view:");
		String ID=in.nextLine();
		ID=ID.trim();
		Boolean flag=validate.isInt(ID);
		if(flag==true)
		{
			Customer c=CustomerDB.GetCustomer(Integer.parseInt(ID));
			System.out.println("Customer ID: "+c.getID());
			System.out.println("Customer Name: "+c.getName());
			System.out.println("Customer Address: "+c.getAddress());
			System.out.println("Customer City: "+c.getCity());
			System.out.println("Customer State: "+c.getState());
			System.out.println("Customer Zipcode: "+c.getZip());
		}
		else
		{
			System.out.println("That is not a valid ID number.");
		}
	}
	public static void updateCustomer() throws ClassNotFoundException, SQLException
	{
		System.out.println("Enter the Customer ID of the customer you would like to update:");
		String ID=in.nextLine();
		ID=ID.trim();
		Boolean flag=validate.isInt(ID);
		if(flag==true)
		{
			Customer oldC=CustomerDB.GetCustomer(Integer.parseInt(ID));
			Customer c=new Customer();
			System.out.println("What is the new name for the customer (Last,first)?");
			c.setName(in.nextLine());
			System.out.println("Enter the new address for the customer.");
			c.setAddress(in.nextLine());
			System.out.println("Enter the new city for the customer.");
			c.setCity(in.nextLine());
			System.out.println("Enter the new state for the customer.");
			c.setState(in.nextLine());
			System.out.println("Enter the new zipcode for the state.");
			c.setZipCode(in.nextLine());
			CustomerDB.UpdateCustomer(oldC, c);
			System.out.println("Customer updated.");
		}
	}
	public static void deleteCustomer() throws NumberFormatException, ClassNotFoundException, SQLException
	{
		System.out.println("Enter the Customer ID of the customer you would like to delete:");
		String ID=in.nextLine();
		ID=ID.trim();
		Boolean flag=validate.isInt(ID);
		if(flag==true)
		{
			Customer c=CustomerDB.GetCustomer(Integer.parseInt(ID));
			System.out.println("Customer ID: "+c.getID());
			System.out.println("Customer Name: "+c.getName());
			System.out.println("Customer Address: "+c.getAddress());
			System.out.println("Customer City: "+c.getCity());
			System.out.println("Customer State: "+c.getState());
			System.out.println("Customer Zipcode: "+c.getZip());
			System.out.println("Are you sure you would like to delete this customer? Yes | No");
			String response=in.nextLine();
			response=response.toLowerCase();
			if(response=="yes")
			{
				CustomerDB.DeleteCustomer(c);
			}
			else if(response=="no")
			{
				deleteCustomer();
			}
			else
			{
				System.out.println("That is not a valid response.");
				deleteCustomer();
			}
			
		}
	}
}
