package scene;

import application.Event;
import application.UserList;
import application.UserPersistantData;
import application.UserProfile;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ProfileManageScene {

    private SceneManager sceneManager;
    private UserProfile currentUser;

    public ProfileManageScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.currentUser = UserList.getUserListInstance()
                .getUserProfilByEmail(UserPersistantData.getInstance().getEmail());
    }

    public Scene getScene() {
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20));

        Label titleLabel = new Label("Profile Management");
        titleLabel.setStyle("-fx-font-size: 20; -fx-padding: 10;");

        // Display user's matched events
        Label matchedEventsLabel = new Label("Your Matched Events:");
        ListView<String> eventsListView = new ListView<>();
        for (Event event : currentUser.getMatchedEvents()) {
            eventsListView.getItems().add(event.getCity() + " on " + event.getDate());
        }

        // Display user's matched partners
        Label matchedPartnersLabel = new Label("Your Matched Partners:");
        ListView<String> partnersListView = new ListView<>();
        for (UserProfile partner : currentUser.getMatchedPartners()) {
            partnersListView.getItems().add(partner.getName() + " (" + partner.getEmail() + ")");
        }

        // Update interests and budget
        Label budgetLabel = new Label("Your Budget:");
        TextField budgetField = new TextField(String.valueOf(currentUser.getBudget()));

        Button updateBudgetButton = new Button("Update Budget");
        updateBudgetButton.setOnAction(e -> {
            int newBudget = Integer.parseInt(budgetField.getText());
            currentUser.setBudget(newBudget);
        });

        Button updateInterestsButton = new Button("Update Interests");
        updateInterestsButton.setOnAction(e -> {
            sceneManager.switchToProfileScene(); 
        });

        // Back button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            sceneManager.switchToEventScene();
        });

        layout.getChildren().addAll(titleLabel, matchedEventsLabel, eventsListView,
                matchedPartnersLabel, partnersListView, budgetLabel, budgetField,
                updateBudgetButton, updateInterestsButton, backButton);

        return new Scene(layout, 400, 600);
    }
}
