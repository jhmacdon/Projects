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
* Instructions.java
*                                         
*******************************************/
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;


public class Instructions extends JPanel
{
  Scanner fileScan = new Scanner (new File("instructions.txt"));
  String message="<html><center><br><br>", temp;
  
  //-----------------------------------------------------------------
  //  Scans instructions.txt line by line
  //-----------------------------------------------------------------
  public Instructions() throws IOException
  {
    /* (I/O) */
    while(fileScan.hasNext())
    {
      temp=fileScan.nextLine(); //scan in line by line
      message+=temp+"<br>";     //adds html to break lines
      
    }
    
    message+="</center></html>"; //close tags
    setLayout (new GridLayout (2,1,0,70));
    
    
    JLabel instructions = new JLabel(message); //add text to label
    instructions.setForeground(Color.white); //make visible by setting text white
    JButton home = new JButton("BACK TO MAIN MENU");
    home.setPreferredSize(new Dimension(200, 40));
    home.addActionListener(new Play());
    JPanel butContain = new JPanel();
    butContain.add(home);
    instructions.setBackground(Color.gray);
    
    add (instructions);  //add to screen
    add (butContain);
  }
  
  
  //-----------------------------------------------------------------
  //  Takes the user back to the main screen
  //----------------------------------------------------------------- 
  private class Play implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      CenterPicture.redraw(1);
      
    }  
  }
}