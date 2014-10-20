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
* Parameters.java
*                                         
*******************************************/
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Parameters extends JPanel
{
  
      MathDriver specs = new MathDriver();
      
      //create labels
      JLabel fuel = new JLabel();
      JLabel velocity = new JLabel();
      JLabel height = new JLabel();
      JLabel thrusters = new JLabel("Thrusters: "+(int)(specs.getThrustPower())*10+"%");
      
   //-----------------------------------------------------------------
   //  Constructs a panel to display parameters of the game
   //-----------------------------------------------------------------
   public Parameters()
   {
      setLayout (new FlowLayout());
      fuel.setForeground(Color.white);

      //add components to flowpanel
      add (fuel);
      add (new JLabel());
      add (velocity);
      add (new JLabel());
      add (height);
      add (new JLabel());
      add (thrusters);
   }
   
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        fuel.setText(specs.getFuel());                                              //get fuel percentage
        velocity.setText("Velocity: "+((-1)*(int)specs.getVelocity())+" m/s     "); //set velocity
        velocity.setForeground(Color.white);
        fuel.setForeground(Color.white);
        height.setText("Height: "+(int)(410-(specs.getY()/10))+" meters     ");          //set height
        height.setForeground(Color.white);
        thrusters.setText("Thrusters: "+(int)(specs.getThrustPower())*10+"%");      //set thrusters
        if(specs.fuelAmount()<2)
        {
          thrusters.setText("Out of fuel!");
        }
        thrusters.setForeground(Color.white);
        setBackground(Color.gray);
    }
   
   
     
}