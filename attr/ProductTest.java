package attr;
import junit.framework.TestCase;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ProductTest extends TestCase  {
	String productID = "12";
	Product p=new Product(productID);
	double price=150;int quantity=5;
	String name="Redbull";
	
	
	public void test1CreateProduct()
	{
		ResultSet rs;
		SetArguments(p);
		p.createProduct();
		try {
			Database db=Database.getInstance();
			rs = db.DBquery("SELECT `productId`, `productName`, `price`, `quantity` FROM `product` WHERE `productId`='"+this.productID+"';");
			assertEquals("checking the db query and the data",name,rs.getString("productName"));
			assertEquals("checking the db query and the data",(quantity-4),rs.getInt("quantity"));
			assertEquals("checking the db query and the data",price,rs.getDouble("price"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void test2UpdateProduct()
	{
		ResultSet rs;
		name="vodka";price=12.5;quantity=50;
		p.updateProduct(name, price, quantity);
		try {
			Database db=Database.getInstance();
			rs = db.DBquery("SELECT `productId`, `productName`, `price`, `quantity` FROM `product` WHERE `productId`='"+this.productID+"';");
			assertEquals("check update method logic",name,rs.getString("productName"));
			assertEquals("check update method logic", price,rs.getDouble("price"));
			assertEquals("check update method logic", quantity,rs.getInt("quantity"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void test3SellProduct()
	{
		int AmountToSell=4;
		int num=0;
		ResultSet rs;
		SetArguments(p);
		p.sellProduct("12", AmountToSell);
		try {
			Database db=Database.getInstance();
			rs = db.DBquery("SELECT `productId`, `productName`, `price`, `quantity` FROM `product` WHERE `productId`='"+this.productID+"';");
			num=rs.getInt("quantity");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("check the logic in the method sell product",quantity-AmountToSell,num);
	}
	
	
	public void SetArguments(Product p)
	{
		p.setPrice(price);
		p.setProductName(name);
		p.setQuantity(quantity);
	}
	

}
