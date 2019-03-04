package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DBClasses.CustomerDB;
import classes.Customer;

class testCustomer 
{
	Customer c;
	Customer c1;
	Customer c2;
	@BeforeEach
	void setUp() throws Exception 
	{
		c=new Customer();
		c1=new Customer();
		c1.setCustomerID(3);
		c1.setName("Antony, Abdul");
		c1.setAddress("1109 Powderhorn Drive");
		c1.setCity("Fayetteville");
		c1.setState("NC");
		c1.setZipCode("28314");
		c2=new Customer();
		c2.setCustomerID(3);
		c2.setName("AAAAAA");
		c2.setAddress("BBBBBB");
		c2.setCity("CCCCCCCC");
		c2.setState("HI");
		c2.setZipCode("DDDDDD");
	}

	@Test
	void testC() 
	{
		c.setCustomerID(1);
		int i=c.getID();
		assertEquals(i,1);
		c.setName("Will");
		String s=c.getName();
		assertEquals("Will",s);
		c.setAddress("123 A st");
		s=c.getAddress();
		assertEquals("123 A st",s);
		c.setCity("Eugene");
		s=c.getCity();
		assertEquals("Eugene",s);
		c.setState("Or");
		assertEquals("Or",c.getState());
		c.setZipCode("97403");
		assertEquals("97403",c.getZip());
	}
	@Test
	void testSelect() throws ClassNotFoundException, SQLException
	{
		Customer c2=CustomerDB.GetCustomer(3);
		assertEquals(c1.getID(),c2.getID());
		assertEquals(c1.getAddress(),c2.getAddress());
		assertEquals(c1.getCity(),c2.getCity());
		assertEquals(c1.getName(),c2.getName());
		assertEquals(c1.getState(),c2.getState());
		assertEquals(c1.getZip(),c2.getZip());
	}
	@Test
	void testUpdate() throws ClassNotFoundException, SQLException
	{
		CustomerDB.UpdateCustomer(c1, c2);
		c1=CustomerDB.GetCustomer(3);
		assertEquals(c1.getID(),c2.getID());
		assertEquals(c1.getAddress(),c2.getAddress());
		assertEquals(c1.getCity(),c2.getCity());
		assertEquals(c1.getName(),c2.getName());
		assertEquals(c1.getState(),c2.getState());
		assertEquals(c1.getZip(),c2.getZip());
	}
	@Test
	void testInsert() throws ClassNotFoundException, SQLException
	{
		CustomerDB.AddCustomer(c2);
		Customer cTest=CustomerDB.GetCustomer(0);
		assertEquals(cTest.getID(),c2.getID());
		assertEquals(cTest.getAddress(),c2.getAddress());
		assertEquals(cTest.getCity(),c2.getCity());
		assertEquals(cTest.getName(),c2.getName());
		assertEquals(cTest.getState(),c2.getState());
		assertEquals(cTest.getZip(),c2.getZip());
	}
	@Test
	void testDelete() throws ClassNotFoundException, SQLException
	{
		Boolean flag=true;
		c2.setCustomerID(1000);
		CustomerDB.AddCustomer(c2);
		CustomerDB.DeleteCustomer(c2);
		try
		{
			CustomerDB.GetCustomer(1000);
			flag=false;
		}
		catch(Exception e)
		{
			flag=true;
		}
		assertTrue(flag);
		
	}




	

}
