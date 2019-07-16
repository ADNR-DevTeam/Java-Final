package attr;

public abstract class UserDecorator extends User {
	protected static User decoratedUser;
	public UserDecorator(String userId, User decoratedUser) {
		super(userId);
		UserDecorator.decoratedUser = decoratedUser;
	}
	
	@Override
	public double  CheckSum() {
		return decoratedUser.CheckSum();
	}

}
