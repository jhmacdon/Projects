class Board{
  public static Piece[] pieces;
  public static Piece piece;
  public static char SystemColor;
  public String moves;
  public static int white;
  public static int black;
  
  public Board(char c){
    moves = "";
    SystemColor = c;
    SetBoard();
    PrintBoard();
    white = 12;
    black = 12;
  }

  public static void SetBoard(){
    pieces = new Piece[24];
    //set white
    int count = 0;
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 8; j++){
        if(Check(j, i)){
          pieces[count++] = new Piece(j, i, "White");
        }
      }
    }
    for(int i = 5; i < 8; i++){
      for(int j = 0; j < 8; j++){
        if(Check(j, i)) pieces[count++] = new Piece(j, i, "Black");
      }
    }
  }

  public static boolean Check(int x, int y){
    return (x % 2) != (y % 2);
  }
  
  public static boolean Clear(int x, int y){
    return FindPiece(x, y) == null;
  }

  public static Piece FindPiece(int x, int y){
    for(int i = 0; i < 24; i++){
      if(pieces[i].x == x && pieces[i].y == y) return pieces[i];
    }
    return null;
  }
  
  public static boolean TestPieceColor(int x, int y, char color){
    piece = FindPiece(x, y);
    if(piece != null) return piece.GetColorCode() == color;
    return false;
  }
  
  public static boolean NotTestPieceColor(int x, int y, char color){
    if(x < 0 || x > 7 || y < 0 ||  y > y) return false;
    piece = FindPiece(x, y);
    if(piece != null) return piece.GetColorCode() != color;
    return false;
  }
  
  public static Piece CanJump(int x, int y){
    return CanJump(FindPiece(x, y));
  }
  
  public static boolean InRange(int x){
    return x > -1 && x < 8;
  }
  
  public static boolean InRange(int x, int y){
    return InRange(x) && InRange(y);
  }
  
  public static boolean InRange(int a, int b, int c, int d){
    return InRange(a, b) && InRange(c, d);
  }
  
  
  
  public static Piece CanJump(Piece p){
    if(InRange(p.x - 2, p.y + 2*p.direction)){
      if(NotTestPieceColor(p.x - 1, p.y + 1*p.direction, p.GetColorCode())){
        if(FindPiece(p.x - 2, p.y + 2*p.direction) == null) return FindPiece(p.x - 1, p.y + 1*p.direction);
      }
    }

    if(InRange(p.x + 2, p.y + 2*p.direction)){
      if(NotTestPieceColor(p.x + 1, p.y + 1*p.direction, p.GetColorCode())){
        if(FindPiece(p.x + 2, p.y + 2*p.direction) == null) return FindPiece(p.x + 1, p.y + 1*p.direction);
      }
    }
    
    if(p.king){
      if(InRange(p.x + 2*p.direction, p.y - 2)){
        if(NotTestPieceColor(p.x - 1, p.y - 1*p.direction, p.GetColorCode())){
          if(FindPiece(p.x + 2*p.direction, p.y - 2) == null) return FindPiece(p.x - 1, p.y - 1*p.direction);
        }
      }
      
      if(InRange(p.x + 2, p.y - 2*p.direction)){
        if(NotTestPieceColor(p.x + 1, p.y - 1*p.direction, p.GetColorCode())){
          if(FindPiece(p.x + 2, p.y - 2*p.direction) == null) return FindPiece(p.x + 1, p.y - 1*p.direction);
        }
      }
    }
    return null;
  }
  
  public static void Jump(Piece taker, Piece taken){
    Jump(taker.x, taker.y, taken.x, taken.y);
  }
  
  public static void Jump(int x, int y, int j, int i){
    Piece taken = FindPiece(j, i);
    Piece check = CanJump(x, y);
    if(check == null) System.out.println("Error! Move not allowed");
    else{
      taken.taken = true;
      if(taken.GetColorCode() == 'W') white--;
      else black--;
      Piece taker = FindPiece(x, y);
      taker.x = taker.x + ((taken.x - taker.x) * 2);
      taker.y = taker.y + ((taken.y - taker.y) * 2);
      taken.x = -1;
      taken.y = -1;
      taken = CanJump(taker);
      PrintPieces();
      if(taken != null) Jump(taker, taken); 
    }
    PrintBoard();
  }
  
  public static void Move(int x, int y, int j, int i){
    Piece p = FindPiece(x, y);
    if(Clear(j, i)){
      if(x - j > -2 || x - j < 2){
        if(y - i > -2 || y - i < 2){
          if(i >= 0 || i < 8 || j >= 0 || i < 8){
            p.x = j;
            p.y = i;
            PrintBoard();
          }
        }
      }
    } else {
      Jump(x, y, j, i);
    }
  }
  
  public static void Moves(Piece p){
    Piece taken = CanJump(p);
    if(taken != null){
      //only moves for taking matter
    } else {
      //perform check for moves
    }

  }
  
  public static void FindMoves(){
    for(int i = 0; i < 24; i++){
      if(pieces[i].GetColorCode() == SystemColor){

      }
    }
  }

  public static void PrintBoard(){

    for(int i = 0; i < 8; i++){
      System.out.print("\t"+i);
    }
    System.out.println("\n");
    for(int i = 0; i < 8; i++){
      System.out.print(i+".\t");
      for(int j = 0; j < 8; j++){
        piece = FindPiece(j, i);
        if(piece != null && !piece.taken) System.out.print(piece.GetColorCode() + "\t");
        else System.out.print(".\t");
      }
      System.out.println();
    }
  }
  
  
  public static void PrintPieces(){
    for(int i = 0; i < 24; i++){
      System.out.println(pieces[i].GetColorCode()+" piece @ ("+pieces[i].x+", "+pieces[i].y +")");
    }
  }
}
