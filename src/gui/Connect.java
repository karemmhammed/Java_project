/********************************************************************
 * Project: Motor Controller
 * Connection between Arduino and Java
 * Description:
 * 	This class used for the connection between arduino
 * 
 * Version 1.0
 * @authors ِAhmed Hassan
			Osama Hamdy
 ********************************************************************/

package gui;



import com.fazecast.jSerialComm.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ButtonType;




/**
 * This class used to make the connection between the arduino and java code
 * using the {com.fazecast.jSerialComm} library which is used to implement
 * the serial communication , sending and receving data.
 */
public class Connect {
    
    GUI ref = new GUI();
    
  /****************************************************************/
  /******************** Variables Declarations ********************/
  /****************************************************************/  
  
    /***************/
    /* Motor State */
    /***************/
    
    //Motor_On
    private final int MOTOR_ON  = 252;
     
    //Motor Off
    private final int MOTOR_OFF = 253;
   
    //----------------------------------------------------------------
    
    /*******************/
    /* Motor Direction */
    /*******************/
    
    //Motor_Clk_Wise
    private final int MOTOR_CLK_WISE=255;
    
    //Motor_Anti_Clk_Wise
    private final int MOTOR_ANTICLK_WISE=254;
    
    //----------------------------------------------------------------	
    
    /***********************/
    /* Serial Comm Objects */
    /***********************/
	
    //Communication Port
    SerialPort comPort;
    
    //Output Stream
    OutputStream out;
    
    //Input Stream
    InputStream in ;
    
    //----------------------------------------------------------------
    
    
     /**
     * public constructor used to start the serial communication 
	 *
     */
    public Connect(){
        comPort = SerialPort.getCommPort("COM10");
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
     
    }
    
    /**
     * Check the Connection 
     * 
     * @return Connection state
     */
    public boolean checkConnection(){
       return comPort.openPort();
       
    }
   
    
    
    /**
	 *	call the {sendData} method to send the state of the motor to the arduino
	 *	
     * @param   state        Motor state
	 *						 (on,off).
     *
     */
    public void motorStateArduino(boolean state){
        if(state == true)
            sendData(MOTOR_ON);
        else
            sendData(MOTOR_OFF);
    }
    
    
    /**
	 *	call the {sendData} method to send the rotation direction of the motor to 
	 *	the arduino
	 *	
     * @param   direction    Motor direction
	 *						 (Clk_Wise,Anti_Clk_Wise).
     *
     */
    public void motorDirectionArduino(boolean direction){
        if(direction == true)
            sendData(MOTOR_CLK_WISE);
        else
            sendData(MOTOR_ANTICLK_WISE);
    }
    
    
    /**
	 *	send the data to the arduino 
	 *	
     * @param   data        data send to the arduino.
     *
     */
    public void sendData(int data){
        ref.alertOFconnection.setContentText("check your connection and press ok to reconnect or cancel to exit program.");
        ref.alertOFconnection.setTitle("System");
        ref.alertOFconnection.setHeaderText("Connection Lost!");
        out = comPort.getOutputStream();
        try {
            out.write(data);
            out.close();
        } catch (IOException ex) {
             Optional<ButtonType> result = ref.alertOFconnection.showAndWait();
            if (result.get() == ButtonType.OK) {
                ref.connection = new Connect();
            } else if(result.get() == ButtonType.CANCEL){
                System.exit(ref.modesFlag);
             }
            else{}
           
            
        }
        
    }
    
    
    /**
	 *	read data from the arduino 
	 *	
     * @return	data read from arduino.
     *
     */
    public int readData(){
        ref.alertOFconnection.setContentText("check your connection and press ok to reconnect or cancel to exit program.");
        ref.alertOFconnection.setTitle("System");
        ref.alertOFconnection.setHeaderText("Connection Lost!");
        int data = 0;
        comPort.getInputStream();
        try {
           data= in.read();
           in.close();
        } catch (IOException ex) {
            Optional<ButtonType> result = ref.alertOFconnection.showAndWait();
            if (result.get() == ButtonType.OK) {
                ref.connection = new Connect();
            } else if(result.get() == ButtonType.CANCEL){
                System.exit(ref.modesFlag);
             }
            else{}
        }
       
     return data;   
    }
    
}
