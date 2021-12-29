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





/**
 * This class used to make the connection between the arduino and java code
 * using the {com.fazecast.jSerialComm} library which is used to implement
 * the serial communication , sending and receving data.
 */
public class Connect {
    
  /****************************************************************/
  /******************** Variables Declarations ********************/
  /****************************************************************/  
  
	/***************/
    /* Motor State */
    /***************/
	
	//Motor_On
	
	//Motor_Of
	
	
  //----------------------------------------------------------------	
	
	
	/*******************/
	/* Motor Direction */
	/*******************/
	
	//Motor_Clk_Wise
	
	//Motor_Anti_Clk_Wise
	
	
  //----------------------------------------------------------------	
	
	
	/***********************/
	/* Serial Comm Objects */
	/***********************/
	
	//Communication Port
	
	//Output Stream

	//Input Stream
	
	
  //----------------------------------------------------------------
  
  
   /**
     * public constructor used to start the serial communication 
	 *
     */
    public void Connect(){
        
		
    }
	
	
	/**
	 *	call the {sendData} method to send the state of the motor to the arduino
	 *	
     * @param   state        Motor state
	 *						 (on,off).
     *
     */
    public void motorStateArduino(boolean state){
       
	   
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
        
		
    }
	
	
	/**
	 *	send the data to the arduino 
	 *	
     * @param   data        data send to the arduino.
     *
     */
    public void sendData(int data){
        
        
    }
	
	
    /**
	 *	read data from the arduino 
	 *	
     * @return	data read from arduino.
     *
     */
    public int readData(){
         
		 
    }
}
