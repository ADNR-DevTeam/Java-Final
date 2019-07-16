package attr;
import junit.framework.TestCase;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CustomerTest extends TestCase {
	String usrid="Testing";
	String psw="12345";
	String s="Dolev";
	
	Customer c = new Customer(usrid);
	@Test

		//from class User(because the class is an abstract)
		public void Test1Username() {
			String usr=c.getUserId();
			assertEquals("The getUserId method doenst work fine ",usr,usrid);
		}
		
	public void test2Name() {
		c.setCustomerName(s);
		assertEquals("Names are not Equals",s,c.getCustomerName());
	}
	
	public void test3Phone() {
		String num="123456789";
		int num2=123456789;
		c.setPhoneNumber(num2);
		assertEquals("Phones are not Equals","+972"+num,c.getPhoneNumber());
	}
	public void test4Address() {
		String address="Dizengof 97 Tel aviv";
		c.setAddress(address);
		assertEquals("Address are not Equals","Dizengof 97 Tel aviv",c.getAddress());
	}
	
	public void test5UpdateCustomer()
	{
		String name="Ronen";
		int phone=123456789;
		String address="HIT HOLON";
		c.updateCustomer(name, phone, address);
		assertEquals("the update for the Customer name doesnt work fine",name,c.getCustomerName());
		assertEquals("the update for the Customer phone doesnt work fine","+972"+phone,c.getPhoneNumber());
		assertEquals("the update for the Customer address doesnt work fine",address,c.getAddress());
	}
	
	public void test6DeleteCustomer()
	{
		ResultSet rs;
		c.deleteCustomer();
		String n="NotEMPTY";
		try {
			Database db=Database.getInstance();
			rs = db.DBquery("SELECT `userId` FROM `customer`;");
			if (rs.getString("userId").contains(usrid)==false)
				n=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull("check if the customer deleted",n);
	}
}
