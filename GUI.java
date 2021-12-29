package gui;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.skins.ModernSkin;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Optional;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    int motorSpeed;
	
	
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

    // GIFs 
    Image startGifImg;
    ImageView startGifImgView; 
    ImageView startGifImgView2;
    
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
        
	/***********/
        /* Music*/
        /***********/
		
        uriString1 = new File("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\speed.mp3").toURI().toString();
        player1 = new MediaPlayer(new Media(uriString1));
        uriString2 = new File("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\anti.mp3").toURI().toString();
        player2 = new MediaPlayer(new Media(uriString2));
        uriString3 = new File("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\clockwise.mp3").toURI().toString();
        player3 = new MediaPlayer(new Media(uriString3));
        
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
        gauge.setSkin(new ModernSkin(gauge));  //ModernSkin : you guys can change the skin
        gauge.setUnit("Km/h");  //unit
        gauge.setUnitColor(Color.WHITE);
        gauge.setValueVisible(false);
        gauge.setBarColor(Color.rgb(7, 137, 191));
        gauge.setNeedleColor(Color.rgb(194, 1, 54));
        gauge.setThresholdColor(Color.rgb(194, 1, 54));  //color will become red if it crosses threshold value
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
        startBackgroundImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\startBackground.png"));
        startBackgroundImgView = new ImageView(startBackgroundImg);
        startBackgroundImgView.setFitHeight(1000);
        startBackgroundImgView.setFitWidth(1920);
        
        startBackgroundImgView2 = new ImageView(startBackgroundImg);
        startBackgroundImgView2.setFitHeight(1000);
        startBackgroundImgView2.setFitWidth(1920);
             
        mainBackgroundImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\mainBackground.png"));
        mainBackgroundImgView = new ImageView(mainBackgroundImg);
        mainBackgroundImgView.setFitHeight(1000);
        mainBackgroundImgView.setFitWidth(1920);
    
        // Symbols
        backButtonImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\backButton.png"));
        backButtonImgView = new ImageView(backButtonImg);
        backButtonImgView.setFitHeight(50);
        backButtonImgView.setFitWidth(50);
        
        backButtonImg2 = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\backButton.png"));
        backButtonImgView2 = new ImageView(backButtonImg);
        backButtonImgView2.setFitHeight(50);
        backButtonImgView2.setFitWidth(50);


        // GIFs 
        startGifImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\startGIF.gif"));
        startGifImgView = new ImageView(startGifImg);
        startGifImgView.setFitHeight(450);
        startGifImgView.setFitWidth(450);
        startGifImgView.setEffect(glow);
        
        startGifImgView2 = new ImageView(startGifImg);
        startGifImgView2.setFitHeight(350);
        startGifImgView2.setFitWidth(350);
        startGifImgView2.setTranslateX(550);
        startGifImgView2.setTranslateY(300);
        startGifImgView2.setEffect(glow);
        
        // About Text Label
        aboutTextLabel = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\main.png"));
        aboutTextLabelView = new ImageView(aboutTextLabel);
        aboutTextLabelView.setEffect(glow);
        
        
        // ON/OFF Button
        onoffButtonImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\onoffButton.png"));
        onoffButtonImgView = new ImageView(onoffButtonImg);
        onoffButtonImgView.setFitHeight(50);
        onoffButtonImgView.setFitWidth(50);
        
        // Direction1 (Clockwise) Button
        dir1ButtonImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\dir1Button.png"));
        dir1ButtonImgView = new ImageView(dir1ButtonImg);
        dir1ButtonImgView.setFitHeight(50);
        dir1ButtonImgView.setFitWidth(50);

        // Direction2 (Anti-Clockwise) Button
        dir2ButtonImg = new Image(new FileInputStream("C:\\Users\\Sarah\\Documents\\Java_project\\Attachments\\dir2Button.png"));
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
        startButton.setEffect(glow);
        
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
        
        /*********/
        /* Texts */
        /*********/
        
        // Start Label
        startText = new Text("Start");
        startText.setFont(Font.font("Verdana", 40));
        startText.setFill(Color.WHITE);
        
        
        // About Text
        aboutText = new Text("ABOUT");
        aboutText.setFont(Font.font("Verdana", 20));
        aboutText.setFill(Color.WHITE);
        aboutText.setTranslateX(550);
        aboutText.setTranslateY(300);
        
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

        //----------------------------------------------------------------

        /**********/
        /* Slider */
        /**********/

        // Speed Slider
        speedSlider = new Slider();
        speedSlider.setMin(0);
        speedSlider.setMax(100);
        speedSlider.setValue(0);
        speedSlider.setShowTickMarks(true);
        speedSlider.setMaxWidth(500);
        speedSlider.setTranslateY(396);

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
        startPane.getChildren().add(aboutButton);
        startPane.getChildren().add(startButton);
        startPane.getChildren().add(aboutText);
    
        // Main Pane
        mainPane = new StackPane();
        mainPane.getChildren().add(mainBackgroundImgView);
        mainPane.getChildren().add(speedSlider);
        mainPane.getChildren().add(gauge);
        mainPane.getChildren().add(speedLabel);
        mainPane.getChildren().add(backButton);
        mainPane.getChildren().add(onoffButton);
        mainPane.getChildren().add(dir1Button);
        mainPane.getChildren().add(dir2Button);
	mainPane.getChildren().add(bar);
        mainPane.getChildren().add(title);
        
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
				player3.play();
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
				player2.play();
            }
            else
            {
                // Do Nothing
            }
        });
        
        //----------------------------------------------------------------
		  
        // TO MUTE SOUND
         
        sound.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player1.setVolume(0);
                player2.setVolume(0);
                player3.setVolume(0);
            }
        });
		
        //----------------------------------------------------------------
		
        // TO UNMUTE SOUND
        
        sound1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player1.setVolume(50);
                player2.setVolume(50);
                player3.setVolume(50);
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
            motorSpeed = newValue.intValue();
            speedLabel.setText("" + motorSpeed + "");
            gauge.setValue(motorSpeed);
        });
        
        //----------------------------------------------------------------
        
        /*****************/
        /* Scene & Stage */
        /*****************/
        stage.setTitle("Motor Controller");
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
