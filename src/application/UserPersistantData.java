package application;

public class UserPersistantData {

	private static UserPersistantData instance;
	
	private String email;
	
	private UserPersistantData() {
	}
	
	public static UserPersistantData getInstance() {
		if (instance == null) {
			instance = new UserPersistantData();
		}
		return instance;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
