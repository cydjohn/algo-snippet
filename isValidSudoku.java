public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> s = new HashSet();
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
        	s.clear();
        	for (int j = 0; j < col; j++) {
        		if (board[i][j] == '.') continue;
        		if (!s.add(board[i][j])) return false;
        	}
        }
        for (int j = 0; j < col; j++) {
        	s.clear();
        	for (int i = 0; i < row; i++) {
        		if (board[i][j] == '.') continue;
        		if (!s.add(board[i][j])) return false;
        	}
        }
        for (int x = 0; x < row; x += 3) {
        	for (int y = 0; y < col; y += 3) {
        		s.clear();
        		for (int i = x; i < x+3; i++) {
        			for (int j = y; j < y+3; j++) {
        				if (board[i][j] == '.') continue;
        		        if (!s.add(board[i][j])) return false;
        			}
        		}
        	}
        }
        return true;
    }
}