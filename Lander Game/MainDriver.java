/******************************************
*                                         
* Official Name: Josiah MacDonald                           
*                                         
* E-mail:  jhmacdon@syr.edu               
*                                         
* Final Project:  Lunar Lander              
*                                         
* Compiler:  drJava on a mac               
*                                         
* Date:  Dec. 2, 2013       
* 
* MainDriver.java
*                                         
*******************************************/
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;


import javax.swing.JFrame;


public class MainDriver
{ 
  public static void main(String[] args) throws IOException
  {
    JFrame window = new JFrame("LM Simulator"); //title
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set action on close
    CenterPicture main = new CenterPicture(); //display what is in CenterPicture
    window.getContentPane().add(main);
    window.pack();
    window.setVisible(true);
    window.setBackground(Color.black);
    window.setResizable(false); //dont allow user to resize
  }
}