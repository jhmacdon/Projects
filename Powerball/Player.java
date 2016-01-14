import java.util.*;

class Player{
  static boolean over = false;
  static List<String> names = new ArrayList<String>();
  static List<Powerball> list = new ArrayList<Powerball>();
  static HashMap<String, Integer> map = new HashMap<String, Integer>();
  static int[] winning_numbers = new int[6];
  public static void main(String args[]){
    menu();
  }
  
  public static void menu(){
    Scanner s = new Scanner(System.in);
    int choice = 0;
    while(!over){
      System.out.println("What would you like to do? (enter number)");
      System.out.println("1.\tAdd Hand");
      System.out.println("2.\tAdd Numbers");
      System.out.println("3.\tNumber of Enteries");
      System.out.println("0.\tExit");
      try{
        choice = s.nextInt();
      } catch(Exception e){
        System.out.println("only numbers allowed here");
        s.nextLine();
        choice = -1;
      }
      switch (choice) {
        case 1: addHand(); break;
        case 2: addNumbers(); break;
        case 3: System.out.println(list.size());break;
        case -1: break;
        case 0: over = true; break;
        default: System.out.println("command not recognized, try again");break;
      }
    }
  }
  
  public static void addHand(){
    Scanner s = new Scanner(System.in);
    System.out.println("Name of the hand:");
    String name = s.nextLine();
    Powerball p = new Powerball(name);
    int[] nums = collectNums();
    for(int i = 0; i < nums.length; i++) p.add(nums[i]);
    list.add(p);
    if(!names.contains(name)) names.add(name);
  }
  
  public static void addNumbers(){
    map.clear();
    winning_numbers = collectNums();
    for(Powerball p:list){
      try{
        map.put(p.name(), map.get(p.name()) + p.check(winning_numbers));
      } catch(NullPointerException e) {
          map.put(p.name(), p.check(winning_numbers));
      }
    }
    
    for(String person:names){
      System.out.println(person+" won $"+map.get(person));
    }
  }
  
  public static int[] collectNums(){
    Scanner s = new Scanner(System.in);
    int[] nums = new int[6];
    for(int i = 0; i < 5; i++){
      System.out.println("Enter number "+i+":");
      nums[i] = s.nextInt();
    }
    System.out.println("Enter the powerball number:");
    nums[5] = s.nextInt();
    return nums;
  }
}