package scene;

import java.util.List;
import java.util.Map;

import application.Event;
import application.EventList;
import application.UserList;
import application.UserPersistantData;
import application.UserProfile;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EventScene {
	
	private UserPersistantData userPersistantData = UserPersistantData.getInstance();
	
	private UserList userList = UserList.getUserListInstance();
	
	private SceneManager sceneManager;
	
	public EventScene(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}
	
  	public Scene getScene() {
  		
  		
  		EventList evenList = EventList.getEventListInstance();

  	    VBox root = new VBox(15);
  	    root.setPadding(new Insets(20));
  	    root.setStyle("-fx-background-color: #F5F5F5;");
  	    
  	    Button profileManageButton = new Button("Manage Profile");
        profileManageButton.setOnAction(e -> {
            sceneManager.switchToProfileManageScene();
        });
        root.getChildren().add(profileManageButton);

  	    
  	    UserProfile userProfile = userList.getUserProfilByEmail(userPersistantData.getEmail());
  	    Map<String, Boolean> userInterests = userProfile.getInterest();
  	    
  	    for (Event event : evenList.getEvents()) {
  	    	List<String> activity = event.getActivites();
  	    	for (String a: activity) {
  	    		if (userInterests.get(a)) {
  	    			VBox cityBox = creatEventBox(event);
  	  	    		root.getChildren().add(cityBox);
  	  	    		break;
  	  	    	}
  	    	}
  	    	
  	    }

  	    ScrollPane scrollPane = new ScrollPane(root);
  	    scrollPane.setFitToWidth(true); 
  	    scrollPane.setStyle("-fx-background-color: transparent;");

  	    return new Scene(scrollPane, 450, 600);
    }
  	
  	private VBox creatEventBox(Event event) {
	    VBox cityBox = new VBox(5);
	    cityBox.setStyle("-fx-border-color: #FFA500; -fx-border-width: 2; -fx-border-radius: 5; -fx-background-radius: 5;");
	    cityBox.setPadding(new Insets(10));
	    cityBox.setAlignment(Pos.TOP_LEFT);
	    cityBox.setMinHeight(100); 

	    Text cityText = new Text(event.getCity());
	    cityText.setFont(Font.font("Arial", 18));
	    cityText.setFill(Color.DARKBLUE);

	    cityBox.getChildren().add(cityText);
	    
	    StringBuilder sb = new StringBuilder();
	    for (String activity: event.getActivites()) {
	    	sb.append(activity).append(" ");
	    }


	    Text activityText = new Text(String.format("Activity: %s", sb.toString()));
	    activityText.setFont(Font.font("Arial", 14));
	    activityText.setFill(Color.PURPLE);

	    Text budgetText = new Text(String.format("Budget: %d", event.getCost()));
	    budgetText.setFont(Font.font("Arial", 14));
	    budgetText.setFill(Color.PURPLE);
	    
	    Text dateText = new Text(event.getDate().toString());
	    dateText.setFont(Font.font("Arial", 14));
	    dateText.setFill(Color.PURPLE);

	    cityBox.getChildren().addAll(activityText, budgetText, dateText);


	    Button cityButton = new Button("Explore " + event.getCity());
	    cityButton.setStyle("-fx-font-size: 14px; -fx-background-color: #4CAF50; -fx-text-fill: white;");
	    cityButton.setPrefWidth(200); 
	    cityButton.setPrefHeight(40);
	    cityButton.setMinWidth(150);
	    cityButton.setMaxWidth(250);
	    cityButton.setMinHeight(35);
	    cityButton.setMaxHeight(50);


	    cityButton.setOnAction(e -> {
	    	sceneManager.switchToMatchingScene(event);
	    });


	    cityBox.getChildren().add(cityButton);

	    return cityBox;
	}
}
