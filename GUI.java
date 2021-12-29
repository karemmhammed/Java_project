package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
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
    
    /*****************************/
    /* Flags & Numeric Variables */
    /*****************************/
    
    boolean motorMode;
    boolean motorDirection;
    
    /*********/
    /* Texts */
    /*********/
    Text startText;
    
    /***********/
    /* Buttons */
    /***********/
    
    // Start Button
    Button startButton;
    
    // Back Button
    Button backButton;
    
    // ON/OFF Button
    Button onoffButton;
    
    // Direction1 (Clockwise) Button
    Button dir1Button;
    
    // Direction2 (Anti-Clockwise) Button
    Button dir2Button;
    
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
    
    // ON/OFF Button
    Image onoffButtonImg;
    ImageView onoffButtonImgView;
    
    // Direction1 (Clockwise) Button
    Image dir1ButtonImg;
    ImageView dir1ButtonImgView;
    
    // Direction2 (Anti-Clockwise) Button
    Image dir2ButtonImg;
    ImageView dir2ButtonImgView;
    
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
        
        /*****************************/
        /* Flags & Numeric Variables */
        /*****************************/

        motorMode = false;                  // Motor is initially off
        motorDirection = false;             // Motor is initially operating in Direction1 (Clockwise)
        
        /***********************/
        /* Images & ImageViews */
        /***********************/

        // Background
        startBackgroundImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/startBackground.png"));
        startBackgroundImgView = new ImageView(startBackgroundImg);
        startBackgroundImgView.setFitHeight(1000);
        startBackgroundImgView.setFitWidth(1920);
        
        mainBackgroundImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/mainBackground.png"));
        mainBackgroundImgView = new ImageView(mainBackgroundImg);
        mainBackgroundImgView.setFitHeight(1000);
        mainBackgroundImgView.setFitWidth(1920);
    
        // Symbols
        backButtonImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/backButton.png"));
        backButtonImgView = new ImageView(backButtonImg);
        backButtonImgView.setFitHeight(50);
        backButtonImgView.setFitWidth(50);

        // GIFs 
        startGifImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/startGIF.gif"));
        startGifImgView = new ImageView(startGifImg);
        startGifImgView.setFitHeight(450);
        startGifImgView.setFitWidth(450);
        
        // ON/OFF Button
        onoffButtonImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/onoffButton.png"));
        onoffButtonImgView = new ImageView(onoffButtonImg);
        onoffButtonImgView.setFitHeight(50);
        onoffButtonImgView.setFitWidth(50);
        
        // Direction1 (Clockwise) Button
        dir1ButtonImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/dir1Button.png"));
        dir1ButtonImgView = new ImageView(dir1ButtonImg);
        dir1ButtonImgView.setFitHeight(50);
        dir1ButtonImgView.setFitWidth(50);

        // Direction2 (Anti-Clockwise) Button
        dir2ButtonImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/dir2Button.png"));
        dir2ButtonImgView = new ImageView(dir2ButtonImg);
        dir2ButtonImgView.setFitHeight(50);
        dir2ButtonImgView.setFitWidth(50);
        
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
        onoffButton = new Button();
        onoffButton.setGraphic(onoffButtonImgView);
        onoffButton.setStyle("-fx-background-color: transparent;");
        Glow onoffButtonGlow = new Glow();
        onoffButtonGlow.setLevel(0.9);
        onoffButton.setEffect(onoffButtonGlow);
        onoffButton.setTranslateY(0);
        onoffButton.setTranslateX(-600);
        

        // Direction1 (Clockwise) Button
        dir1Button = new Button();
        dir1Button.setGraphic(dir1ButtonImgView);
        dir1Button.setStyle("-fx-background-color: transparent;");
        Glow dir1ButtonGlow = new Glow();
        dir1ButtonGlow.setLevel(0.9);
        dir1Button.setEffect(dir1ButtonGlow);
        dir1Button.setTranslateY(100);
        dir1Button.setTranslateX(-600);

        // Direction2 (Anti-Clockwise) Button
        dir2Button = new Button();
        dir2Button.setGraphic(dir2ButtonImgView);
        dir2Button.setStyle("-fx-background-color: transparent;");
        Glow dir2ButtonGlow = new Glow();
        dir2ButtonGlow.setLevel(0.9);
        dir2Button.setEffect(dir2ButtonGlow);
        dir2Button.setTranslateY(200);
        dir2Button.setTranslateX(-600);

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
        mainPane.getChildren().add(onoffButton);
        mainPane.getChildren().add(dir1Button);
        mainPane.getChildren().add(dir2Button);

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
        onoffButton.setOnAction((ActionEvent event) -> {
            if(motorMode==false)
            {
                motorMode = true;
            }
            else
            {
                motorMode = false;
            }
        });
        
        // Direction1 (Clockwise) Button
        dir1Button.setOnAction((ActionEvent event) -> {
            if(motorDirection==true)
            {
                motorDirection = false;
            }
            else
            {
                // Do Nothing
            }
        });
        
        // Direction2 (Anti-Clockwise) Button
        dir2Button.setOnAction((ActionEvent event) -> {
            if(motorDirection==false)
            {
                motorDirection = true;
            }
            else
            {
                // Do Nothing
            }
        });
        
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
    /****************************************************************/
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
