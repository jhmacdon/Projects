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
* MathDriver.java
*                                         
*******************************************/
public class MathDriver
{
  private static double velocity;
  final private static double gravity=0.0096; //this is acceleration due to gravity on 
                                              //the moon for ever 6 milliseconds (refresh rate of game)
  private static double thrusters;
  private static double y=0;
  private static int percent=0;
  private static double fuel;
  private static String message = "";
  private static final double fuelCap=100;
  private static int fuelMax=0;

  
  //-------------------------------------------
  //  Construct parameters
  //-------------------------------------------
  public MathDriver()
  {
    velocity=0;
    thrusters=0;
  }
  
  
  //-------------------------------------------
  //  Resets all parameters
  //-------------------------------------------
  public static void reset()
  {
    velocity=0;
    thrusters=0;
    y=0;
    percent=0;
    fuel=StartUp.newFuel;
  }
  
  
  //-------------------------------------------
  //  Performs calculations for 1 move
  //-------------------------------------------
  public static double calculate()
  {
    velocity = (velocity+gravity-thrusters); //increases velocity per move (or decreases)
    y+=velocity; //changes y by velocity
    
    if(thrusters!=0)     //if thrusters are on,
      fuel-=(double)(0.08);  //reduce fuel in tank
    return (int)y;
  }
  
  
  
  //-------------------------------------------
  //  Adds 10% of total thrust power
  //-------------------------------------------
  public static void addThrust()
  {
    if(fuel!=0){
    thrusters+=0.00192;
    percent++;}
  }
  
  
  //-------------------------------------------
  //  Subtracts 10% of total thrust power
  //-------------------------------------------
  public static void subThrust()
  {
    thrusters-=0.00192;
    percent--;
  }
  
  
  //-------------------------------------------
  //  Returns thrust
  //-------------------------------------------
  public static double getThrust()
  {
    return thrusters;
  }
  
  
  //-------------------------------------------
  //  Returns position w/o recalculating everything
  //-------------------------------------------
  public static double position()
  {
    return (int)y;
  }
  
  //-------------------------------------------
  //  Returns thrust power on a scale of 1-10
  //-------------------------------------------
  public static int getThrustPower()
  {
    return (int)percent;
  }
  
  
  //-------------------------------------------
  //  Returns amount of fuel remaing
  //-------------------------------------------
  public static int fuelAmount()
  {
   return (int)fuel; 
  }
  
  
  //-------------------------------------------
  //  Sets fuel
  //-------------------------------------------
  public static void setFuel(int i)
  {
    fuel = i;
  }
  
  
  //-------------------------------------------
  //  Returns fuel in a string with a percentage
  //-------------------------------------------
  public static String getFuel()
  {
    if(fuel>2)
      message=("Fuel: \n"+(int)((double)fuel/(double)fuelCap*100)+"%     ");
    else
      message=("Fuel: Empty     ");
    return message;
  }
  
  //-------------------------------------------
  //  Returns velocity without recalculating everything
  //-------------------------------------------
  public static double getVelocity()
  {
    return velocity*10;
  }
  
  
  //-------------------------------------------
  //  gets y
  //-------------------------------------------
  
  public static double getY()
  {
    return y;
  }
  
  
  
  //-------------------------------------------
  //  sets y to a number
  //-------------------------------------------
  public static void setY(double i)
  {
    y=i;
  }
  
  
  //-------------------------------------------
  //  Sets thrusters to 0 if fuel runs out
  //-------------------------------------------
  public static void outOfFuel()
  {
    thrusters=0;
  } 
  
}


