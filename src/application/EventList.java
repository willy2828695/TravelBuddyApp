package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventList {
	
	private List<Event> events = new ArrayList<>();;
	
	private static EventList eventListInstance;
	
	private EventList() {
		events.add(new Event("New York", 200, Arrays.asList("Hiking", "Photography"), LocalDate.of(2024, 11, 5)));
        events.add(new Event("Los Angeles", 300, Arrays.asList("Camping", "Stargazing"), LocalDate.of(2024, 11, 10)));
        events.add(new Event("San Francisco", 400, Arrays.asList("Rock Climbing", "Kayaking/Canoeing"), LocalDate.of(2024, 11, 15)));
        events.add(new Event("Seattle", 250, Arrays.asList("Scuba Diving", "Cycling"), LocalDate.of(2024, 11, 20)));
        events.add(new Event("Chicago", 150, Arrays.asList("Fishing", "Group BBQ/Grilling"), LocalDate.of(2024, 11, 25)));
        events.add(new Event("Miami", 500, Arrays.asList("Outdoor Yoga Classes", "Autumn Leaf Walks"), LocalDate.of(2024, 12, 1)));
        events.add(new Event("Boston", 350, Arrays.asList("Ice Skating", "Cherry Blossom Viewing"), LocalDate.of(2024, 12, 5)));
        events.add(new Event("Austin", 400, Arrays.asList("Skiing/Snowboarding", "Pet Outing"), LocalDate.of(2024, 12, 10)));
        events.add(new Event("Denver", 200, Arrays.asList("Hiking", "Birdwatching"), LocalDate.of(2024, 12, 15)));
        events.add(new Event("Phoenix", 250, Arrays.asList("Camping", "Outdoor Board Games"), LocalDate.of(2024, 12, 20)));
        events.add(new Event("Las Vegas", 300, Arrays.asList("Rock Climbing", "Running/Jogging"), LocalDate.of(2025, 1, 5)));
        events.add(new Event("Portland", 180, Arrays.asList("Kayaking/Canoeing", "Biking Trails"), LocalDate.of(2025, 1, 10)));
        events.add(new Event("San Diego", 450, Arrays.asList("Scuba Diving", "Stargazing"), LocalDate.of(2025, 1, 15)));
        events.add(new Event("Dallas", 230, Arrays.asList("Cycling", "Fishing"), LocalDate.of(2025, 1, 20)));
        events.add(new Event("Atlanta", 280, Arrays.asList("Group BBQ/Grilling", "Photography"), LocalDate.of(2025, 2, 1)));
        events.add(new Event("Orlando", 600, Arrays.asList("Outdoor Yoga Classes", "Birdwatching"), LocalDate.of(2025, 2, 5)));
        events.add(new Event("Houston", 320, Arrays.asList("Cherry Blossom Viewing", "Pet Outing"), LocalDate.of(2025, 2, 10)));
        events.add(new Event("Philadelphia", 220, Arrays.asList("Skiing/Snowboarding", "Autumn Leaf Walks"), LocalDate.of(2025, 2, 15)));
        events.add(new Event("Nashville", 180, Arrays.asList("Ice Skating", "Biking Trails"), LocalDate.of(2025, 2, 20)));
        events.add(new Event("Salt Lake City", 330, Arrays.asList("Hiking", "Stargazing"), LocalDate.of(2025, 3, 1)));
        events.add(new Event("Charlotte", 280, Arrays.asList("Camping", "Running/Jogging"), LocalDate.of(2025, 3, 5)));
        events.add(new Event("San Antonio", 420, Arrays.asList("Rock Climbing", "Fishing"), LocalDate.of(2025, 3, 10)));
        events.add(new Event("Tampa", 260, Arrays.asList("Kayaking/Canoeing", "Outdoor Board Games"), LocalDate.of(2025, 3, 15)));
        events.add(new Event("Minneapolis", 500, Arrays.asList("Scuba Diving", "Birdwatching"), LocalDate.of(2025, 3, 20)));
        events.add(new Event("Detroit", 300, Arrays.asList("Cycling", "Photography"), LocalDate.of(2025, 3, 25)));
	}
	
	public static EventList getEventListInstance() {
		if (eventListInstance == null) {
			return eventListInstance = new EventList();
		}
		return eventListInstance;
	}
	
	
	public void addEvent(Event event) {
		events.add(event);
	}
	
	public List<Event> getEvents() {
		return events;
	}
}
