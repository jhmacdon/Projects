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
* WinPanel.java
*                                         
*******************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WinPanel extends JPanel
{
  //-----------------------------------------------------------------
  //  displays the panel the player see's when they win
  //-----------------------------------------------------------------
  public WinPanel()
  {
    setLayout (new GridLayout (3, 1));
    
    setBackground (Color.black);
    
    //create and add components to GridLayout
    JLabel won = new JLabel("<html><font size=\"18\">You have won!</font></html>"); //tells player they won
    JButton replay = new JButton ("REPLAY");
    JPanel replayBut = new JPanel();
    replayBut.add(replay);
    JButton credits = new JButton ("CREDITS");
    JPanel creditBut = new JPanel();
    creditBut.add(credits);
    won.setForeground(Color.white);
    replay.addActionListener(new Replay());
    credits.addActionListener(new CreditListener());
    replay.setPreferredSize(new Dimension(200,40));
    credits.setPreferredSize(new Dimension(200, 40));
    add (won);
    add (replayBut);
    add (creditBut);
    
  }
  
  private class Replay implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      CenterPicture.redraw(1); //take back to startup screen
      MathDriver.reset();
    }  
  }
  
  
  
  private class CreditListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      CenterPicture.redraw(7); //displays credits screen
      MathDriver.reset();
    }  
  }  
}