public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    private boolean solve(char[][] board, int x, int y) {
    	if (x == 9) return true;
    	int nxtX = (y == 8) ? x+1 : x;
    	int nxtY = (y == 8) ? 0 : y+1; 
    	if (board[x][y] != '.') return solve(board, nxtX, nxtY);
    	for (int i = 1; i <= 9; i++) {
    		board[x][y] = (char)(i + '0');
    		if (isValid(board, x, y)) {
    			if (solve(board, nxtX, nxtY)) return true;
    		}
    		board[x][y] = '.'; //important!会影响回溯过程该节点的再次访问
    	}
    	return false;
    }
    private boolean isValid(char[][] board, int x, int y) {
    	char cur = board[x][y];
    	for (int i = 0; i < 9; i++) {
    		if (cur == board[x][i] && i != y) return false;
    		if (cur == board[i][y] && i != x) return false;
    	}
    	int boxX = x/3*3;
    	int boxY = y/3*3;
    	for (int i = boxX; i < boxX+3; i++) {
    		for (int j = boxY; j < boxY+3; j++) {
    			if (cur == board[i][j] && !(i == x && j == y)) return false;
    		}
    	}
    	return true;
    }
}

//improvement: replace linear-time checking of isValid() by building hashtables for rows, cols, and submatrixs.