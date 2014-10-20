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
* StartUp.java
*                                         
*******************************************/

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.event.*;

public class StartUp extends JPanel
{
  RadioListener myListener = null; 
  static int newFuel;
  
  public StartUp()
  {
    MathDriver.setFuel(0);
    newFuel=100; //set fuel early to avoid possible errors w/ radio buttons
    
    
    //make radio buttons
    /* GUI2 */
    JRadioButton easy = new JRadioButton("Easy");
    JRadioButton medium = new JRadioButton("Medium");
    JRadioButton hard = new JRadioButton("Hard");
    ButtonGroup group = new ButtonGroup();
    group.add(easy);
    group.add(medium);
    group.add(hard);
    easy.setActionCommand("1");
    medium.setActionCommand("2");
    hard.setActionCommand("3");
    easy.setForeground(Color.white);
    medium.setForeground(Color.white);
    hard.setForeground(Color.white);
    
    //set layout & color
    setLayout (new GridLayout (4, 4));
    setBackground (Color.black);
    
    //make buttons and actions
    JButton play = new JButton ("PLAY");
    play.addActionListener(new Play()); 
    JButton view = new JButton ("VIEW INSTRUCTIONS");
    view.addActionListener(new View());
    setPreferredSize(new Dimension(1040,570));
   
    
    JLabel description = new JLabel("<html><align=right>   Easy - Start with full fuel<br><br><br>Medium - "+
                                    "Start with some fuel<br><br><br>Hard - "+
                                    "Start with minimal fuel</align></html>",SwingConstants.RIGHT); //descriptions
    
    description.setBackground(Color.black);
    description.setForeground(Color.white);
    
    //add radiolistener
    myListener = new RadioListener(); 
    easy.addActionListener(myListener);
    medium.addActionListener(myListener);
    hard.addActionListener(myListener);
    JPanel buttons = new JPanel();
    
    //add buttons to grid layout
    buttons.setLayout(new GridLayout(0,1));
    buttons.add(easy);
    buttons.add(medium);
    buttons.add(hard);
    buttons.setBackground(Color.black);
    buttons.setForeground(Color.white);
    
    
    JPanel playContainer = new JPanel();
    JPanel viewContainer = new JPanel();
    play.setPreferredSize(new Dimension(200,40)); //set size
    view.setPreferredSize(new Dimension(200,40)); //set size
    playContainer.add(play);
    viewContainer.add(view);
    
    //add all components
    add (new JPanel());
    add (new JPanel());
    add (new JPanel());
    add (new JPanel());
    add (new JPanel());
    add (playContainer);
    add (viewContainer);
    add (new JPanel());
    add (new JPanel());
    add (buttons);
    add (description);
    add (new JPanel());
    add (new JPanel());
    add (new JPanel());
    add (new JPanel());
    add (new JPanel());
    setBackground (Color.black);
  }
  
  
  
  //-------------------------------------------
  //  Sets up game board
  //-------------------------------------------
  
  /* (LI) */
  private class Play implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      if(MathDriver.fuelAmount()==0) //check that difficulty was selected
      {
        String message = "Please select a difficulty level";
        /* GUI 3 */
        JOptionPane.showMessageDialog(null,message); //show message
      }
      else
      {
        CenterPicture.redraw(2); //start game
      }
      
    }  
  }
  
  
  
  /* (LI) */
  private class View implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      CenterPicture.redraw(3);
    }  
  }
  
  //-------------------------------------------
  //  Determines game difficulty
  //-------------------------------------------
  /* (LI) */
  class RadioListener implements ActionListener
  {
    
    public void actionPerformed(ActionEvent e) 
    {
      String selection = e.getActionCommand();
      int choice = 0;
      choice=Integer.parseInt(selection);
      if(choice<=1){
        MathDriver.setFuel(100); //set fuel for easy
        newFuel=100;} 
      else if(choice<=2){
        MathDriver.setFuel(75);  //set fuel for medium
        newFuel=75;}
      else if(choice<=3){
        MathDriver.setFuel(30);  //set fuel for hard
        newFuel=30;}
      else
        System.out.println("An Error Occurred");
      
    }
  }   
}