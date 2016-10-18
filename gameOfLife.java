//考察要点：2-D array in-place temmporary storage
//O(n^2) 2-d circular traversal
public class Solution {
	int[] changeX = {-1, 0, 0, 1, 1, 0, 0, -1};
	int[] changeY = {-1, 1, 1, 0, 0, -1, -1, 0};
    public void gameOfLife(int[][] board) {
    	if (board.length == 0 || board[0].length == 0) return;
        int[][] live = new int [board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
        	for (int j = 0; j < board[0].length; j++) {
        		live[i][j] = calculate(board, i, j);
        	}
        }
        for (int i = 0; i < board.length; i ++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == 1 && (live[i][j] < 2 || live[i][j] > 3)) board[i][j] = 0;
        		else if (board[i][j] == 0 && live[i][j] == 3) board[i][j] = 1;
        	}
        }
    }
    private int calculate(int[][] board, int i, int j) {
    	int x = i, y = j, res = 0;
    	for (int k = 0; k < 8; k++) {
    		x += changeX[k];
    		y += changeY[k];
    		if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 1) res++;
    	}
    	return res;
    }
}

/*改进：题目要求in-place，需要去除live[][]的使用，也就是说我们在board本身在calculate的过程中做相应的mark,既不影响后续的calculate也方便traversal后根据mark来得出结果。
0 -> 0 : 0 (even)
0 -> 1 : 3 (odd)
1 -> 1 : 1 (odd)
1 -> 0 : 2 (even)
则最后可以通过模2来得出结果。*/
public class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        m = board.length; n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = calculate(board, i, j);
            }
        } 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        } 
    }
    private int calculate(int[][] board, int x, int y) {
        int sum = 0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (i < 0 || i >= m || j < 0 || j >= n || (i == x && j == y)) continue;
                if (board[i][j] == 1 || board[i][j] == 2) sum += 1;
            }
        }
        if (board[x][y] == 1 && (sum < 2 || sum > 3)) return 2;
        else if (board[x][y] == 0 && sum == 3) return 3;
        else return board[x][y];
    }
}




























