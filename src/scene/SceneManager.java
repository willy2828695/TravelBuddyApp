package scene;

import application.Event;
import application.UserProfile;
import javafx.stage.Stage;

public class SceneManager {
	
	private Stage primaryStage;
	
	public SceneManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void switchToRegisterScene() {
		RegisterScene registerScene = new RegisterScene(this);
		primaryStage.setScene(registerScene.getScene());
	}
	
	public void switchToProfileScene() {
		ProfileScene profileScene = new ProfileScene(this);
		primaryStage.setScene(profileScene.getScene());
	}
	
	public void switchToEventScene() {
		EventScene eventScene = new EventScene(this);
		primaryStage.setScene(eventScene.getScene());
	}
	
	public void switchToMatchingScene(Event event) {
		MatchingScene matchingScene = new MatchingScene(this, event);
		primaryStage.setScene(matchingScene.getScene());
	}

	public void switchToItineraryScene(Event selectedEvent, UserProfile matchedUser) {
		ItineraryScene itineraryScene = new ItineraryScene(this, selectedEvent, matchedUser);
	    primaryStage.setScene(itineraryScene.getScene());
		
	}
	
	public void switchToProfileManageScene() {
	    ProfileManageScene profileManageScene = new ProfileManageScene(this);
	    primaryStage.setScene(profileManageScene.getScene());
	}

	
}
