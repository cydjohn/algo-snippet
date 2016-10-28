public class Solution {
    public void solve(char[][] board) {
    	if (board == null) return;
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if ((i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1) && board[i][j] == 'O') {
        			dfs(board, i, j);
        		}
        	}
        }
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == '*') board[i][j] = 'O';
        		else board[i][j] = 'X';
        	}
        }
    }

    private void dfs(char[][] board, int i, int j) {
    	if (board[i][j] != 'O') return;
    	board[i][j] = '*';
    	if(i+1 < board.length-1) dfs(board, i+1, j);
    	if(i-1 > 0) dfs(board, i-1, j); 
    	if(j+1 < board[0].length-1) dfs(board, i, j+1);    	
    	if(j-1 > 0) dfs(board, i, j-1);  
    	//can't use (i-1 >= 0), it will cause java.lang.StackOverflowError. Why? https://leetcode.com/discuss/94846/java-6ms-dfs-solution-easy-understand-and-relatively-short  
        //distribute the memory load by ending a recurssion in advance
    	//do not include edges here, because the goal here is to mark all the inner 'O' which are connected with edge 'O', not to travel all the edge 'O', it will run out of stacks if we meet a board[250][250] with 'O's for every elements on the edges.
    }
}