package scene;

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
	
	public void switchToMatchingScene() {
		MatchingScene matchingScene = new MatchingScene(this);
		primaryStage.setScene(matchingScene.getScene());
	}
}
