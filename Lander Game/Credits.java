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
* Credits.java
*                                         
*******************************************/

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;


public class Credits extends JPanel
{
  Scanner fileScan = new Scanner (new File("credits.txt")); //reads the file with the credits
  String message="<html><center><br><br>", temp; //start the string
  
  //-----------------------------------------------------------------
  //  Credits will read in a text file into the credits panel
  //-----------------------------------------------------------------
  public Credits() throws IOException
  {
    while(fileScan.hasNext())
    {
      temp=fileScan.nextLine();     //read a line from .txt file
      message=message+temp+"<br>";  //inserts html to make a new line
      
    }
    
    message = message+"</center></html>"; //close tags
    
    setLayout (new GridLayout (2,1,0,70));
    
    
    JLabel instructions = new JLabel(message); //insert text to label
    instructions.setForeground(Color.white);   //make white
    JButton home = new JButton("BACK TO MAIN MENU"); //insert return button
    home.setPreferredSize(new Dimension(200, 40));
    home.addActionListener(new Play());
    JPanel butContain = new JPanel();
    butContain.add(home);
    
    add (instructions);  //add to screen
    add (butContain);
  }
  
  
  
  
  private class Play implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      CenterPicture.redraw(1); //redraw the screen
    }  
  }
}