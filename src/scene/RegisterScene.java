package scene;


import application.UserList;
import application.UserPersistantData;
import application.UserProfile;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterScene {
	
	private SceneManager sceneManager;
	
	public RegisterScene(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}
	
	public Scene getScene() {
		UserList userList = UserList.getUserListInstance();
	
		Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();
        
        Button nextButton = new Button("next");
        
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(emailLabel, emailField, passwordLabel, passwordField, nextButton);
        vbox.setAlignment(javafx.geometry.Pos.CENTER); // Center all elements
        
        nextButton.setOnAction(event -> {
        	String email = emailField.getText();
        	String password = passwordField.getText();
        	
        	if (!userList.isUserExist(email, password)) {
        		// TODO display user has already exists
        	} else {
        		UserPersistantData userPersistantData = UserPersistantData.getInstance();
        		UserProfile userProfile = new UserProfile();
            	userProfile.setEmail(email);
            	userProfile.setpassword(password);
            	userList.addUser(userProfile);
            	userPersistantData.setEmail(email);
            	sceneManager.switchToProfileScene();
        	}
        });
        
        return new Scene(vbox, 400, 400);
    }
}
