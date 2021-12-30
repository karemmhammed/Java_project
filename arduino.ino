#define int1 D5
#define int2 D6
#define en1 D7
char x=0;
char MotorDirection=0;
char MotorState=0;
char PWM = 0;
 void setup() {
 Serial.begin(9600);
 pinMode(en1,OUTPUT);
 pinMode(int1,OUTPUT);
 pinMode(int2,OUTPUT);
}
void MotorClkWise(){
  analogWrite(en1,PWM); 
  digitalWrite(int1,HIGH);
  digitalWrite(int2,LOW);
}
void MotorAntiClkWise(){
  analogWrite(en1,PWM); 
  digitalWrite(int1,LOW);
  digitalWrite(int2,HIGH);
}
void MotorStop(){
  digitalWrite(int1,LOW);
  digitalWrite(int2,LOW);
} 

void loop()
{}
