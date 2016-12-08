
class Solution {
  
  public int[][] gameOfLife(int[][] board)
  {
    int rows = board.length;       
    int cols = board[0].length;
    
    int[][] newBoard = new int[rows][cols];
    
    for(int i = 0;i<rows;++i)
    {
      for(int j = 0;j<cols;++j)
      {
        int lives = 0;
        if(i>0)
          lives += board[i-1][j];
        if(i<rows-1)
          lives += board[i+1][j];
        if(j>0)
          lives += board[i][j-1];
        if(j<cols-1)
          lives += board[i][j+1];
        
        if(i>0&&j>0)
          lives += board[i-1][j-1];
        if(i<rows-1&&j<cols-1)
          lives += board[i+1][j+1];
        if(i>0&&j<cols-1)
          lives += board[i-1][j+1];
        if(i<rows-1&&j>0)
          lives += board[i+1][j-1];
        
        
        if(board[i][j]==1)
        {
          if(live<2||lives>3)
            newBoard[i][j] = 0;
          else
            newBoard[i][j] = 1;
        }
        if(board[i][j]==0)
        {
          if(lives==3)
            newBoard[i][j] = 1;
          else
            newBoard[i][j] = 0;
        }
      
      }
    }
    return newBoard;
  }
  
  
  
  // return null if read to the end of file
  // otherwise return the next row of game status
  // as an interger array with 0 and 1
  int[] readRow();
  
  // write an integer array to the file
  // return true if success
  // otherwise return false
  boolean writeRow(int[]);
  
  void gameOfLife()
  {
    int[] prev = null, curr = null, next = null;
    
    int[] row = null;
    while((row = readRow())!=null)
    {
      if(curr==null)
      {
        curr = row;
        continue;
      }
      if(next==null)
      {
        next = row;  
      }
      
      if(prev==null)
      {
        int[][] tempBoard = new int[2][curr.length];
        tempBoard[0] = curr;
        tempBoard[1] = next;
        int[][] nextStateBoard = gameOfLife(tempBoard);
        writeRow(nextStateBoard[0]);
      }
      else
      {
        int[][] tempBoard = new int[3][curr.length];
        tempBoard[0] = prev;
        tempBoard[1] = curr;
        tempBoard[2] = next;
        int[][] nextStateBoard = gameOfLife(tempBoard);
        writerow(nextStateBoard[1]);
      }
        
      prev = curr;
      curr = next;
      next = null;
      
    }
    
    int[][] tempBoard = new int[2][curr.length];
    tempBoard[0] = prev;
    tempBoard[1] = curr;
    int[][] nextStateBoard = gameOfLife(tempBoard);
    writerow(nextStateBoard[1]);
  }
}


// Given a m by n board where each is 1(alive) or 0 (dead)
// If a cell is alive and has 2 or 3 live neighbors it remains alive otherwise it becomes dead.
// If a cell is dead and has exact 3 live neighbors, it becomes alive otherwise it remains dead.
// At most 8 neighbors
// Given current state of the board find next state.