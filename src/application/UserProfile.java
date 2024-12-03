package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserProfile {
	
	private String name;
	
	private String email;
	
	private String password;
	
	private int budget;
	
	private Map<String, Boolean> interest = new HashMap<>();
	
	private List<Event> matchedEvents = new ArrayList<>();
	
	private List<UserProfile> matchedPartners = new ArrayList<>();
	
	public UserProfile() {
		interest.put("Hiking", false);
		interest.put("Camping", false);
		interest.put("Rock Climbing", false);
		interest.put("Kayaking/Canoeing", false);
		interest.put("Scuba Diving", false);
		interest.put("Cycling", false);
		interest.put("Running/Jogging", false);
		interest.put("Photography", false);
		interest.put("Stargazing", false);
		interest.put("Birdwatching", false);
		interest.put("Fishing", false);
		interest.put("Group BBQ/Grilling", false);
		interest.put("Outdoor Yoga Classes", false);
		interest.put("Skiing/Snowboarding", false);
        interest.put("Ice Skating", false);
        interest.put("Cherry Blossom Viewing", false);
        interest.put("Autumn Leaf Walks", false);
        interest.put("Pet Outing", false);
        interest.put("Outdoor Board Games", false);
        interest.put("Biking Trails", false);
	}
	
	public UserProfile(String name, String email,  String password, int budget, List<String> interests) {
		this();
		this.name = name;
		this.email = email;
		this.password = password;
		setInterest(interests);
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public void setInterest(List<String> interests) {
		for (String interest: interests) {
			this.interest.put(interest, true);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public int getBudget() {
		return this.budget;
	}
	
	public Map<String, Boolean> getInterest() {
		return this.interest;
	}
	public void addMatchedEvent(Event event) {
	    this.matchedEvents.add(event);
	}

	public void addMatchedPartner(UserProfile partner) {
	    this.matchedPartners.add(partner);
	}

	public List<Event> getMatchedEvents() {
	    return this.matchedEvents;
	}

	public List<UserProfile> getMatchedPartners() {
	    return this.matchedPartners;
	}
}

