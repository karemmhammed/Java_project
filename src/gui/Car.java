package gui;




// packages

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.skins.ModernSkin;
import java.io.FileNotFoundException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author karim, josef and sara
 */
public class Car extends Application {
    //  /handle of gauge when button released 
     Timer timer;
     
     // speed of motor
    int motorspeed = 0;
    
   // flage for cotrol 
    boolean flag_key = false;
    
    
    //back button to start
    
    Button backButtonCarStart;
    Image backButtonImgCar;
    ImageView backButtonImgViewCar;

     
  //slider and label
     
    Slider speedSlider;
    int sliderSpeed=0;
    Label speedLabel;
    
 //text for the title of the scene  
    Text carTitle;
    
 //gauge to show the speed of car
    Gauge gauge;  
    
    
  //button of control
    Button backButton;
    Button upButton;
    Button rightButton;
    Button leftButton;
    
    // Background
 
    Image mainBackgroundImg;
    ImageView mainBackgroundImgView;
    
    //button_images
    
    Image rightLabel;
    ImageView rightLabelView;

    Image leftLabel;
    ImageView leftLabelView;

    // Images
    Image car;
    ImageView carView;
    
    
    Image up_arrow;
    ImageView up_arrow_View;

    Image down_arrow;
    ImageView down_arrow_View;

    Image right_arrow;
    ImageView right_arrow_View;

    Image left_arrow;
    ImageView left_arrow_View;
    
     Glow glow;

    // pane
    
       StackPane mainPane2;
       
  // Scene     
       
       Scene CarrScene;
       
       
       ClientGui client;
       
       
     @Override
     public void init() throws FileNotFoundException {
         
         // Images
        car = new Image(getClass().getResourceAsStream("Images/Tesla.png"));
        carView = new ImageView(car);
        carView.setFitHeight(800);
        carView.setFitWidth(800);
        carView.setTranslateY(170);
        
        
         leftLabel = new Image(getClass().getResourceAsStream("Images/left.png"));
        leftLabelView = new ImageView(leftLabel);
        leftLabelView.setFitHeight(600);
        leftLabelView.setFitWidth(400);
        leftLabelView.setTranslateX(550);
        leftLabelView.setTranslateY(-80);

        rightLabel = new Image(getClass().getResourceAsStream("Images/right.png"));
        rightLabelView = new ImageView(rightLabel);
        rightLabelView.setFitHeight(600);
        rightLabelView.setFitWidth(400);
        rightLabelView.setTranslateX(-550);
        rightLabelView.setTranslateY(-80);

         
         // Symbols
        backButtonImgCar = new Image(getClass().getResourceAsStream("Images/backButton.png"));
        backButtonImgViewCar = new ImageView(backButtonImgCar);
        backButtonImgViewCar.setFitHeight(50);
        backButtonImgViewCar.setFitWidth(50);
        
        
         // Back Button From Car-Mode to Home
        backButtonCarStart = new Button();
        backButtonCarStart.setGraphic(backButtonImgViewCar);
        backButtonCarStart.setStyle("-fx-background-color: transparent;");
        backButtonCarStart.setTranslateY(450);
        backButtonCarStart.setTranslateX(-900);
        
       // imit timer for control button released
        timer = new Timer();
             
        
         
      //init of label
        speedLabel = new Label("0");
        speedLabel.setTextFill(Color.WHITE);
        speedLabel.setFont(Font.font("Arial", 50));
        speedLabel.setCache(true);
        speedLabel.setEffect(glow);
        speedLabel.setTranslateY(-190);
        speedLabel.setTranslateX(-585);;
        
        //init of slider 
        
         
        speedSlider = new Slider();
        speedSlider.setFocusTraversable(false);
        speedSlider.setStyle("-fx-focus-color: Red;");
        speedSlider.disableProperty();
        BooleanProperty interestingMode = new SimpleBooleanProperty(false);
        ToggleGroup tg = new ToggleGroup();
        interestingMode.bind(tg.selectedToggleProperty().isEqualTo(speedSlider));
        tg.selectedToggleProperty().addListener((observable, oldValue, newValue)
                -> System.out.println((newValue == speedSlider)));
        speedSlider.setMin(0);
        speedSlider.setMax(250);
        speedSlider.setValue(0);
        speedSlider.setShowTickMarks(true);
        speedSlider.setMaxWidth(650);
        speedSlider.setTranslateY(350);
        speedSlider.setEffect(glow);
        
    // int of gauge to show the speed of car     
        gauge = new Gauge();
        gauge.setSkin(new ModernSkin(gauge));
        gauge.setUnit("Rpm");  //unit
        gauge.setAnimated(true);
        gauge.setAnimationDuration(500); 
        gauge.setUnitColor(Color.WHITE);
        gauge.setValueVisible(false);
        gauge.setBarColor(Color.rgb(7, 137, 191));
        gauge.setNeedleColor(Color.rgb(137, 207, 240));
        gauge.setThresholdColor(Color.rgb(194, 1, 54));  //color will become red if it crosses threshold value
        gauge.setThreshold(85);
        gauge.setThresholdVisible(true);
        gauge.setTickLabelColor(Color.WHITE);
        gauge.setTickMarkColor(Color.WHITE);
        gauge.setMaxSize(250, 250);
        gauge.setTranslateY(-190);
        gauge.setTranslateX(-585);
        
      // init of images of control buttons 
       
       
        down_arrow  = new Image(getClass().getResourceAsStream("Images/ArrowDown.png"));
        down_arrow_View = new ImageView( down_arrow );
        down_arrow_View.setFitHeight(80);
        down_arrow_View.setFitWidth(80);
        
            
        up_arrow  = new Image(getClass().getResourceAsStream("Images/ArrowUP.png"));
        up_arrow_View = new ImageView( up_arrow );
        up_arrow_View.setFitHeight(80);
        up_arrow_View.setFitWidth(80);
        
            
        right_arrow  = new Image(getClass().getResourceAsStream("Images/ArrowRight.png"));
        right_arrow_View = new ImageView( right_arrow );
        right_arrow_View.setFitHeight(80);
        right_arrow_View.setFitWidth(80);
        
        
            
        left_arrow  = new Image(getClass().getResourceAsStream("Images/ArrowLeft.png"));
        left_arrow_View = new ImageView( left_arrow );
        left_arrow_View.setFitHeight(80);
        left_arrow_View.setFitWidth(80);
        
        glow = new Glow(3);
        
     // control Buttons
       
        backButton = new Button("Back");
        backButton.setGraphic(down_arrow_View);
        backButton .setStyle("-fx-background-color: transparent;");
        backButton.setEffect(glow); 
        backButton.setTranslateX(585);
        backButton.setTranslateY(-100);
        backButton.setMaxHeight(80);
        backButton.setMaxWidth(80);
        
        upButton = new Button("Up");
        upButton.setGraphic(up_arrow_View);
        upButton.setStyle("-fx-background-color: transparent;");
        upButton.setEffect(glow);
        upButton.setTranslateX(585);
        upButton.setTranslateY(-280);
        upButton.setMaxHeight(80);
        upButton.setMaxWidth(80);
        
        rightButton = new Button("Right");
        rightButton.setGraphic(right_arrow_View);
        rightButton.setStyle("-fx-background-color: transparent;");
        rightButton.setEffect(glow);
        rightButton.setTranslateX(680);
        rightButton.setTranslateY(-189);
        rightButton.setMaxHeight(-189);
        rightButton.setMaxWidth(80);
        
        leftButton = new Button();
        leftButton.setGraphic(left_arrow_View);
        leftButton.setStyle("-fx-background-color: transparent;");
        leftButton.setEffect(glow);
        leftButton.setTranslateX(495);
        leftButton.setTranslateY(-189);
        leftButton.setMaxHeight(80);
        leftButton.setMaxWidth(80);
        
           // Car Title
        carTitle = new Text("CAR CONTROLLER");
        carTitle.setFont(Font.font("Verdana", 45));
        carTitle.setFill(Color.WHITE);
        carTitle.setTranslateY(-440);
        carTitle.setEffect(glow);
        
   
         // init the back ground 
         
        mainBackgroundImg  = new Image(getClass().getResourceAsStream("Images/mainBackground.png"));
        mainBackgroundImgView = new ImageView(mainBackgroundImg);
        mainBackgroundImgView.setFitHeight(1000);
        mainBackgroundImgView.setFitWidth(1920);
        
        // init pane
        mainPane2 = new StackPane();
      
        mainPane2.getChildren().add(mainBackgroundImgView);
        mainPane2.getChildren().add(rightLabelView);
        mainPane2.getChildren().add(leftLabelView);
        mainPane2.getChildren().add(gauge);
        mainPane2.getChildren().add(speedSlider);
        mainPane2.getChildren().add(backButton);
        mainPane2.getChildren().add(upButton);
        mainPane2.getChildren().add(rightButton);
        mainPane2.getChildren().add(backButtonCarStart);
        mainPane2.getChildren().add(leftButton);
        mainPane2.getChildren().add(carTitle);
        mainPane2.getChildren().add(carView);
        mainPane2.getChildren().add(speedLabel);
        CarrScene = new Scene(mainPane2, 1920, 1000);
        
    
         
         
     }
     
   @Override
    public void start(Stage stage1) {
        
        
        stage1.setTitle("Motor Controller");
        stage1.setResizable(false);
        stage1.setScene(CarrScene);
        stage1.show();
        
        
        
        CarrScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public  void handle(KeyEvent event) {
               
           
                switch(event.getCode()){
                    
                    case UP:
                        flag_key=true;
                        System.out.println("===up");
                        upButton.setStyle("-fx-content-display: graphic-only;");
                        client.clientSendData(251);
                         if(motorspeed<sliderSpeed){
                        motorspeed+=1;
                        gauge.setValue((int)(motorspeed/2.5));
                        speedLabel.setText("" + (int)(motorspeed/2.5)  + "");
                        
                        }
                        
                        
                        break;
                    case DOWN:
                        System.out.println("===Down");
                        backButton.setStyle("-fx-content-display: graphic-only;");
                        
                        client.clientSendData(252);
                       
                        break;
                        
                    case LEFT:
                        System.out.println("===Left");
                        leftButton.setStyle("-fx-content-display: graphic-only;");
                        client.clientSendData(254);
                         if(motorspeed<sliderSpeed){
                        motorspeed+=1;
                        gauge.setValue((int)(motorspeed/2.5));
                        speedLabel.setText("" + (int)(motorspeed/2.5)  + "");
                       
                        }
                      
                        
                        break;
                       
                    case RIGHT:
                        System.out.println("===RIGHT");
                        rightButton.setStyle("-fx-content-display: graphic-only;");
                        client.clientSendData(253);
                         if(motorspeed<sliderSpeed){
                        motorspeed+=1;
                        gauge.setValue((int)(motorspeed/2.5));
                        speedLabel.setText("" + (int)(motorspeed/2.5)  + "");
                        
                        }
                        break;
                  case  ENTER:
                          
                          if(sliderSpeed<250){
                        sliderSpeed +=5; 
                        speedSlider.adjustValue(sliderSpeed);
                        client.clientSendData(sliderSpeed);
                       }
                        break;
                        
                      case  BACK_SPACE:
                          if(sliderSpeed>0){
                        sliderSpeed -=5; 
                        speedSlider.adjustValue(sliderSpeed);
                        client.clientSendData(sliderSpeed);
                          }
                        break;
                      case ESCAPE:
                          stage1.close();
            }
                
        }
            
  });
       CarrScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                
                
                switch(event.getCode()){
                    
                    case UP:
                        client.clientSendData(255);
                        flag_key=false;
                        System.out.println("===up");
                        upButton.setStyle("-fx-background-color: transparent;");
                        timer.start();
                        
                        
                   break;

                    case DOWN:
                        client.clientSendData(255);
                        System.out.println("===Down");
                        backButton.setStyle("-fx-background-color: transparent;");

                        break;

                    case LEFT:
                        client.clientSendData(255);
                        System.out.println("===Left");
                        leftButton.setStyle("-fx-background-color: transparent;");
                        timer.start();

                        break;

                    case RIGHT:
                        client.clientSendData(255);
                        System.out.println("===RIGHT");
                        rightButton.setStyle("-fx-background-color: transparent;");
                        timer.start();

                        break;
                }
         }
  });
    
          // Speed Slider 
          
        speedSlider.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderSpeed = newValue.intValue();
            client.clientSendData(sliderSpeed);
            
            
       });
    }
   public static void main(String[] args) {
        Application.launch(args);
    }
   
   
   // handle of button released 
    private class Timer extends AnimationTimer {

        @Override
        public void handle(long now) {

            Handle();
        }

        private void Handle() {
                        
                       if (motorspeed == 0 || flag_key == true) {
                flag_key = false;
                stop();
                return;
            }

            motorspeed -= 1;
            gauge.setValue((int) (motorspeed / 2.5));
            speedLabel.setText("" + (int) (motorspeed / 2.5) + "");


           
                        
       }
    }
  }
