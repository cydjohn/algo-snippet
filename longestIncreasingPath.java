//dfs + dp
/*枚举起点，从每一个单元格出发，递归寻找其最长递增路径。
利用辅助数组dp记录已经搜索过的单元格，dp[x][y]存储从单元格(x, y)出发的最长递增路径长度。*/
public class Solution {
	int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	int[][] dp; //dp[i][j] = length of longest increasing path starting from (i,j)
	int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
    	m = matrix.length; n = matrix[0].length;
        dp = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int len = dfs(matrix, i, j);
        		if (len > max) max = len;
        	}
        }
        return max;
    }
    //update dp[i][j] with postorder dfs
    private int dfs(int[][] matrix, int i, int j) {
    	if (dp[i][j] != 0) return dp[i][j];
    	dp[i][j] = 1;
    	for (int[] dir : dirs) {
    		int x = i + dir[0], y = j + dir[1];
    		if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
    		int len = 1 + dfs(matrix, x, y);
    		if (len > dp[i][j]) dp[i][j] = len;
    	}
    	return dp[i][j];
    }
}