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
* CenterPicture.java
*                                         
*******************************************/

import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;

public class CenterPicture extends JPanel
{
  public static int choice=0; //default, will report error if classes do not correctly reference
  static StartUp start = new StartUp();                    
  static GamePanel gp = new GamePanel();
  GridLayout grid = new GridLayout (1,1);
  static JPanel container = new JPanel(); //jpanel which will hold whichever part of the game is
  static WinPanel wp = new WinPanel();                      //running
  static LosePanel lp = new LosePanel();
  
  
  public CenterPicture()
  {
    setLayout (grid);
    setBackground (Color.black);
    add(container);
    container.add (start);  //startup screen
    
  }
  
  
  
  //------------------------------------------------------------------------------
  //   Switch between different panels, remove prior panel, and revalidate/repaint
  //------------------------------------------------------------------------------
  
  public static void redraw(int i)
  {
    choice = i;
    container.removeAll(); //removes what what there already
    container.invalidate();//invalidates the panel
    
    //-----------------------------------
    //   Switch between different panels
    //-----------------------------------
    switch (choice){
      case 1: container.add(start);                   //CASE 1, startup screen
      break;
      case 2: container.add(gp);                      //CASE 2, adds first game panel (main game)
      break;
      case 3: try                                     //CASE 3, instructions
      {
        Instructions instruct = new Instructions();
        container.add(instruct);
      }
      catch(IOException e)
      {
        System.out.println("The file was not loaded correctly"); 
        System.out.println(e);
      }  
      break;
      case 4: container.add(wp);                     //CASE 4, won game
      break;
      case 5: container.add(new GamePanel());        //CASE 5, reset game
      break;
      case 6: container.add(lp);                     //CASE 6, lost game
      break;
      case 7:  try                                   //CASE 7, credits
      {
        Credits credit = new Credits();
        container.add(credit);
      }
      catch(IOException e)
      {
        System.out.println("The file was not loaded correctly");
        System.out.println(e);
      }
      break;
      default: System.out.println("An error has occured. The panel doesn't exist"); //Report error
      break;
    }
    container.revalidate(); //revalidates the panel
    container.repaint();    //repaints the panel
    
  }
  
}