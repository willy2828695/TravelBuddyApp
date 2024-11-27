package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserList {
	
	public static UserList userListInsatnce;
	
	public List<UserProfile> userProfiles = new ArrayList<>();
	
	private UserList() {
		userProfiles.add(new UserProfile("Alice", "alice@example.com", "password1", 500, Arrays.asList("Hiking", "Photography", "Cycling")));
		userProfiles.add(new UserProfile("Bob", "bob@example.com", "password2", 700, Arrays.asList("Camping", "Stargazing", "Fishing", "Pet Outing")));
		userProfiles.add(new UserProfile("Charlie", "charlie@example.com", "password3", 300, Arrays.asList("Rock Climbing", "Kayaking/Canoeing")));
		userProfiles.add(new UserProfile("Diana", "diana@example.com", "password4", 600, Arrays.asList("Cycling", "Running/Jogging", "Outdoor Board Games")));
		userProfiles.add(new UserProfile("Eve", "eve@example.com", "password5", 450, Arrays.asList("Scuba Diving", "Birdwatching", "Biking Trails")));
		userProfiles.add(new UserProfile("Frank", "frank@example.com", "password6", 800, Arrays.asList("Fishing", "Group BBQ/Grilling", "Cherry Blossom Viewing")));
		userProfiles.add(new UserProfile("Grace", "grace@example.com", "password7", 250, Arrays.asList("Outdoor Yoga Classes", "Photography", "Autumn Leaf Walks")));
		userProfiles.add(new UserProfile("Hank", "hank@example.com", "password8", 400, Arrays.asList("Skiing/Snowboarding", "Ice Skating", "Stargazing")));
		userProfiles.add(new UserProfile("Ivy", "ivy@example.com", "password9", 550, Arrays.asList("Cherry Blossom Viewing", "Birdwatching", "Hiking")));
		userProfiles.add(new UserProfile("Jack", "jack@example.com", "password10", 700, Arrays.asList("Autumn Leaf Walks", "Pet Outing", "Fishing")));
		userProfiles.add(new UserProfile("Kate", "kate@example.com", "password11", 350, Arrays.asList("Outdoor Board Games", "Rock Climbing", "Scuba Diving")));
		userProfiles.add(new UserProfile("Leo", "leo@example.com", "password12", 420, Arrays.asList("Biking Trails", "Hiking", "Kayaking/Canoeing")));
		userProfiles.add(new UserProfile("Mia", "mia@example.com", "password13", 380, Arrays.asList("Birdwatching", "Stargazing", "Running/Jogging")));
		userProfiles.add(new UserProfile("Nina", "nina@example.com", "password14", 480, Arrays.asList("Kayaking/Canoeing", "Photography", "Fishing", "Camping")));
		userProfiles.add(new UserProfile("Oscar", "oscar@example.com", "password15", 620, Arrays.asList("Camping", "Fishing", "Group BBQ/Grilling")));
		userProfiles.add(new UserProfile("Paul", "paul@example.com", "password16", 750, Arrays.asList("Scuba Diving", "Running/Jogging", "Ice Skating")));
		userProfiles.add(new UserProfile("Quinn", "quinn@example.com", "password17", 520, Arrays.asList("Stargazing", "Rock Climbing", "Cycling")));
		userProfiles.add(new UserProfile("Rose", "rose@example.com", "password18", 300, Arrays.asList("Cycling", "Ice Skating", "Autumn Leaf Walks")));
		userProfiles.add(new UserProfile("Steve", "steve@example.com", "password19", 850, Arrays.asList("Outdoor Yoga Classes", "Skiing/Snowboarding", "Cherry Blossom Viewing")));
		userProfiles.add(new UserProfile("Tina", "tina@example.com", "password20", 430, Arrays.asList("Cherry Blossom Viewing", "Pet Outing", "Outdoor Board Games", "Photography")));
	}
	
	public static UserList getUserListInstance() {
		if (userListInsatnce == null) {
			userListInsatnce = new UserList();
		}
		return userListInsatnce;
	}
	
	
	
	public void addUser(UserProfile userProfile) {
		userProfiles.add(userProfile);
	}
	
	public UserProfile getUserProfilByEmail(String email) {
		for (UserProfile userProfile: userProfiles) {
			if (userProfile.getEmail() == email) {
				return userProfile;
			}
		}
		return null;
	}
	
	
	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}
	
	public boolean isUserExist(String email, String password) {	
		List<UserProfile> userProfiles = getUserProfiles();
		if (userProfiles.size() == 0) return true;
		for (UserProfile userProfile: userProfiles) {
			if (userProfile.getEmail() == email || userProfile.getPassword() == password) {
				return false;
			}
		}
		return true;
	}

}
