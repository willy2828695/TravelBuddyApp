package scene;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import application.Event;
import application.EventList;
import application.UserList;
import application.UserPersistantData;
import application.UserProfile;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MatchingScene {
	
	private SceneManager sceneManger;
	
	private UserPersistantData userPersistantData = UserPersistantData.getInstance();
	
	private UserList userList = UserList.getUserListInstance();
	
	private EventList evenList = EventList.getEventListInstance();
	
	private Set<UserProfile> userSet = new HashSet<>();
	
	private List<UserProfile> userListDisplay = new ArrayList<>();
	
	private Event selectedEvent; 
	
	private int currentIndex = 0;
	
	
	public MatchingScene(SceneManager sceneManger, Event selectedEvent) {
		this.sceneManger = sceneManger;
		this.selectedEvent = selectedEvent;
	}
	
	public Scene getScene() {
		UserProfile userProfile = userList.getUserProfilByEmail(userPersistantData.getEmail());
        Set<UserProfile> userSet = filter(userProfile, userList);    
       
        userListDisplay = new ArrayList<>(userSet);
        
        Label profileLabel = new Label("User Profile");
        profileLabel.setStyle("-fx-font-size: 16; -fx-padding: 10;");
        Label nameDisplay = new Label("Name: " + userListDisplay.get(currentIndex).getName());

        Map<String, Boolean> interests = userListDisplay.get(currentIndex).getInterest();
        String trueInterests = interests.entrySet().stream()
            .filter(Map.Entry::getValue) 
            .map(Map.Entry::getKey) 
            .collect(Collectors.joining(", "));
        
        Label interestDisplay = new Label("Interest: " + trueInterests);
        
        VBox profileBox = new VBox(10, profileLabel, nameDisplay, interestDisplay);
        profileBox.setAlignment(Pos.CENTER);
        profileBox.setStyle("-fx-border-color: lightgray; -fx-border-width: 2; -fx-padding: 20;");
        
        // Buttons (✔ and ✘)
        Button tickButton = new Button("✔");
        tickButton.setStyle("-fx-font-size: 18; -fx-background-color: lightgreen;");
        Button crossButton = new Button("✘");
        crossButton.setStyle("-fx-font-size: 18; -fx-background-color: lightcoral;");
        
        HBox buttonBox = new HBox(20, crossButton, tickButton);
        buttonBox.setAlignment(Pos.CENTER);
        
        VBox layout = new VBox(20, profileBox, buttonBox);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 30; -fx-background-color: #f5f5f5;");
        
        tickButton.setOnAction(e -> {
            UserProfile matchedUser = userListDisplay.get(currentIndex);
            UserProfile currentUser = userList.getUserProfilByEmail(userPersistantData.getEmail());

            
            currentUser.addMatchedEvent(selectedEvent);
            currentUser.addMatchedPartner(matchedUser);

            
            sceneManger.switchToItineraryScene(selectedEvent, matchedUser);

        });

//        crossButton.setOnAction(e -> {
//            currentIndex = (currentIndex + 1) % userListDisplay.size();
//            UserProfile nextUser = userListDisplay.get(currentIndex);
//
//            nameDisplay.setText("Name: " + nextUser.getName());
//
//            Map<String, Boolean> nextUserInterests = nextUser.getInterest();
//            String nextUserTrueInterests = nextUserInterests.entrySet().stream()
//                .filter(Map.Entry::getValue) 
//                .map(Map.Entry::getKey)
//                .collect(Collectors.joining(", "));
//
//            interestDisplay.setText("Interest: " + nextUserTrueInterests);
//        });
        
//        end the loop, if we have no matched partner
        crossButton.setOnAction(e -> {
            userListDisplay.remove(currentIndex);
            if (userListDisplay.isEmpty()) {
                Label noMoreUsersLabel = new Label("No more users to show.");
                sceneManger.switchToItineraryScene(selectedEvent, null);
              
                layout.getChildren().clear();
                layout.getChildren().add(noMoreUsersLabel);
            } else {
                currentIndex = currentIndex % userListDisplay.size();
                UserProfile nextUser = userListDisplay.get(currentIndex);

                nameDisplay.setText("Name: " + nextUser.getName());

                Map<String, Boolean> nextUserInterests = nextUser.getInterest();
                String nextUserTrueInterests = nextUserInterests.entrySet().stream()
                    .filter(Map.Entry::getValue)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.joining(", "));

                interestDisplay.setText("Interest: " + nextUserTrueInterests);
            }
        });

        return new Scene(layout, 400, 400);
	}
	
	
	private Set<UserProfile> filter(UserProfile userProfile, UserList userList) {
		for (Event event : evenList.getEvents()) {
			List<String> activity = event.getActivites();
	  	    for (String a: activity) {
	  	    	if (userProfile.getInterest().get(a)) {
	  	    		for (UserProfile u: userList.getUserProfiles()) {
	  	    			if (u.getInterest().get(a) && !u.getEmail().equals(userProfile.getEmail())) {
	  	    				userSet.add(u);
	  	    			}
	  	    		}  		
	  	  	    }
	  	    }
	  	   	
	  	}
		return userSet;
	}
}
