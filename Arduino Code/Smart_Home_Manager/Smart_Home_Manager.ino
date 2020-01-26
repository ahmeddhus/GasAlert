#include <SoftwareSerial.h>


  int mq2Gas = A1;
int data;
  SoftwareSerial BTserial(10, 11); // RX | TX

void setup()
{
    pinMode(mq2Gas,OUTPUT);
 
    
    Serial.begin(9600);
}

void loop()
{
data = analogRead(mq2Gas); 


Serial.print(" "); 
 Serial.println(data);
}
   // if(Serial.available())
    
     // data = Serial.read();        //Read the incoming data & store into data
//      //Serial.print(data);          //Print Value inside data in Serial monitor      
//      switch(data)              // Checks whether value of data is equal to 1
//         {
      //{
         // if (data == 'c'){
             //
             
