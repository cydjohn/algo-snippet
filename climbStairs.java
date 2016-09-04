public class Solution {
    public int climbStairs(int n) {
    	if (n < 2) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
        	//avoid duplicate caculating: from 1 to 3, if you count +1+1 and +2, the first one with be duplicate with 2+1=3
        	dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}