package scene;

import application.Event;
import application.EventList;
import application.UserList;
import application.UserPersistantData;
import application.UserProfile;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ItineraryScene {

    private SceneManager sceneManager;
    private Event event;
    private UserProfile partner;
    private boolean isMatchFound;

    public ItineraryScene(SceneManager sceneManager, Event event, UserProfile partner) {
        this.sceneManager = sceneManager;
        this.event = event;
        this.partner = partner;
        this.isMatchFound = (partner != null);
    }

    public Scene getScene() {
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20;");

        Label titleLabel = new Label("Itinerary Information");
        titleLabel.setStyle("-fx-font-size: 20; -fx-padding: 10;");
        layout.getChildren().add(titleLabel);

        Label eventInfo = new Label("Event in " + event.getCity());
        Label eventActivities = new Label("Activities: " + String.join(", ", event.getActivites()));
        Label eventDate = new Label("Date: " + event.getDate().toString());
        Label eventCost = new Label("Budget: $" + event.getCost());
        layout.getChildren().addAll(eventInfo, eventActivities, eventDate, eventCost);

        if (isMatchFound) {
            // Display partner information
            Label partnerInfo = new Label("Partner Information");
            Label partnerName = new Label("Name: " + partner.getName());
            Label partnerEmail = new Label("Email: " + partner.getEmail());
            layout.getChildren().addAll(partnerInfo, partnerName, partnerEmail);
        } else {
           
            Label noMatchLabel = new Label("No matching users found for this event.");
            Button chooseAnotherEventButton = new Button("Choose Another Event");
            Button createEventButton = new Button("Create Your Own Event");

            chooseAnotherEventButton.setOnAction(e -> {
                sceneManager.switchToEventScene();
            });

            createEventButton.setOnAction(e -> {
                // Add current event to user's matched events
                UserProfile currentUser = UserList.getUserListInstance()
                        .getUserProfilByEmail(UserPersistantData.getInstance().getEmail());
                currentUser.addMatchedEvent(event);

                // Post this event for others to choose
                EventList.getEventListInstance().addEvent(event);

                // Navigate back to event scene
                sceneManager.switchToEventScene();
            });

            layout.getChildren().addAll(noMatchLabel, chooseAnotherEventButton, createEventButton);
        }
        
        Button profileManageButton = new Button("Go to Profile Management");
        profileManageButton.setOnAction(e -> {
            sceneManager.switchToProfileManageScene();
        });
        layout.getChildren().add(profileManageButton);

        return new Scene(layout, 400, 500);
    }
}
