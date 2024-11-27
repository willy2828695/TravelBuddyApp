package application;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Event {
	
	private String city;
	
	private int cost;
	
	private List<String> activites;
	
	private LocalDate date; 
	
	
	public Event(String city, int cost, List<String> activites, LocalDate date) {
		this.city = city;
		this.cost = cost;
		this.activites = activites;
		this.date = date;
	}
	
	
	public String getCity() {
		return this.city;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public List<String> getActivites() {
		return this.activites;	
	}
	
	public LocalDate getDate() {
		return this.date;
	}
}
