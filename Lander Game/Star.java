/******************************************
*                                         
* Official Name: Josiah MacDonald
* 
* Website: josiahmacdonald.com
*                                         
* E-mail:  me@josiahmacdonald.com               
*                                         
* Final Project:  Lunar Lander              
*                                         
* Compiler:  drJava on a mac               
*                                         
* Date:  Dec. 2, 2013       
* 
* CenterPicture.java
*                                         
*******************************************/
import java.util.*;
import java.awt.*;

public class Star
{
  
  Random generator = new Random();
  int diameter=generator.nextInt(7)+1;
  int x=generator.nextInt(900); //generate x position
  final int y=generator.nextInt(2000); //generate y position
  double yNew = y;
  
  /* (DR) */
  public void draw(Graphics page)
  {
    page.setColor(Color.white);
    double parallax = diameter;
    
    if(diameter>2)
    {
      page.fillOval(x,(int)(yNew-=(parallax*(MathDriver.getVelocity()/100))/20),diameter,diameter); //draws star, 
    }                                                                                                        //moves more w/ more size
  }
  
}
