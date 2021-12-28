package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/********************************************************************
 * Project: Motor Controller
 * Description:
 * 
 * 
 * 
 * Version 1.0
 * @authors Karim Mohammed
 *          Sarah Yasser
 *          Joseph Girgis 
 ********************************************************************/
public class GUI extends Application {
    
    /****************************************************************/
    /******************** Variables Declarations ********************/
    /****************************************************************/
    
    /***********/
    /*  Text   */
    /***********/
    Text startText;
    
    
    /***********/
    /* Buttons */
    /***********/
    
    // Start Button
    Button startButton;
    
    // Back Button
    Button backButton;
    
    // ON/OFF Button
    
    // Direction1 (Clockwise) Button
    
    // Direction2 (Anti-Clockwise) Button
    
    //----------------------------------------------------------------
    
    /**********/
    /* Labels */
    /**********/
    
    // Status Label
    
    //----------------------------------------------------------------
    
    /**********/
    /* Slider */
    /**********/
    
    // Speed Slider
    
    //----------------------------------------------------------------
    
    /***********************/
    /* Images & ImageViews */
    /***********************/
    
    // Background
    Image startBackgroundImg;
    ImageView startBackgroundImgView;
    Image mainBackgroundImg;
    ImageView mainBackgroundImgView;
    
    // Symbols
    Image backButtonImg;
    ImageView backButtonImgView;

    // GIFs 
    Image startGifImg;
    ImageView startGifImgView; 
    //----------------------------------------------------------------
    
    /**************/
    /* Background */
    /**************/
    
    // Background
    
    // BackgroundSize
    
    //----------------------------------------------------------------
    
    /*********/
    /* Panes */
    /*********/
    
    // Start Pane
    StackPane startPane;
    
    // Main Pane
    StackPane mainPane;
    
    //----------------------------------------------------------------
    
    /**********/
    /* Scenes */
    /**********/
    
    // Start Scene
    Scene startScene;
    
    // Main Scene
    Scene mainScene;
    
    //----------------------------------------------------------------
    
    /****************************************************************/
    /************************ Initialization ************************/
    /****************************************************************/
    
    @Override
    public void init() throws FileNotFoundException{
        
        /***********************/
        /* Images & ImageViews */
        /***********************/
        

        // Background
        startBackgroundImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\startBackground.png"));
        startBackgroundImgView = new ImageView(startBackgroundImg);
        startBackgroundImgView.setFitHeight(1000);
        startBackgroundImgView.setFitWidth(1920);
        
        mainBackgroundImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\mainBackground.png"));
        mainBackgroundImgView = new ImageView(mainBackgroundImg);
        mainBackgroundImgView.setFitHeight(1000);
        mainBackgroundImgView.setFitWidth(1920);
    
        // Symbols
        backButtonImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\backButton.png"));
        backButtonImgView = new ImageView(backButtonImg);
        backButtonImgView.setFitHeight(50);
        backButtonImgView.setFitWidth(50);

        // GIFs 
        startGifImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\startGIF.gif"));
        startGifImgView = new ImageView(startGifImg);
        startGifImgView.setFitHeight(450);
        startGifImgView.setFitWidth(450);

        //----------------------------------------------------------------
        
        /***********/
        /* Buttons */
        /***********/
        
        // Start Button
        startButton = new Button();
        startButton.setGraphic(startGifImgView);
        startButton.setStyle("-fx-background-color: transparent;");
        
        // Back Button
        backButton = new Button();
        backButton.setGraphic(backButtonImgView);
        backButton.setStyle("-fx-background-color: transparent;");
        backButton.setTranslateY(450);
        backButton.setTranslateX(-900);
        
     
        // ON/OFF Button

        // Direction1 (Clockwise) Button

        // Direction2 (Anti-Clockwise) Button

        //----------------------------------------------------------------

        /**********/
        /* Labels */
        /**********/
        
        // Start Label
        startText = new Text("Start");
        startText.setFont(Font.font("Verdana", 40));
        startText.setFill(Color.WHITE);

        // Status Label

        //----------------------------------------------------------------

        /**********/
        /* Slider */
        /**********/

        // Speed Slider

        //----------------------------------------------------------------

        /**************/
        /* Background */
        /**************/

        // Background

        // BackgroundSize

        //----------------------------------------------------------------

        /*********/
        /* Panes */
        /*********/

        // Start Pane
        startPane = new StackPane();
        startPane.getChildren().add(startBackgroundImgView);
        startPane.getChildren().add(startText);
        startPane.getChildren().add(startButton);
    
        // Main Pane
        mainPane = new StackPane();
        mainPane.getChildren().add(mainBackgroundImgView);
        mainPane.getChildren().add(backButton);

        //----------------------------------------------------------------
        
        /**********/
        /* Scenes */
        /**********/
        
        // Start Scene
        startScene = new Scene(startPane, 1920, 1000);
        
    
        // Main Scene
        mainScene = new Scene(mainPane, 1920, 1000);
        
        //----------------------------------------------------------------
        
    }
          
    /****************************************************************/
    /************************ Start Function ************************/
    /****************************************************************/
    
    @Override
    public void start(Stage stage) {
        
        /********************/
        /* Buttons Handlers */
        /********************/
        
        // Start Button
        startButton.setOnAction((ActionEvent event) -> {
            stage.setScene(mainScene);
            stage.show();
        });
        
        // Back Button
        backButton.setOnAction((ActionEvent event) -> {
            stage.setScene(startScene);
            stage.show();
        });

        // ON/OFF Button

        // Direction1 (Clockwise) Button

        // Direction2 (Anti-Clockwise) Button
        
        //----------------------------------------------------------------
        
        /******************/
        /* Slider Handler */
        /******************/

        // Speed Slider
        
        //----------------------------------------------------------------
        
        /*****************/
        /* Scene & Stage */
        /*****************/
        stage.setTitle("Motor");
        stage.setResizable(false);
        stage.setScene(startScene);
        stage.show();
        
        
        
        //----------------------------------------------------------------
        
    }

    /****************************************************************/
    /************************ Main Function *************************/
    /**
     * @param args**************************************************************/
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
