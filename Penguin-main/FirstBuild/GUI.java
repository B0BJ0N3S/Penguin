import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class GUI extends Application {
    //Constants
    public static final double WINDOW_WIDTH = 500/1.5, WINDOW_HEIGHT = 800/1.5;
    private static final double MOOD_INCREMENT_LENGTH = 100/1.7, WATER_INCREMENT_LENGTH = 30/1.5;
    //Penguin
    private Penguin penguin;
    //Scenes
    Stage primaryStage;
    Scene penguinScene, homeworkScene;
    //Game scene elements
    Label nameLabel, moodLabel, moodBarLabel, waterBarLabel;
    ImageView penguinImage, background;
    Button homeworkButton, waterButton, resetButton;
    Rectangle moodBar, moodBarBackground, waterBar, waterBarBackground;


    @Override
    //Start method
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        penguin = new Penguin("Pingu");

        primaryStage.setTitle("Club Penguin!");
        initializeHomeworkScene();
        initializeGameScene();
        primaryStage.setScene(penguinScene);
        primaryStage.show();
    }


    //Updates the penguin image based on mood
    private void updatePenguinImage()  {
        try {
            //Getting penguin image from file
            InputStream stream = new FileInputStream(penguin.getMood().getImagePath());
            Image image = new Image(stream);
            //Setting penguin image
            penguinImage.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updatePenguinMood() {
        moodBar.setHeight(penguin.getMoodLevel() * MOOD_INCREMENT_LENGTH);
        moodLabel.setText(penguin.getMood().getText());
        updatePenguinImage();
    }

    public void updatePenguinWater() {
        waterBar.setWidth(penguin.getWaterLevel() * WATER_INCREMENT_LENGTH);
        updatePenguinMood();
    }


    //Helper functions for initializations
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //Initializes main scene
    private void initializeGameScene() {
        Pane root = new AnchorPane();
        root.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        initializeLabels();
        initializeButtons();
        initializePenguinImage();
        initializeBackground();
        initializeMoodBar();
        initializeWaterBar();

        root.getChildren().addAll(background, penguinImage, nameLabel, moodLabel, homeworkButton, waterButton, resetButton,
                moodBarBackground, moodBar, waterBarBackground, waterBar, moodBarLabel, waterBarLabel);
        penguinScene = new Scene(root);
    }



    //Initializes penguin image
    private void initializePenguinImage() {
        penguinImage = new ImageView();
        penguinImage.setY(100);
        penguinImage.setFitWidth(WINDOW_WIDTH);
        penguinImage.setPreserveRatio(true);
        updatePenguinImage();
    }

    private void initializeBackground() {
        background = new ImageView();
        background.setFitWidth(WINDOW_WIDTH);
        background.setPreserveRatio(true);
        try {
            //Getting penguin image from file
            InputStream stream = new FileInputStream("L:/Penguin-main/FirstBuild/Images/Background.PNG");
            Image image = new Image(stream);
            //Setting penguin image
            background.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //initializes all label elements (name, mood)
    private void initializeLabels() {
        nameLabel = createLabel(penguin.getName(), 70, 10);
        nameLabel.setTextFill(Color.BLACK);
        moodLabel = createLabel(penguin.getMood().getText(), 30, 80);
    }

    //initializes buttons
    private void initializeButtons() {
        homeworkButton = new Button("Homework");
        AnchorPane.setLeftAnchor(homeworkButton, 10.0);
        AnchorPane.setBottomAnchor(homeworkButton, 30.0);
        homeworkButton.setAlignment(Pos.BOTTOM_LEFT);
        homeworkButton.setOnAction(event -> {
            primaryStage.setScene(homeworkScene);
        });

        waterButton = new Button("Drink Water");
        AnchorPane.setLeftAnchor(waterButton, 10.0);
        AnchorPane.setBottomAnchor(waterButton, 60.0);
        waterButton.setAlignment(Pos.BOTTOM_LEFT);
        waterButton.setOnAction(event -> {
            penguin.drinkWater();
            updatePenguinWater();
        });

        resetButton = new Button("Reset");
        AnchorPane.setRightAnchor(resetButton, 10.0);
        AnchorPane.setBottomAnchor(resetButton, 30.0);
        resetButton.setAlignment(Pos.BOTTOM_RIGHT);
        resetButton.setOnAction(event -> {
            penguin.reset();
            updatePenguinMood();
            updatePenguinWater();
        });
    }

    //Creates a label with given text, size, and anchor points
    private Label createLabel(String text, float size, double topAnchor) {
        Label label = new Label(text);
        label.setFont(new Font("Times", size));
        label.setTextFill(Color.valueOf("#823b0e"));
        AnchorPane.setLeftAnchor(label, 0.0);
        AnchorPane.setRightAnchor(label, 0.0);
        AnchorPane.setTopAnchor(label, topAnchor);
        label.setAlignment(Pos.CENTER);

        return label;
    }

    private void initializeMoodBar() {
        double rightAnchor = 2.0, bottomAnchor = 80.0, width = 50;

        moodBar = new Rectangle(width, 100, Color.valueOf("0DDACF"));
        AnchorPane.setRightAnchor(moodBar, rightAnchor);
        AnchorPane.setBottomAnchor(moodBar, bottomAnchor);

        moodBarBackground = new Rectangle(width, 5*MOOD_INCREMENT_LENGTH, Color.valueOf("#BBF0ED"));
        AnchorPane.setRightAnchor(moodBarBackground, rightAnchor);
        AnchorPane.setBottomAnchor(moodBarBackground, bottomAnchor);
        
       moodBarLabel = createLabel("Mood Bar", (float) 12, 140);
       moodBarLabel.setAlignment(Pos.TOP_RIGHT);
       moodBarLabel.setTextFill(Color.BLACK);

        updatePenguinMood();
    }

    private void initializeWaterBar() {
        double leftAnchor = 100.0, bottomAnchor = 10.0, height = 30;

        waterBar = new Rectangle(penguin.getWaterLevel(), height, Color.BLUE);
        AnchorPane.setLeftAnchor(waterBar, leftAnchor);
        AnchorPane.setBottomAnchor(waterBar, bottomAnchor);

        waterBarBackground = new Rectangle(8*WATER_INCREMENT_LENGTH, height, Color.valueOf("#0DACDA"));
        AnchorPane.setLeftAnchor(waterBarBackground, leftAnchor);
        AnchorPane.setBottomAnchor(waterBarBackground, bottomAnchor);
        
        waterBarLabel = createLabel("Water Bar", (float) 12, 475);
        waterBarLabel.setTextFill(Color.BLACK);

        updatePenguinWater();
    }






///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
    //Initializes homework scene
    private void initializeHomeworkScene() {
        Pane root = new AnchorPane();
        root.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle background = new Rectangle(WINDOW_WIDTH, WINDOW_HEIGHT, Color.valueOf("#79C2D0"));
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList();
        list.setItems(items);
        list.setPrefWidth(200);
        list.setPrefHeight(200);
        list.setCellFactory(TextFieldListCell.forListView());
        list.setEditable(true);
        
        Button addButton = new Button("Add Homewrok");
        AnchorPane.setLeftAnchor(addButton, 80.0);
        AnchorPane.setBottomAnchor(addButton, 30.0);
        addButton.setOnAction(event -> {
            list.getItems().add("Enter Homework Task");
        });
        
        Button removeButton = new Button("Complete Homework");
        AnchorPane.setLeftAnchor(removeButton, 200.0);
        AnchorPane.setBottomAnchor(removeButton, 30.0);
        removeButton.setOnAction(event -> {
        	int index = list.getSelectionModel().getSelectedIndex();
        	list.getItems().remove(index);
        	penguin.completeHomework(index);
        	primaryStage.setScene(penguinScene);
        	updatePenguinMood();
        });
        
        Button backButton = new Button("Back");
        AnchorPane.setLeftAnchor(backButton, 10.0);
        AnchorPane.setBottomAnchor(backButton, 30.0);
        backButton.setOnAction(event -> {
            primaryStage.setScene(penguinScene);
        });

        root.getChildren().addAll(background, addButton, removeButton, backButton, list);
        homeworkScene = new Scene(root);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
