package application;
	
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import scene.ProfileScene;
import scene.RegisterScene;
import scene.SceneManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	
	private String userEmail;
	
	@Override
	public void start(Stage primaryStage) {
		SceneManager sceneManager = new SceneManager(primaryStage);
		sceneManager.switchToRegisterScene();
        primaryStage.setTitle("Travel Buddy App");
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}



