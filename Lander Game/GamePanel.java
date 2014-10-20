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
*******************************************

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class GamePanel extends javax.swing.JApplet
{
  /* CL */
  MathDriver calculator = new MathDriver();
  BorderLayout frameWork = new BorderLayout();
  Parameters param = new Parameters();
  StarPanel sp = new StarPanel();
  Thread runner;
  int speedToWin=5;
  //-----------------------------------------------------------------
  //  Constructs the GamePanel and necessary components
  //-----------------------------------------------------------------
  public GamePanel()
  {
    
    setLayout (frameWork);
    
    
    
    setBackground(new Color(0,0,0,0));
    
    /* GUI1 */
    JButton start = new JButton ("\nSTART\n");
    start.addActionListener(new Calculations());
    start.setPreferredSize(new Dimension(50, 50));
    JButton b5 = new JButton ("BUTTON 5");
    
    ThrustControlPanel thrustPanel = new ThrustControlPanel();
    JLabel fuelGauge = new JLabel(calculator.getFuel());
    fuelGauge.setForeground(Color.white);
    
    
    add (sp, BorderLayout.CENTER);
    add (param, BorderLayout.NORTH);
    add (start, BorderLayout.SOUTH);
    add (thrustPanel, BorderLayout.EAST);
    
  } 
  
  //-----------------------------------------------------------------
  //  All the timing things; calculates and refreshes every 6 ms
  //-----------------------------------------------------------------
  
  private class Calculations implements ActionListener
  {
    Timer tm = new Timer(6,this); //refreshes ever 6 milliseconds
    
    public void actionPerformed(ActionEvent event) 
    {
      tm.start();
      if(calculator.fuelAmount()<=1)
      {
          calculator.outOfFuel();
      }
        
        //--------------------------------
        //  Determines if landed or not
        //--------------------------------
        if((calculator.getY())>=410)
        {
          if((int)calculator.getVelocity()<=speedToWin){
            CenterPicture.redraw(4); //winning panel
            tm.stop(); //stop the timer
          }
          else{
            CenterPicture.redraw(6); //losing panel
            tm.stop();//stop the timer
          }
        }
        
        
        //--------------------------------
        //  Make move if all is good
        //--------------------------------
        else
        {
          /* (CL) */
          calculator.calculate();
          repaint();
        }
     
    }
    
  }
 
}
