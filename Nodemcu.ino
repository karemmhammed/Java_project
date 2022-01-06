
#include <ESP8266WiFi.h>


#define int1 D3
#define int2 D2
#define int3 D5
#define int4 D6
#define en1 D7
#define en2 D8

int x =0;
int y =0;

char MotorDirection =0;
char MotorState = 0;

enum Car{
   Car_Forward =251,
   Car_Backward,
   Car_Right,
   Car_Left,
   Car_Stop,
};
int Car_State=Car_Stop;

char PWM = 0;


const char* ssid = "hassan";
const char* password = "33141018";


WiFiServer server(80);



void Right(){
  analogWrite(en1,PWM); 
  analogWrite(en2,PWM); 
  digitalWrite(int1,HIGH);
  digitalWrite(int2,LOW);
  digitalWrite(int3,HIGH);
  digitalWrite(int4,LOW);
}

void Left(){
  analogWrite(en1,PWM);
  analogWrite(en2,PWM);  
  digitalWrite(int1,LOW);
  digitalWrite(int2,HIGH);
  digitalWrite(int3,LOW);
  digitalWrite(int4,HIGH);
}

void Backward(){
  analogWrite(en1,PWM);
  analogWrite(en2,PWM); 
  digitalWrite(int1,LOW);
  digitalWrite(int2,HIGH);
  digitalWrite(int3,HIGH);
  digitalWrite(int4,LOW);
}

void Forward(){
  analogWrite(en1,PWM); 
  analogWrite(en2,PWM);
  digitalWrite(int1,HIGH);
  digitalWrite(int2,LOW);
  digitalWrite(int3,LOW);
  digitalWrite(int4,HIGH);
}

void Stop(){
  digitalWrite(int1,LOW);
  digitalWrite(int2,LOW);
  digitalWrite(int3,LOW);
  digitalWrite(int4,LOW);
}

void MotorAntiClkWise(){
  analogWrite(en1,PWM); 
  digitalWrite(int1,HIGH);
  digitalWrite(int2,LOW);
}

void MotorClkWise(){
  analogWrite(en1,PWM); 
  digitalWrite(int1,LOW);
  digitalWrite(int2,HIGH);
}

void setup()
{
  Serial.begin(9600);
  Serial.println();

  
  
  pinMode(en1,OUTPUT);
  pinMode(en2,OUTPUT);
  pinMode(int1,OUTPUT);
  pinMode(int2,OUTPUT);
  pinMode(int3,OUTPUT);
  pinMode(int4,OUTPUT);

  Serial.printf("Connecting to %s ", ssid);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  Serial.println(" connected");

  server.begin();
  Serial.printf("Web server started, open %s in a web browser\n", WiFi.localIP().toString().c_str());
}



void loop() {
  WiFiClient client = server.available();
  // wait for a client (web browser) to connect
  if (client)
  {
    Serial.println("\n[Client connected]");
    while (client.connected())
    {
      // read line by line what the client (web browser) is requesting
      if (client.available())
      {
         
         x = client.read();
        Serial.println(x);
        // wait for end of client's request, that is marked with an empty line
       
    
       
         if(x>250){
          Car_State = x;
         }
         else{
          PWM = x;
         }
        
         
      }
      
      
      switch(Car_State){
        case Car_Forward : Forward();   break;
        case Car_Backward: Backward();  break;
        case Car_Right   : Right();     break;
        case Car_Left    : Left();      break;
        case Car_Stop    : Stop();      break;
      }

    }

    

    // close the connection:
    client.stop();
    Serial.println("[Client disconnected]");
  }

  if(Serial.available()){
    y= Serial.read();
    
   switch(y){
    case 255: MotorDirection=1;break;
    case 254: MotorDirection=0;break;
    case 253: MotorState=0;break;
    case 252: MotorState=1;break;
    default : PWM = y;
   }

   if(MotorDirection == 1 && MotorState==1){
          MotorClkWise();
   }
   else if(MotorDirection == 0 && MotorState==1){
          MotorAntiClkWise();
   }
   else if (MotorState==0){
          Stop();
   }
   
  }
}