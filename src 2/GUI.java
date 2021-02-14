import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    public static final double WINDOW_WIDTH = 500, WINDOW_HEIGHT = 800;
    private static final float MOOD_INCREMENT_LENGTH = 100, WATER_INCREMENT_LENGTH = 30;
    //Penguin
    private Penguin penguin;
    //Scenes
    Scene activeScene, penguinScene, homeworkScene;
    //Game scene elements
    Label nameLabel, moodLabel;
    Rectangle background;
    ImageView penguinImage;
    Button homeworkButton, waterButton;
    Rectangle moodBar, moodBarBackground, waterBar, waterBarBackground;


    @Override
    //Start method
    public void start(Stage primaryStage) throws Exception {
        //MATTHEW placeholder elements
        penguin = new Penguin();

        primaryStage.setTitle("Club Penguin!");
        initializeHomeworkScene();
        initializeGameScene();
        activeScene = penguinScene;
        primaryStage.setScene(activeScene);
        primaryStage.show();
    }


    //Initializes main scene
    private void initializeGameScene() {
        Pane root = new AnchorPane();
        root.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        background = new Rectangle(WINDOW_WIDTH, WINDOW_HEIGHT, Color.valueOf("#70EFFA"));
        initializeLabels();
        initializeButtons();
        initializePenguinImage();
        initializeMoodBar();
        initializeWaterBar();

        root.getChildren().addAll(penguinImage, nameLabel, moodLabel, homeworkButton, waterButton,
                moodBarBackground, moodBar, waterBarBackground, waterBar);
        penguinScene = new Scene(root);
    }


    //Initializes homework scene
    private void initializeHomeworkScene() {
        Pane root = new AnchorPane();
        root.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        background = new Rectangle(WINDOW_WIDTH, WINDOW_HEIGHT, Color.valueOf("#70EFFA"));

        penguinScene = new Scene(root);
    }


    //Updates the penguin image based on mood
    private void updatePenguinImage()  {
        try {
            //Getting penguin image from file
            InputStream stream = new FileInputStream(penguin.mood.getImagePath());
            Image image = new Image(stream);
            //Setting penguin image
            penguinImage.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updatePenguinMood() {
        moodBar.setHeight(penguin.getMoodLevel() * MOOD_INCREMENT_LENGTH);
        updatePenguinImage();
    }

    public void updatePenguinWater() {
        waterBar.setWidth(penguin.getWaterLevel() * WATER_INCREMENT_LENGTH);
        updatePenguinMood();
    }


    //Helper functions for initializations
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Initializes penguin image
    private void initializePenguinImage() {
        penguinImage = new ImageView();
        penguinImage.setY(100);
        penguinImage.setFitWidth(WINDOW_WIDTH);
        penguinImage.setPreserveRatio(true);
        updatePenguinImage();
    }

    //initializes all label elements (name, mood)
    private void initializeLabels() {
        nameLabel = createLabel(penguin.name, 70, 10);
        nameLabel.setTextFill(Color.BLACK);
        moodLabel = createLabel(penguin.mood.getText(), 30, 80);
    }

    //initializes buttons
    private void initializeButtons() {
        homeworkButton = new Button("Homework");
        AnchorPane.setLeftAnchor(homeworkButton, 10.0);
        AnchorPane.setBottomAnchor(homeworkButton, 30.0);
        homeworkButton.setAlignment(Pos.BOTTOM_LEFT);
        homeworkButton.setOnAction(event -> {
            //primaryStage.setScene(homeworkScene);
        });

        waterButton = new Button("Drink Water");
        AnchorPane.setLeftAnchor(waterButton, 10.0);
        AnchorPane.setBottomAnchor(waterButton, 60.0);
        waterButton.setAlignment(Pos.BOTTOM_LEFT);
        waterButton.setOnAction(event -> {
            penguin.drinkWater();
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

        moodBar = new Rectangle(width, 100, Color.RED);
        AnchorPane.setRightAnchor(moodBar, rightAnchor);
        AnchorPane.setBottomAnchor(moodBar, bottomAnchor);

        moodBarBackground = new Rectangle(width, 5*MOOD_INCREMENT_LENGTH, Color.valueOf("#72EEE2"));
        AnchorPane.setRightAnchor(moodBarBackground, rightAnchor);
        AnchorPane.setBottomAnchor(moodBarBackground, bottomAnchor);

        updatePenguinMood();
    }

    private void initializeWaterBar() {
        double leftAnchor = 140.0, bottomAnchor = 10.0, height = 50;

        waterBar = new Rectangle(penguin.getWaterLevel(), height, Color.BLUE);
        AnchorPane.setLeftAnchor(waterBar, leftAnchor);
        AnchorPane.setBottomAnchor(waterBar, bottomAnchor);

        waterBarBackground = new Rectangle(8*WATER_INCREMENT_LENGTH, height, Color.valueOf("#0DACDA"));
        AnchorPane.setLeftAnchor(waterBarBackground, leftAnchor);
        AnchorPane.setBottomAnchor(waterBarBackground, bottomAnchor);

        updatePenguinWater();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
