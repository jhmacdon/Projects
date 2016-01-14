import java.io.*;
import java.util.*;
class Player{
  static Scanner s = new Scanner(System.in);
  public static void main(String args[]){
    start();
  }

  public static void start(){
    System.out.println("How many seconds should the computer have per move?");
    Checkers c = new Checkers(2);
    int i = s.nextInt();
    int j = s.nextInt();
    System.out.println("at 2 3:" + c.piece(2,3));
    c.move(2,3,3,2);
    c.print();
    System.out.println(c.canJump(i,j,i+1,j+1));
  }
}
