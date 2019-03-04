package DBClasses;

public class validate
{
	
	public static Boolean isInt(String s)
	{
		try 
		{
			Integer.parseInt(s);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public Boolean range(String s)
	{
		int i=Integer.parseInt(s);
		if(i<0||i>10000)
		{
			return false;
		}
		else
			return true;
	}
}
