package DBClasses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;

import classes.Customer;

public class CustomerDB 
{
	public static Customer GetCustomer(int customerID) throws ClassNotFoundException, SQLException
    {
		Customer c=new Customer();
		PreparedStatement select=null;
		Connection con= mmaBooks.GetConnection();
		String selectStatement="Select *"
							+ "from customers"+
								"Where customerID=?";
		try 
		{
			con.setAutoCommit(false);
			select=con.prepareStatement(selectStatement);
			//select goes here
			ResultSet rset=select.executeQuery(selectStatement);
			while(rset.next())
			{
				 c.setCustomerID(rset.getInt("CustomerID"));
				 c.setName(rset.getString("Name"));
				 c.setAddress(rset.getString("Address"));
				 c.setCity(rset.getString("City"));
				 c.setState(rset.getString("State"));
				 c.setZipCode(rset.getString("ZipCode"));
				 
			}
			
		}
		catch(SQLException e)
		{
			//log error?
			if(con!=null)
			{
				System.err.print("Statement failed");
				
			}
		}
		finally
		{
			if(select!=null)
			{
				select.close();
			}
			con.setAutoCommit(true);
		}
		
		
		return c;

    }
    public static int AddCustomer(Customer customer ) throws SQLException, ClassNotFoundException
    {
    	//no customerID?
    	int i=-1;
    	Customer c=new Customer();
		PreparedStatement insertStatment=null;
		Connection con= mmaBooks.GetConnection();
		String insertSQL="insert into Customers"
							+ "(CustomerId,Name,Address,City,State,ZipCode)"+
								"Values(?,?,?,?,?,?)";
		
		
		try 
		{
			con.setAutoCommit(false);
			insertStatment=con.prepareStatement(insertSQL);
			//insertStatment=con.prepareStatement(insertSQL);
			//select goes here
			//ResultSet rset=insertStatment.executeQuery(insertSQL);
			insertStatment.setInt(1,customer.getID());
			insertStatment.setString(2, customer.getName());
			insertStatment.setString(3, customer.getAddress());
			insertStatment.setString(4, customer.getCity());
			insertStatment.setString(5, customer.getState());
			insertStatment.setString(6, customer.getZip());
			insertStatment.executeUpdate();
			i= 0;
			
			
		}
		catch(SQLException e)
		{
			//log error?
			if(con!=null)
			{
				System.err.print("Statement failed");
				i= -1;
			}
		}
		finally
		{
			if(insertStatment!=null)
			{
				insertStatment.close();
			}
			con.setAutoCommit(true);
		}
		return i;

    }
    public static Boolean DeleteCustomer(Customer customer) throws ClassNotFoundException, SQLException
    {
    	Boolean flag=false;
    	    	
		PreparedStatement deleteStatement=null;
		Connection con= mmaBooks.GetConnection();
		String deleteSQL="delete from Customers"
						+ "(where Customerid=? "
						+ "and customer.Name=?"
						+ "and customer.Address=?"
						+ "and customer.City=?"
						+ "and customer.State=?"
						+ "and customer.ZipCode=?";		
		try 
		{
			con.setAutoCommit(false);
			deleteStatement=con.prepareStatement(deleteSQL);
			//insertStatment=con.prepareStatement(insertSQL);
			//select goes here
			//ResultSet rset=insertStatment.executeQuery(insertSQL);
			deleteStatement.setInt(1,customer.getID());
			deleteStatement.setString(2, customer.getName());
			deleteStatement.setString(3, customer.getAddress());
			deleteStatement.setString(4, customer.getCity());
			deleteStatement.setString(5, customer.getState());
			deleteStatement.setString(6, customer.getZip());
			deleteStatement.executeUpdate();
			flag=true;
		}
		catch(SQLException e)
		{
			//log error?
			if(con!=null)
			{
				System.err.print("Statement failed");
				flag=false;
			}
		}
		finally
		{
			if(deleteStatement!=null)
			{
				deleteStatement.close();
			}
			con.setAutoCommit(true);
		}
	
		return flag;

    }
    public static Boolean UpdateCustomer(Customer oldCustomer,Customer newCustomer) throws SQLException, ClassNotFoundException
    {
    	Boolean flag=false;
    	
		PreparedStatement updateStatement=null;
		Connection con= mmaBooks.GetConnection();
		String updateSQL="update Customers"
						+"set Name=?"
						+ "Address=?"
						+ "City=?"
						+ "State=?"
						+ "ZipCode=?"
						+ "(where Customerid=? "
						+ "and Name=?"
						+ "and Address=?"
						+ "and City=?"
						+ "and State=?"
						+ "and ZipCode=?)";		
		try 
		{
			con.setAutoCommit(false);
			updateStatement=con.prepareStatement(updateSQL);
			//insertStatment=con.prepareStatement(insertSQL);
			//select goes here
			//ResultSet rset=insertStatment.executeQuery(insertSQL);
			updateStatement.setInt(1,newCustomer.getID());
			updateStatement.setString(2, newCustomer.getName());
			updateStatement.setString(3, newCustomer.getAddress());
			updateStatement.setString(4, newCustomer.getCity());
			updateStatement.setString(5, newCustomer.getState());
			updateStatement.setString(6, newCustomer.getZip());
			updateStatement.setInt(7,oldCustomer.getID());
			updateStatement.setString(8, oldCustomer.getName());
			updateStatement.setString(9, oldCustomer.getAddress());
			updateStatement.setString(10, oldCustomer.getCity());
			updateStatement.setString(11, oldCustomer.getState());
			updateStatement.setString(12, oldCustomer.getZip());
			updateStatement.executeUpdate();
			flag=true;
		}
		catch(SQLException e)
		{
			//log error?
			if(con!=null)
			{
				System.err.print("Statement failed");
				flag=false;
			}
		}
		finally
		{
			if(updateStatement!=null)
			{
				updateStatement.close();
			}
			con.setAutoCommit(true);
		}
	
		return flag;
        
    }
}
