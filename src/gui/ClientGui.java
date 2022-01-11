/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ButtonType;


/**
 *
 * @author ahmed
 */
public class ClientGui {
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    GUI ref = new GUI();
   
    
    

    public ClientGui() {
        ref.alertOFconnection.setContentText("check your connection and press ok to reconnect or cancel to exit program.");
        ref.alertOFconnection.setTitle("System");
        ref.alertOFconnection.setHeaderText("Connection Lost!");
        
        try {
            mySocket = new Socket("192.168.137.58", 80);
           
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
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
    
    
   
    
    public void clientSendData(int data){
        ps.write(data);
       
    }

}
