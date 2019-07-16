package attr;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDecorator extends UserDecorator {

	public EmployeeDecorator(String userId) {
		super(userId, decoratedUser);
	}
	
	@Override
	public double CheckSum() {
		String query = "Select SUM(cost) from purchaseinfo";
		ResultSet rs = null;
		try {
			Database db = Database.getInstance();
			rs = db.DBquery(query);
			return rs.getDouble(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}

	@Override
	public void fetch() {
		// TODO Auto-generated method stub
		
	}
		
	}
