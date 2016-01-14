class Piece{
  public boolean king;
  public boolean taken;
  public int x;
  public int y;
  public String color;
  public int direction;

  public Piece(int x_coord, int y_coord, String c){
    x = x_coord;
    y = y_coord;
    color = c;
    
    if(c.equals("White")) direction = 1;
    else direction = -1;
    king = false;
    taken = false;
  }

  public char GetColorCode(){
    return color.charAt(0);
  }
  
  public boolean Is(char a){
    return (a == color.charAt(0));
  }

}
