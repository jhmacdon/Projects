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
* ThrustControlPanel.java
*                                         
*******************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;



public class ThrustControlPanel extends JPanel
{
  static MathDriver calculator = new MathDriver();
  JLabel thrustPower = new JLabel("Thrusters:"+calculator.getThrustPower());
  
  //-------------------------------------------
  //  displays a panel with thruster control
  //-------------------------------------------
  public ThrustControlPanel()
  {
    /* (LM) */
    setLayout (new GridLayout (6, 1));
    setBackground(Color.darkGray);
    Color c=new Color(0,0,0,0); //make a transparent background
    
    /* GUI3 */
    JButton thrusterAdd = new JButton ("Thrusters +10%");
    thrusterAdd.addActionListener(new AddThrusterListener()); 
    JButton thrustersSub = new JButton ("Thrusters -10%");
    thrustersSub.addActionListener(new SubThrusterListener());
    
    JPanel blank = new JPanel();
    JPanel newBlank = new JPanel();
    newBlank.setBackground(Color.darkGray);
    
    thrustPower.setText("   Thrusters: "+calculator.getThrustPower()*10+"%");
    
    thrustPower.setForeground(Color.white);
    blank.setBackground(c);
   
    add (newBlank);
    add (blank);
    add (thrusterAdd);
    add (thrustersSub);
    add (blank);
    add (blank);
    
  }
  
  
  
  
  
  public void paintComponent(Graphics g) 
  {
    super.paintComponent(g);
    thrustPower.setText("   Thrusters: "+calculator.getThrustPower()*10+"%");
    if(calculator.fuelAmount()==0)
      thrustPower.setText("     You're out of fuel!");
    setBackground(Color.darkGray);
  }
  
  
  
  private class AddThrusterListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      if(calculator.getThrustPower()<10)
      {
        calculator.addThrust(); //calls mathdriver to add thrust
      }
    }  
  } 
  
  
  private class SubThrusterListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      if(calculator.getThrustPower()>0)
      {
        calculator.subThrust(); //calls mathdriver to sub thrust
      }
    }  
  }
}