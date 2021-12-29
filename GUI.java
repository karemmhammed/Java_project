package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
        
		/***********/
        /* Music*/
        /***********/
		
        uriString1 = new File("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\speed.mp3").toURI().toString();
        player1 = new MediaPlayer(new Media(uriString1));
        uriString2 = new File("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\anti.mp3").toURI().toString();
        player2 = new MediaPlayer(new Media(uriString2));
        String uriString3 = new File("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\clockwise.mp3").toURI().toString();
        player3 = new MediaPlayer(new Media(uriString3));
        
         //----------------------------------------------------------------
         
        /***********/
        /* menu*/
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
        startBackgroundImg = new Image(new FileInputStream("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\startBackground.png"));
        startBackgroundImgView = new ImageView(startBackgroundImg);
        startBackgroundImgView.setFitHeight(1000);
        startBackgroundImgView.setFitWidth(1920);
        
        mainBackgroundImg = new Image(new FileInputStream("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\mainBackground.png"));
        mainBackgroundImgView = new ImageView(mainBackgroundImg);
        mainBackgroundImgView.setFitHeight(1000);
        mainBackgroundImgView.setFitWidth(1920);
    
        // Symbols
        backButtonImg = new Image(new FileInputStream("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\backButton.png"));
        backButtonImgView = new ImageView(backButtonImg);
        backButtonImgView.setFitHeight(50);
        backButtonImgView.setFitWidth(50);

        // GIFs 
        startGifImg = new Image(new FileInputStream("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\startGIF.gif"));
        startGifImgView = new ImageView(startGifImg);
        startGifImgView.setFitHeight(450);
        startGifImgView.setFitWidth(450);
        
        // ON/OFF Button
        onoffButtonImg = new Image(new FileInputStream("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\onoffButton.png"));
        onoffButtonImgView = new ImageView(onoffButtonImg);
        onoffButtonImgView.setFitHeight(50);
        onoffButtonImgView.setFitWidth(50);
        
        // Direction1 (Clockwise) Button
        dir1ButtonImg = new Image(new FileInputStream("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\dir1Button.png"));
        dir1ButtonImgView = new ImageView(dir1ButtonImg);
        dir1ButtonImgView.setFitHeight(50);
        dir1ButtonImgView.setFitWidth(50);

        // Direction2 (Anti-Clockwise) Button
        dir2ButtonImg = new Image(new FileInputStream("C:\\Users\\elkany\\Documents\\NetBeansProjects\\Version-1-karim\\dir2Button.png"));
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
		mainPane.getChildren().add(bar);

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
