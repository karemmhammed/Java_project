/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltest;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ahmed
 */
public class ClientGui {
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
   
    
    

    public ClientGui() {
        
        try {
            mySocket = new Socket("192.168.1.7", 80);
           
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
    
    public void clientSendData(int data){
        ps.write(data);
       
    }
    
    
    
    public void clientCheckConnection(){
        
        /*new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        if(dis.read()!=5){
                            System.out.println("hell");
                            new ClientGui();
                           
                        }
                        System.out.println(dis.read());
                    } catch (IOException ex) {
                        Logger.getLogger(ClientGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        
    }).start();*/
        
    }
       
}
