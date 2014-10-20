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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LosePanel extends JPanel
{
  //-----------------------------------------------------------------
  //  Tells user they lost and allows user to view credits and replay
  //-----------------------------------------------------------------
  public LosePanel()
  {
    setLayout (new GridLayout (3, 1,0,0));
    
    setBackground (Color.black);
    
    JLabel lost = new JLabel("<html><center><font size=\"18\">You have crashed the lander!<br><br></font></center></html>");
    JButton replay = new JButton ("RETRY"); //make buttons
    JButton credits = new JButton ("CREDITS");
    lost.setForeground(Color.white);
    replay.addActionListener(new Replay());
    credits.addActionListener(new CreditListener());
    JPanel replayBut = new JPanel();
    replayBut.add(replay);
    JPanel creditBut = new JPanel();
    creditBut.add(credits);
    replay.setPreferredSize(new Dimension(200,40));
    credits.setPreferredSize(new Dimension(200, 40));
    
    
    add (lost);
    add (replayBut);
    add (creditBut);
    
  }
  
  
  
  
  
  
  private class Replay implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      CenterPicture.redraw(1); //take to main menu, reset game
      MathDriver.reset();
    }  
  }
  
  
  
  
  private class CreditListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      CenterPicture.redraw(7); //take to credits menu, still reset the game
      MathDriver.reset();
    }  
  }
}
