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
    public static final double WINDOW_WIDTH = 500, WINDOW_HEIGHT = 800;
    Scene activeScene;
    //Game scene elements
    Label nameLabel, moodLabel;
    Rectangle background;
    ImageView penguinImage;
    Button homeworkButton, socialButton;

    //Game state elements
    PenguinMood mood;
    String name;


    @Override
    //Start method
    public void start(Stage primaryStage) throws Exception {
        //MATTHEW placeholder elements
        mood = PenguinMood.CRYING;
        name = "Pingu";

        primaryStage.setTitle("Club Penguin!");
        initializeGameScene();
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
        Button feedButton = new Button("Feed");

        root.getChildren().addAll(penguinImage, nameLabel, moodLabel, homeworkButton, socialButton, feedButton);
        activeScene = new Scene(root);
    }


    //Updates the penguin image based on mood
    private void updatePenguinImage()  {
        try {
            //Getting penguin image from file
            InputStream stream = new FileInputStream(mood.getImagePath());
            Image image = new Image(stream);
            //Setting penguin image
            penguinImage.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        nameLabel = createLabel(name, 70, 10);
        nameLabel.setTextFill(Color.BLACK);
        moodLabel = createLabel(mood.getText(), 30, 80);
    }

    //initializes buttons
    private void initializeButtons() {
        homeworkButton = new Button("Homework");
        AnchorPane.setLeftAnchor(homeworkButton, 10.0);
        AnchorPane.setBottomAnchor(homeworkButton, 30.0);
        homeworkButton.setAlignment(Pos.BOTTOM_LEFT);

        socialButton = new Button("Social");
        AnchorPane.setLeftAnchor(socialButton, 10.0);
        AnchorPane.setBottomAnchor(socialButton, 60.0);
        socialButton.setAlignment(Pos.BOTTOM_LEFT);
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


    public static void main(String[] args) {
        launch(args);
    }
}
