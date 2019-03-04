package DBClasses;
import java.sql.*;

import classes.Customer;
import classes.state;

public class stateDB 
{
	public state getState(String stateCode) throws ClassNotFoundException, SQLException
	{
		state s=new state();
		PreparedStatement selectStatement=null;
		Connection con= mmaBooks.GetConnection();
		String selectSQL="Select *"
							+ "from states"+
								"Where stateCode=?";
		try 
		{
			con.setAutoCommit(false);
			selectStatement=con.prepareStatement(selectSQL);
			//select goes here
			selectStatement.setString(1, stateCode);
			ResultSet rset=selectStatement.executeQuery(selectSQL);
			while(rset.next())
			{
				 s.setStateName(rset.getString("StateName"));
				
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
			if(selectStatement!=null)
			{
				selectStatement.close();
			}
			con.setAutoCommit(true);
		}
		
		
		return s;
	}
}
