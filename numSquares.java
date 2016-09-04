//dp O(n^2)
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE); //用min函数注意初始化MAX_VAL
        dp[0] = 0;
        for (int i = 1; i*i <= n; i++) {//观察发现dp[j]是在最近的完全平方数的基础上加上diff
        	for (int j = i*i; j < dp.length; j++) {
        		dp[j] = Math.min(dp[j], dp[j-i*i]+1);//此处dp[j-i*i]+1不能为（j-i*i)+1，因为如果dp[j-i*i]存在则dp[j-i*i] <=（j-i*i)
        	}
        }
        return dp[n];
    }
}