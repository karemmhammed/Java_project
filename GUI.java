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


package gui;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.skins.ModernSkin;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GUI extends Application {
    
    /****************************************************************/
    /******************** Variables Declarations ********************/
    /****************************************************************/
    
    /*****************************/
    /* Flags & Numeric Variables */
    /*****************************/
    
    boolean motorMode;
    boolean motorDirection;
    boolean Flag_Mute;
    boolean mediaFlag=true;
    int motorSpeed;
    int sliderSpeed;
    private double warningSignOpacity = 0.5;
    
         
	
	
    /***********/
    /*  Music  */
    /***********/
    String uriString1;
    MediaPlayer player1;
    String uriString2;
    MediaPlayer player2;
    String uriString3;
    MediaPlayer player3;
    
    
    /***********/
    /*  Menu  */
    /***********/
    MenuBar bar ;
    Menu settings ;
    Menu file ;
    MenuItem exit ;
    MenuItem About;
    MenuItem sound ;
    MenuItem sound1 ;
    
    
    
    /*********/
    /* Texts */
    /*********/
    Text startText;
    Text aboutText;
    Text aboutTextInLabel;
    Text title;
    Text greetingText;
    
    /***********/
    /* Buttons */
    /***********/
    
    // Start Button
    Button startButton;
    
    // Back Button
    Button backButton;
    Button backButton2;
    
    // About Button
    Button aboutButton;
    
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
    Label speedLabel;
    
    // Direction Status Label
    Label dirStatusLabel;
    
    // ON/OFF Status Label
    Label onoffStatusLabel;
    
    //----------------------------------------------------------------
    
    /**********/
    /* Slider */
    /**********/
    
    // Speed Slider
    Slider speedSlider;
    
    //----------------------------------------------------------------
    
    /***********************/
    /*       Gauge       */
    /***********************/
   
    Gauge gauge;        
    
    //----------------------------------------------------------------
    
    /***********************/
    /*       Effects       */
    /***********************/
    
    Glow glow;
        
    //----------------------------------------------------------------
    
    /***********************/
    /* Images & ImageViews */
    /***********************/
    
    // Background
    Image startBackgroundImg;
    ImageView startBackgroundImgView;
    ImageView startBackgroundImgView2;
    Image mainBackgroundImg;
    ImageView mainBackgroundImgView;
    
    // Symbols
    Image backButtonImg;
    Image backButtonImg2;
    ImageView backButtonImgView;
    ImageView backButtonImgView2;
    
    Image iconImg;
    
    Image warningImg;
    ImageView warningImgView;
    
    Image wheelImg;
    ImageView wheelImgView;

    // GIFs 
    Image startGifImg;
    ImageView startGifImgView; 
    ImageView startGifImgView2;
    
    Image greetingGifImg;
    ImageView greetingGifImgView;
    
    // About Text Label
    Image aboutTextLabel;
    ImageView aboutTextLabelView;
    
    // ON/OFF Button
    Image onoffButtonImg;
    ImageView onoffButtonImgView;
    
    // Direction1 (Clockwise) Button
    Image dir1ButtonImg;
    ImageView dir1ButtonImgView;
    
    // Direction2 (Anti-Clockwise) Button
    Image dir2ButtonImg;
    ImageView dir2ButtonImgView;
    
    // Direction Status Label
    Image dirStatusLabelImg;
    ImageView dirStatusLabelImgView;
    
    // ON/OFF Status Label
    Image onoffStatusLabelImg;
    ImageView onoffStatusLabelImgView;
    
    // Warning Label
    Image warningLabelImg;
    ImageView warningLabelImgView;
    
    // Wheel Label
    Image wheelLabelImg;
    ImageView wheelLabelImgView;
    
    //----------------------------------------------------------------
    
    /**************/
    /* Animations */
    /**************/
    
    // Wheel Rotation
    RotateTransition wheelRotate;
    
    // Direction1 Button Rotation
    RotateTransition directionRotate1;
    
    // Direction2 Button Rotation
    RotateTransition directionRotate2;
    
    // Opacity Animation
    AnimationTimer timer;
    
    //----------------------------------------------------------------
    
    /*********/
    /* Panes */
    /*********/
    
    // Start Pane
    StackPane startPane;
    
    // Main Pane
    StackPane mainPane;
    
    // About Pane
    StackPane aboutPane;
    
    //----------------------------------------------------------------
    
    /**********/
    /* Scenes */
    /**********/
    
    // Start Scene
    Scene startScene;
    
    // Main Scene
    Scene mainScene;
    
    // About Scene
    Scene aboutScene;
    
    //----------------------------------------------------------------
    
    // Connection class
    Connect connection;
    
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
        motorSpeed = 0;                     
        sliderSpeed = 0;
        
	/***********/
        /* Music*/
        /***********/
        uriString2 = new File("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Music/anti.mp3").toURI().toString();
        player2 = new MediaPlayer(new Media(uriString2));
       
        uriString3 = new File("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Music/clockwise.mp3").toURI().toString();
        player3 = new MediaPlayer(new Media(uriString3));
       
        uriString1 = new File("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Music/speed2.mp3").toURI().toString();
        player1 = new MediaPlayer(new Media(uriString1));
		
   
      
        //----------------------------------------------------------------
         
        /***********************/
        /*       Effects       */
        /***********************/
        
        // Glow
        glow = new Glow(3);
        
        //----------------------------------------------------------------
        
        /***********************/
        /*       Gauge       */
        /***********************/
        
        gauge = new Gauge();
        gauge.setSkin(new ModernSkin(gauge));  
        gauge.setUnit("Rpm");  //unit
        gauge.setUnitColor(Color.WHITE);
        gauge.setValueVisible(false);
        gauge.setBarColor(Color.rgb(7, 137, 191));
        gauge.setNeedleColor(Color.rgb(194, 1, 54));
        gauge.setThresholdColor(Color.rgb(194, 1, 54)); 
        gauge.setThreshold(85);
        gauge.setThresholdVisible(true);
        gauge.setTickLabelColor(Color.WHITE);
        gauge.setTickMarkColor(Color.WHITE);
        gauge.setMaxSize(500, 500);

        //----------------------------------------------------------------
        
        /***********/
        /*   menu  */
        /***********/
        bar = new MenuBar();
        settings = new Menu("Settings");
        file = new Menu("File");
        exit = new MenuItem("Exit");
        About = new MenuItem("About");
        sound = new MenuItem("Mute sound");
        sound1 = new MenuItem("UnMute sound");
	settings.getItems().addAll(sound,sound1);
        file.getItems().addAll(exit,About);
        bar.getMenus().addAll(settings,file);
        bar.setTranslateY(-485);
        bar.setTranslateX(0);
        
        /***********************/
        /* Images & ImageViews */
        /***********************/

        // Background
        startBackgroundImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/startBackground.png"));
        startBackgroundImgView = new ImageView(startBackgroundImg);
        startBackgroundImgView.setFitHeight(1000);
        startBackgroundImgView.setFitWidth(1920);
        
        startBackgroundImgView2 = new ImageView(startBackgroundImg);
        startBackgroundImgView2.setFitHeight(1000);
        startBackgroundImgView2.setFitWidth(1920);
             
        mainBackgroundImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/mainBackground.png"));
        mainBackgroundImgView = new ImageView(mainBackgroundImg);
        mainBackgroundImgView.setFitHeight(1000);
        mainBackgroundImgView.setFitWidth(1920);
    
        // Symbols
        backButtonImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/backButton.png"));
        backButtonImgView = new ImageView(backButtonImg);
        backButtonImgView.setFitHeight(50);
        backButtonImgView.setFitWidth(50);
        
        backButtonImg2 = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/backButton.png"));
        backButtonImgView2 = new ImageView(backButtonImg);
        backButtonImgView2.setFitHeight(50);
        backButtonImgView2.setFitWidth(50);
        
        iconImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/Icon.png"));

        warningImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/warning.png"));
        warningImgView = new ImageView(warningImg);
        warningImgView.opacityProperty().set(warningSignOpacity);
        warningImgView.setFitHeight(135);
        warningImgView.setFitWidth(135);
        warningImgView.setTranslateX(588);
        warningImgView.setTranslateY(-145);
        
        wheelImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/wheel.png"));
        wheelImgView = new ImageView(wheelImg);
        wheelImgView.setTranslateX(588);
        wheelImgView.setTranslateY(128);
        wheelImgView.setFitHeight(140);
        wheelImgView.setFitWidth(140);
        wheelRotate = new RotateTransition();
        wheelRotate.setAxis(Rotate.Z_AXIS);
        wheelRotate.setByAngle(360);
        wheelRotate.setCycleCount(Integer.MAX_VALUE);
        wheelRotate.setRate(0.2);
        wheelRotate.setDuration(Duration.INDEFINITE);
        wheelRotate.setNode(wheelImgView);

        // GIFs 
        startGifImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/startGIF.gif"));
        startGifImgView = new ImageView(startGifImg);
        startGifImgView.setFitHeight(450);
        startGifImgView.setFitWidth(450);
        startGifImgView.setEffect(glow);
        
        startGifImgView2 = new ImageView(startGifImg);
        startGifImgView2.setFitHeight(350);
        startGifImgView2.setFitWidth(350);
        startGifImgView2.setTranslateX(200);
        startGifImgView2.setTranslateY(260);
        startGifImgView2.setEffect(glow);
        
        greetingGifImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/greeting.gif"));
        greetingGifImgView = new ImageView(greetingGifImg);
        
        // About Text Label
        aboutTextLabel = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/main.png"));
        aboutTextLabelView = new ImageView(aboutTextLabel);
        aboutTextLabelView.setFitHeight(700);
        aboutTextLabelView.setFitWidth(700);
        aboutTextLabelView.setEffect(glow);
        
        
        // ON/OFF Button
        onoffButtonImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/onoffButton.png"));
        onoffButtonImgView = new ImageView(onoffButtonImg);
        onoffButtonImgView.setFitHeight(40);
        onoffButtonImgView.setFitWidth(40);
        
        // Direction1 (Clockwise) Button
        dir1ButtonImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/dir1Button.png"));
        dir1ButtonImgView = new ImageView(dir1ButtonImg);
        dir1ButtonImgView.setFitHeight(40);
        dir1ButtonImgView.setFitWidth(40);

        // Direction2 (Anti-Clockwise) Button
        dir2ButtonImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/dir2Button.png"));
        dir2ButtonImgView = new ImageView(dir2ButtonImg);
        dir2ButtonImgView.setFitHeight(40);
        dir2ButtonImgView.setFitWidth(40);
        
        // Direction Status Label
        dirStatusLabelImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/directionStatusLabel.png"));
        dirStatusLabelImgView = new ImageView(dirStatusLabelImg);
        dirStatusLabelImgView.setFitHeight(230);
        dirStatusLabelImgView.setFitWidth(500);
        dirStatusLabelImgView.setTranslateX(-650);
        dirStatusLabelImgView.setTranslateY(-150);
        
        // ON/OFF Status Label
        onoffStatusLabelImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/onoffStatusLabel.png"));
        onoffStatusLabelImgView = new ImageView(onoffStatusLabelImg);
        onoffStatusLabelImgView.setFitHeight(300);
        onoffStatusLabelImgView.setFitWidth(300);
        onoffStatusLabelImgView.setTranslateX(-650);
        onoffStatusLabelImgView.setTranslateY(125);
        
        // Warning Label
        warningLabelImg = new Image(new FileInputStream("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Images/warningLabel.png"));
        warningLabelImgView = new ImageView(warningLabelImg);
        warningLabelImgView.setFitHeight(230);
        warningLabelImgView.setFitWidth(500);
        warningLabelImgView.setTranslateX(580);
        warningLabelImgView.setTranslateY(-150);
        
        // Wheel Label
        wheelLabelImgView = new ImageView(warningLabelImg);
        wheelLabelImgView.setFitHeight(230);
        wheelLabelImgView.setFitWidth(500);
        wheelLabelImgView.setTranslateX(580);
        wheelLabelImgView.setTranslateY(125);
        
        
        //----------------------------------------------------------------
        
        /***********/
        /* Buttons */
        /***********/
        
        // Start Button
        startButton = new Button();
        startButton.setGraphic(startGifImgView);
        startButton.setStyle("-fx-background-color: transparent;");
        startButton.setEffect(glow);
        startButton.setTranslateX(-250);
        startButton.setTranslateY(-70);
        
        // Back Button
        backButton = new Button();
        backButton.setGraphic(backButtonImgView);
        backButton.setStyle("-fx-background-color: transparent;");
        backButton.setTranslateY(450);
        backButton.setTranslateX(-900);
        
        // Back Button 2
        backButton2 = new Button();
        backButton2.setGraphic(backButtonImgView2);
        backButton2.setStyle("-fx-background-color: transparent;");
        backButton2.setTranslateY(450);
        backButton2.setTranslateX(-900);
        
        // About Button
        aboutButton = new Button();
        aboutButton.setGraphic(startGifImgView2);
        aboutButton.setStyle("-fx-background-color: transparent;");
        aboutButton.setEffect(glow);
        
        // ON/OFF Button
        onoffButton = new Button();
        onoffButton.setGraphic(onoffButtonImgView);
        onoffButton.setStyle("-fx-background-color: transparent;");
        Glow onoffButtonGlow = new Glow();
        onoffButtonGlow.setLevel(0.9);
        onoffButton.setEffect(onoffButtonGlow);
        onoffButton.setTranslateY(253);
        onoffButton.setTranslateX(-662);
        

        // Direction1 (Clockwise) Button
        dir1Button = new Button();
        dir1Button.setGraphic(dir1ButtonImgView);
        dir1Button.setStyle("-fx-background-color: transparent;");
        Glow dir1ButtonGlow = new Glow();
        dir1ButtonGlow.setLevel(0.9);
        directionRotate1 = new RotateTransition();
        directionRotate1.setAxis(Rotate.Z_AXIS);
        directionRotate1.setByAngle(360); 
        directionRotate1.setCycleCount(500);
        directionRotate1.setDuration(Duration.INDEFINITE);
        directionRotate1.setNode(dir1Button);
        dir1Button.setEffect(dir1ButtonGlow);
        dir1Button.setTranslateY(-182);
        dir1Button.setTranslateX(-885);

        // Direction2 (Anti-Clockwise) Button
        dir2Button = new Button();
        dir2Button.setGraphic(dir2ButtonImgView);
        dir2Button.setStyle("-fx-background-color: transparent;");
        Glow dir2ButtonGlow = new Glow();
        dir2ButtonGlow.setLevel(0.9);
        directionRotate2 = new RotateTransition();
        directionRotate2.setAxis(Rotate.Z_AXIS);
        directionRotate2.setByAngle(-360); 
        directionRotate2.setCycleCount(500);
        directionRotate2.setDuration(Duration.INDEFINITE);
        directionRotate2.setNode(dir2Button);
        dir2Button.setEffect(dir2ButtonGlow);
        dir2Button.setTranslateY(-116);
        dir2Button.setTranslateX(-415);

        //----------------------------------------------------------------
        
        /*********/
        /* Texts */
        /*********/
        
        // Greeting Text
        greetingText = new Text("... Click Anywhere to Skip ...");
        greetingText.setFont(Font.font("Verdana", 20));
        greetingText.setFill(Color.WHITE);
        greetingText.setTranslateY(450);
        greetingText.setTranslateX(45);
        
        // Start Text
        startText = new Text("Start");
        startText.setFont(Font.font("Verdana", 40));
        startText.setFill(Color.WHITE);
        startText.setTranslateX(-250);
        startText.setTranslateY(-70);
        
        
        // About Text
        aboutText = new Text("ABOUT");
        aboutText.setFont(Font.font("Verdana", 20));
        aboutText.setFill(Color.WHITE);
        aboutText.setTranslateX(200);
        aboutText.setTranslateY(260);
        
        // About Text Inside The Label
        aboutTextInLabel = new Text("Bla Bla Bla");
        aboutTextInLabel.setFont(Font.font("Verdana", 40));
        aboutTextInLabel.setStyle("-fx-color: #040112;");
        
        // Title
        title = new Text("MOTOR CONTROLLER");
        title.setFont(Font.font("Verdana", 45));
        title.setFill(Color.WHITE);
        title.setTranslateY(-440);
        title.setEffect(glow);
        
        /**********/
        /* Labels */
        /**********/
        
        // Status Label
        speedLabel = new Label("0");
        speedLabel.setTextFill(Color.WHITE);
        speedLabel.setFont(Font.font("Arial", 100));
        speedLabel.setCache(true);
        speedLabel.setEffect(glow);
        
        // Direction Status Label
        dirStatusLabel = new Label("Clockwise");
        dirStatusLabel.setTextFill(Color.rgb(233,16,94));
        dirStatusLabel.setFont(Font.loadFont(new FileInputStream(new File("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Fonts/body.ttf")), 40));
        dirStatusLabel.setTextAlignment(TextAlignment.CENTER); 
        dirStatusLabel.setTranslateX(-645);
        dirStatusLabel.setTranslateY(-150);
        dirStatusLabel.setPrefHeight(35);
        dirStatusLabel.setAlignment(Pos.CENTER);
        
        // ON/OFF Status Label
        onoffStatusLabel = new Label("OFF");
        onoffStatusLabel.setTextFill(Color.rgb(233,16,94));
        onoffStatusLabel.setFont(Font.loadFont(new FileInputStream(new File("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Fonts/body.ttf")), 40));
        onoffStatusLabel.setTextAlignment(TextAlignment.CENTER);
        onoffStatusLabel.setTranslateX(-645);
        onoffStatusLabel.setTranslateY(110);
        onoffStatusLabel.setPrefHeight(35);
        onoffStatusLabel.setAlignment(Pos.CENTER);

        //----------------------------------------------------------------

        /**********/
        /* Slider */
        /**********/

        // Speed Slider
        speedSlider = new Slider();
        speedSlider.setMin(0);
        speedSlider.setMax(251);
        speedSlider.setValue(0);
        speedSlider.setShowTickMarks(true);
        speedSlider.setMaxWidth(500);
        speedSlider.setTranslateY(396);
        speedSlider.setEffect(glow);

        /*********/
        /* Panes */
        /*********/

        // Start Pane
        startPane = new StackPane();
        startPane.getChildren().add(startBackgroundImgView);
        startPane.getChildren().add(startText);
        startPane.getChildren().add(aboutButton);
        startPane.getChildren().add(startButton);
        startPane.getChildren().add(aboutText);
        startPane.getChildren().add(greetingGifImgView);
        startPane.getChildren().add(greetingText);
    
        // Main Pane
        mainPane = new StackPane();
        mainPane.getChildren().add(mainBackgroundImgView);
        mainPane.getChildren().add(speedSlider);
        mainPane.getChildren().add(gauge);
        mainPane.getChildren().add(speedLabel);
        mainPane.getChildren().add(backButton);
	mainPane.getChildren().add(bar);
        mainPane.getChildren().add(title);
        mainPane.getChildren().add(dirStatusLabelImgView);
        mainPane.getChildren().add(dirStatusLabel);
        mainPane.getChildren().add(onoffStatusLabelImgView);
        mainPane.getChildren().add(onoffStatusLabel);
        mainPane.getChildren().add(onoffButton);
        mainPane.getChildren().add(dir1Button);
        mainPane.getChildren().add(dir2Button);
        mainPane.getChildren().add(warningLabelImgView);
        mainPane.getChildren().add(wheelLabelImgView);
        mainPane.getChildren().add(warningImgView);
        mainPane.getChildren().add(wheelImgView);
        
        // About Pane
        aboutPane = new StackPane();
        aboutPane.getChildren().add(startBackgroundImgView2);
        aboutPane.getChildren().add(backButton2);
        aboutPane.getChildren().add(aboutTextLabelView);
        aboutPane.getChildren().add(aboutTextInLabel);

        //----------------------------------------------------------------
        
        /**********/
        /* Scenes */
        /**********/
        
        // Start Scene
        startScene = new Scene(startPane, 1920, 1000);
        
        // About Scene
        aboutScene = new Scene(aboutPane, 1920, 1000);
           
        // Main Scene
        mainScene = new Scene(mainPane, 1920, 1000);
        
        //----------------------------------------------------------------
        
        // Initialize refrence to Connect Class
        connection = new Connect();
        
    }
          
    /****************************************************************/
    /************************ Start Function ************************/
    /****************************************************************/
    
    @Override
    public void start(Stage stage) {
        
        
        connectionTask();
        
        /********************/
        /*     Greeting     */
        /********************/
        
        EventHandler<MouseEvent> eventHandler = (MouseEvent e) -> { 
            startPane.getChildren().remove(greetingGifImgView);
            startPane.getChildren().remove(greetingText);  
        }; 
        
    
        greetingGifImgView.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
       
        
        //----------------------------------------------------------------
        
        /********************/
        /* Buttons Handlers */
        /********************/
        
        // Start Button
        startButton.setOnAction((ActionEvent event) -> {
            stage.setScene(mainScene);
            stage.show();
        });
        
        // About Button
        aboutButton.setOnAction((ActionEvent event) -> {
            stage.setScene(aboutScene);
            stage.show();
        });
        
        // Back Button
        backButton.setOnAction((ActionEvent event) -> {
            stage.setScene(startScene);
            stage.show();
        });

        // Back Button 2
        backButton2.setOnAction((ActionEvent event) -> {
            stage.setScene(startScene);
            stage.show();
        });
        
        // ON/OFF Button
        onoffButton.setOnAction((ActionEvent event) -> {
            if(motorMode==false)
            {
                motorMode = true;
                onoffStatusLabel.setText("ON");
                if(motorDirection==false)
                {
                    directionRotate1.play();
                    directionRotate2.stop();
                }
                else
                {
                    directionRotate2.play();
                    directionRotate1.stop();
                }
                    
            }
            else
            {
                motorMode = false;
                onoffStatusLabel.setText("OFF");
                directionRotate1.stop();
                directionRotate2.stop();
            }
            
            connection.motorStateArduino(motorMode);
        });
        
        // Direction1 (Clockwise) Button
        dir1Button.setOnAction((ActionEvent event) -> {
        player3.stop();
     
        uriString3 = new File("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Music/clockwise.mp3").toURI().toString();
        player3 = new MediaPlayer(new Media(uriString3));
        
            if(motorDirection==true)
            {
                motorDirection = false;
                dirStatusLabel.setText("Clockwise");
                directionRotate1.play();
                directionRotate2.stop();
                
                connection.motorDirectionArduino(motorDirection);
            }
            else
            {
                // Do Nothing
            }
              if(Flag_Mute== false){ 
                    player1.stop(); 
                    player2.stop(); 
                    player3.play();
                }
        });
        
         // Direction2 (Anti-Clockwise) Button
        dir2Button.setOnAction((ActionEvent event) -> {
            
        player2.stop();
        uriString2 = new File("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Music/anti.mp3").toURI().toString();
        player2 = new MediaPlayer(new Media(uriString2));
        
      
            if(motorDirection==false)
            {
                motorDirection = true;
                dirStatusLabel.setText("Anti-Clockwise");
                directionRotate1.stop();
                directionRotate2.play();
                
                connection.motorDirectionArduino(motorDirection);
            }
            
            else
            {
                // Do Nothing
            }
            
            if(Flag_Mute== false)
            { 
                player3.stop(); 
                player1.stop(); 
                player2.play();
            }
        });
        
        
        //----------------------------------------------------------------
		  
        // TO MUTE SOUND
         
        sound.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               Flag_Mute= true;
               
            }
        });
        //----------------------------------------------------------------
		
        // TO UNMUTE SOUND
        
         sound1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Flag_Mute= false;
                
            }
        });
		
	//----------------------------------------------------------------
		
	 // EXIT ALERT
        
        exit.setOnAction(new EventHandler<ActionEvent>(){
        @Override
           public void handle(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation message");
            alert.setHeaderText("Exit!");
            alert.setContentText("Are you sure you want to Exit this app");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
            stage.close();
            }
            else {}

            }
       
        });
        
        /******************/
        /* Slider Handler */
        /******************/

        // Speed Slider
        speedSlider.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderSpeed = newValue.intValue();
            connection.sendData(sliderSpeed);
            motorSpeed= (int) (sliderSpeed/2.5);
            speedLabel.setText("" + motorSpeed + "");
            gauge.setValue(motorSpeed);
            
            uriString1 = new File("/Users/josephgirges/Desktop/Data/ITI/Courses/05.Java Programming/Project/git/Attachments/Music/speed2.mp3").toURI().toString();
            player1 = new MediaPlayer(new Media(uriString1));
            
            if(motorSpeed>85)
            {
                timer.start();
            }
            
            else
            {
                warningSignOpacity =  0.5;
            }
            
            if(motorSpeed>85 && mediaFlag == true)
            {
                mediaFlag=false;
                
                if(Flag_Mute== false)
                { 
                    player3.stop(); 
                    player2.stop(); 
                    player1.play();
                }
                                    
                   
            }
        
            else if (motorSpeed<=85)
            {
                mediaFlag = true;
            }             
        });
        
        //----------------------------------------------------------------
        
        /*****************/
        /* Scene & Stage */
        /*****************/
        stage.setTitle("Motor Controller");
        stage.getIcons().add(iconImg);
        stage.setResizable(false);
        stage.setScene(startScene);
        stage.show();
        
        //----------------------------------------------------------------
        
    }

    
    
    public void connectionTask(){
        Runnable task = new Runnable(){
            @Override
            public void run() {
                while(true){
                    runTask();
                }
            }
        };
        Thread backGround = new Thread(task);
        backGround.start();
    }
    
    public void runTask(){
        

        while(connection.checkConnection()){
            
        }
        
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                 Alert alert = new Alert(Alert.AlertType.WARNING);
                 alert.showAndWait();
                 connection = new Connect();
            }
        
        });
        
        while(!connection.checkConnection()){
            
        }
       
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                 connection.motorDirectionArduino(motorDirection);
                 connection.motorStateArduino(motorMode);
                 connection.sendData(sliderSpeed);
          
        
    }
    
    private class Timer extends AnimationTimer {

        @Override
        public void handle(long now) {

            Handle();
        }

        private void Handle() {
            
            warningSignOpacity -= 0.02;
            warningImgView.opacityProperty().set(warningSignOpacity);
            
            
            if (motorSpeed<85)
            {
                stop();
            }
            
            if (warningSignOpacity <= 0.2) 
            {
                while (warningSignOpacity <= 1)
                {
                    warningSignOpacity += 0.02;
                }
            }
        }
    }
    
    
    /****************************************************************/
    /************************ Main Function *************************/
    /****************************************************************/
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
