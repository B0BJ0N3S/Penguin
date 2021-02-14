//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//
//public class StartUp extends GUI {
////	    Stage primaryStage;
////	    Scene inputScene;
////	    String name;
//	    public static final double WINDOW_WIDTH = 500/1.5, WINDOW_HEIGHT = 800/1.5;
//	    
////	    @Override
////	    public void start(Stage primaryStage) throws Exception {
////	        this.primaryStage = primaryStage;
////	    	primaryStage.setTitle("Club Penguin!");
////	    	initializeStartUpScene();
////	    	initializeInputScene();
////	    	primaryStage.show();
////	    }
//	    
//	    public void initializeStartUpScene() {
//	        Image img = new Image("img/IMG_2518.png");
//	        ImageView view = new ImageView(img);
//	        view.setFitHeight(200);
//	        view.setFitWidth(200);
//	        view.setPreserveRatio(true);
//	        Button startBtn = new Button();
//	        startBtn.setOnAction(e -> {
//	        	primaryStage.setScene(inputScene);
//	        });
//	        startBtn.setTranslateY(-90);
//	        startBtn.setMaxSize(200, 100);
//	        startBtn.setGraphic(view);
//	        
//	        img = new Image("img/IMG_2517.png");
//	        view = new ImageView(img);
//	        view.setFitHeight(200);
//	        view.setFitWidth(200);
//	        view.setPreserveRatio(true);
//	        Button exitBtn = new Button();
//	        exitBtn.setOnAction(e -> {
//	        	((Stage)(((Button)e.getSource()).getScene().getWindow())).close();      	
//	        });
//	        exitBtn.setTranslateY(90);
//	        exitBtn.setMaxSize(200, 100);
//	        exitBtn.setGraphic(view);
//	        
//	        StackPane root = new StackPane();
//	        root.getChildren().add(startBtn);
//	        root.getChildren().add(exitBtn);
//	        primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
//	        primaryStage.show();
//	    }
//	    
//	    public void initializeInputScene() {
//	    	GridPane root = new GridPane();
//	        root.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//	        
//	        Label msg = new Label("What is the name of your penguin?");
//	        msg.setFont(new Font("Times", 20));
//	        TextField b = new TextField();
//	        Button bnt = new Button("Submit");
//	        bnt.setOnAction(e -> {
//	        	penguin.setName(b.getText());
//	        	System.out.println("Welcome " + penguin.getName() + "!");
//	        	primaryStage.setScene(penguinScene);
//	        });
//	        bnt.setMaxSize(300,300);
//	        
//	        root.addRow(0, msg);
//	        root.addRow(1, b);
//	        root.addRow(2, bnt);
//	        inputScene = new Scene(root);
//	    } 
//}