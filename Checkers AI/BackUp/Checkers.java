//red = 1, red king = 3
//black = 2, black king = 4
class Checkers{
  int time = 0;
  int[][] board = new int[8][8];
  int piece_count = 0;
  int[] pieces = new int[24];
  public Checkers(int time){
    //set the board to blank
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        board[i][j] = -1;
      }
    }
    //set red
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 8; j++){
        if(isEven(i,j)){
          board[i][j] = 1;
          pieces[piece_count++] = i*10 + j;
        }
      }
    }
    //set black
    for(int i = 5; i < 8; i++){
      for(int j = 0; j < 8; j++){
        if(isEven(i,j)){
          board[i][j] = 2;
          pieces[piece_count++] = i*10 + j;
        }
      }
    }
    print();
  }
  
  public boolean isEven(int i, int j){
    return (i % 2 != j % 2);
  }
  
  public int dir(int i){
    if(i % 2 == 0) return -1;
    return 1;
  }
  
  public int piece(int i, int j){
    return board[i][j];
  }
  
  public boolean canJump(int i, int j, int x, int y){
    if(board[x][y] < 0) return false;
    if(board[x][y] % 2 == board[i][j] % 2) return false;
    if(board[i][j] < 3){
      if(x - i == 1*dir(board[i][j]) &&  (y - j == 1 || y - j == -1)){
        if(board[x + 1][2 * y - j] == -1) return true;
        return false;
      } else return false;
    } else {
      if((x - i == 1 || x - i == -1) &&  (y - j == 1 || y - j == -1)){
        if(board[x + 1][2 * y - j] == -1) return true;
        return false;
      } else return false;
    }
  }
  
  public boolean move(int i, int j, int x, int y){
    for(int c = 0; c < pieces.length; c++){
      if(pieces[c] == i*10 + j){
        board[x][y] = board[i][j];
        board[i][j] = -1;
        pieces[c] = x*10 + y;
        return true;
      }
    }
    return false;
  }
  
  public void print(){
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        if(board[i][j] < 0) System.out.print(".\t");
        else System.out.print(board[i][j] + "\t");
      }
      System.out.print("\n");
    }
    
    for(int i = 0; i < pieces.length; i++){
      System.out.println("piece at "+pieces[i]);
    }
  }
}