//backtrack
//改进：用特殊字符mask “＃”代替vis数组
public class Solution {
    int[] xc = {0, 0, 1, -1};
    int[] yc = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                if (dfs(board, word, i, j, 1)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int cur) {
        if (cur == word.length()) return true;
        char tmp = board[i][j];
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int x = i + xc[k];
            int y = j + yc[k];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '#' || board[x][y] != word.charAt(cur)) continue;
            if (dfs(board, word, x, y, cur+1)) return true;
        }
        board[i][j] = tmp;
        return false;
    }
}



public class Solution {
	int[] changeX = new int[]{1, -1, 0, 0};
	int[] changeY = new int[]{0, 0, -1, 1};
	boolean[][] vis;
    public boolean exist(char[][] board, String word) {
    	vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == word.charAt(0)) {
        			vis[i][j] = true;
        			if (search(board, word, 1, i, j)) return true;
        			vis[i][j] = false;
        		}
        	}
        }
        return false;
    }
    private boolean search(char[][] board, String word, int cur, int xn, int yn) {
    	if (cur == word.length()) return true;
    	for (int i = 0; i < 4; i++) {
    		int x = xn + changeX[i];
    		int y = yn + changeY[i];
    		if (x >= 0 && x < board.length && y >=0 && y < board[0].length && !vis[x][y] && board[x][y] == word.charAt(cur)) {
    			vis[x][y] = true;
    			if (search(board, word, cur+1, x, y)) return true;
    			else vis[x][y] = false;
    		}
    	}
    	return false;
    }
}

/*地雷：
1. 忘记vis数组；
2. 二维数组坐标变化时忘记check边界；*/
























