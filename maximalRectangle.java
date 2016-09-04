//这道题的关键就是先将矩阵转化为数组，算法原型即求直方图的最大面积。
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int max = 0;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) dp[0][j] = (matrix[0][j] == '1') ? 1 : 0;
        for (int i = 1; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == '1') dp[i][j] = dp[i-1][j] + 1;
        	}
        }
        for (int i = 0; i < m; i++) {
        	Stack<Integer> st = new Stack();
        	for (int j = 0; j <= n; j++) {
        		int h = (j == n) ? 0 : dp[i][j];
        		if (st.empty() || h >= dp[i][st.peek()]) st.push(j);
        		else {
        			int tp = st.pop();
        			max = Math.max(max, dp[i][tp] * (st.empty() ? j : j-1-st.peek()));
        			j--;
        		}
        	}
        }
        return max;
    }
}