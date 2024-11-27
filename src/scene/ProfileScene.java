package scene;

import java.util.ArrayList;
import java.util.List;

import application.UserList;
import application.UserPersistantData;
import application.UserProfile;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProfileScene {
	
	private List<String> interests = new ArrayList<>();
	
	private StringBuilder selectedItems;
	
	private SceneManager sceneManger;
	
	
	public ProfileScene(SceneManager sceneManger) {
		this.sceneManger = sceneManger;
	}
	
	public Scene getScene() {
		Label nameLabel = new Label("Name:");
		TextField nameField = new TextField();
      
		Label budgetLabel = new Label("Budget:");
        TextField budgetField = new TextField();
        budgetField.setPromptText("Enter your budget (integer only)");
        budgetField.setStyle("-fx-prompt-text-fill: gray;");

        budgetField.setTextFormatter(new TextFormatter<>(change -> 
        	change.getControlNewText().matches("\\d*") ? change : null
        ));
		
		List<String> activityNames = new ArrayList<>();
        activityNames.add("Hiking");
        activityNames.add("Camping");
        activityNames.add("Rock Climbing");
        activityNames.add("Kayaking/Canoeing");
        activityNames.add("Scuba Diving");
        activityNames.add("Cycling");
        activityNames.add("Running/Jogging");
        activityNames.add("Photography");
        activityNames.add("Stargazing");
        activityNames.add("Birdwatching");
        activityNames.add("Fishing");
        activityNames.add("Group BBQ/Grilling");
        activityNames.add("Outdoor Yoga Classes");
        activityNames.add("Skiing/Snowboarding");
        activityNames.add("Ice Skating");
        activityNames.add("Cherry Blossom Viewing");
        activityNames.add("Autumn Leaf Walks");
        activityNames.add("Pet Outing");
        activityNames.add("Outdoor Board Games");
        activityNames.add("Biking Trails");
 
        Button dropdownButton = new Button("Select Activities");
 
        VBox dropdownList = new VBox(5);
        
        dropdownList.setStyle("-fx-border-color: gray; -fx-padding: 5;");
        dropdownList.setVisible(false);
 
        List<CheckBox> checkBoxes = new ArrayList<>();
        for (String activityName : activityNames) {
            CheckBox checkBox = new CheckBox(activityName);
            checkBoxes.add(checkBox);
            dropdownList.getChildren().add(checkBox);
        }
 
        Button doneButton = new Button("Done");
        dropdownList.getChildren().add(doneButton);

 
        doneButton.setOnAction(event -> {
            dropdownList.setVisible(false);
 
            selectedItems = new StringBuilder("Selected activities: ");
            boolean atLeastOneSelected = false;
 
            for (CheckBox checkBox : checkBoxes) {
                if (checkBox.isSelected()) {
                    selectedItems.append(checkBox.getText());
                    interests.add(checkBox.getText());
                    atLeastOneSelected = true;
                }
            }
        });
 
        dropdownButton.setOnAction(event -> {
            dropdownList.setVisible(!dropdownList.isVisible());
        });
 
        VBox mainLayout = new VBox(10);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setStyle("-fx-padding: 10;");
 
        StackPane dropdownPane = new StackPane();
        dropdownPane.setAlignment(Pos.TOP_CENTER);
        dropdownPane.getChildren().addAll(dropdownButton, dropdownList);
        
        Button nextButton = new Button("next");
        Button backButton = new Button("back");
        
        nextButton.setOnAction(e -> {
        	UserPersistantData userPersistantData = UserPersistantData.getInstance();
        	UserList userList = UserList.getUserListInstance();
        	UserProfile userProfile = userList.getUserProfilByEmail(userPersistantData.getEmail());
        	String name = nameField.getText();
        	int budget = Integer.parseInt(budgetField.getText());
        	userProfile.setInterest(interests);
        	userProfile.setBudget(budget);
        	userProfile.setName(name);
        	sceneManger.switchToEventScene();
        	
        });
        
//        backButton.setOnAction(e -> {
//        	sceneManger.switchToRegisterScene();
//        });
        
       
        mainLayout.getChildren().addAll(nameLabel, nameField, budgetLabel, budgetField, dropdownPane, nextButton, backButton);
 
        Scene scene = new Scene(mainLayout, 400, 400);
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            if (dropdownList.isVisible()) {
                double x = event.getSceneX();
                double y = event.getSceneY();
                if (!isInsideNode(dropdownList, x, y) && !isInsideNode(dropdownButton, x, y)) {
                    dropdownList.setVisible(false);
                }
            }
        });        
        return scene;
    }
	
	private boolean isInsideNode(Region node, double x, double y) {
        double nodeMinX = node.localToScene(node.getBoundsInLocal()).getMinX();
        double nodeMaxX = node.localToScene(node.getBoundsInLocal()).getMaxX();
        double nodeMinY = node.localToScene(node.getBoundsInLocal()).getMinY();
        double nodeMaxY = node.localToScene(node.getBoundsInLocal()).getMaxY();
 
        return x >= nodeMinX && x <= nodeMaxX && y >= nodeMinY && y <= nodeMaxY;
    }

}
