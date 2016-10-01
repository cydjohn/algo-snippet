//The basic idea is when we have painted the first i houses, and want to paint the i+1 th house, we have 3 choices: paint it either red, or green, or blue. If we choose to paint it red, we have the follow deduction:
//相互依赖关系
public class Solution {
    public int minCost(int[][] costs) {
    	int n = costs.length;
        if (n == 0) return 0;
        //dp[i][j]表示第i个房子用第j种颜色的到现在为止的总价
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
        	dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
        	for (int j = 0; j < 3; j++) {
        		dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + costs[i][j];
        	}
        }
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }
}