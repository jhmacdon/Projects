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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StarPanel extends JPanel
{
  private int starNumber = 600; //number of stars
  private Star[] stars = new Star[starNumber];
  static MathDriver calculator = new MathDriver();
  static BufferedImage image, moon;

  
  public StarPanel()
  {
    /* (AR) */
    for(int i=0;i<starNumber;i++)
    {
      stars[i]=new Star(); //instantiate an array of Star()'s 
    }
    setBackground(Color.black);
    setPreferredSize(new Dimension(900,500));
    
    
    
    
    try //to avoid throw IO
    {                
      image = ImageIO.read(new File("lander.png")); //lander png
      moon = ImageIO.read(new File("bg.png"));//moon image
    } 
    catch (IOException ex) //throws IO
    {System.out.println(ex);}
    
    
    
    
    
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    for(int i=0;i<starNumber;i++) //draws all the stars
      stars[i].draw(g); //draws star
    g.drawImage(moon, 0, (int)((-MathDriver.getVelocity()+30)*0.5), null); //draws the moon
    g.drawImage(image, (getWidth()/2)-20, (int)calculator.position(), null); //draws the lander
    
    
  }
}
