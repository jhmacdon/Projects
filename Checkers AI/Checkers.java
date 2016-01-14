import java.util.*;

class Checkers{
  Scanner s = new Scanner(System.in);
  String input;
  Board board;
  boolean finished;
  public Checkers(){
    
    finished = false;
    System.out.println("Would you like to move first? (y/n)");
    char ans = s.next().charAt(0);
    System.out.println(ans);
    char c;
    if(ans == 'y' || ans == 'Y') c = 'B';
    else c = 'W';
    board = new Board(c);
    Menu();
  }

  public void Menu(){
    while(!finished){
      System.out.println("Which piece would you like to move?");
      input = s.next();
      int x = Integer.parseInt(input.substring(0, 1));
      int y = Integer.parseInt(input.substring(2, 3));
      System.out.println("Where to?");
      input = s.next();
      int j = Integer.parseInt(input.substring(0, 1));
      int i = Integer.parseInt(input.substring(2, 3));
      Board.Move(x, y, j, i);
    }
  }
}
