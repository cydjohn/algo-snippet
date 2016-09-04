//DP O(N^2)
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
        	for (int j = 1; j <= i/2; j++) {
        		dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
        	}
        }
        return dp[n];
    }
}

//O(N)
//https://discuss.leetcode.com/topic/45341/an-simple-explanation-of-the-math-part-and-a-o-n-solution
public class Solution {
    public int integerBreak(int n) {
    	if (n == 2) return 1;
    	if (n == 3) return 2;
    	int res = 1;
    	while (n > 4) {
    		res *= 3;
    		n -= 3;
    	}
    	res *= n;
    	return res;
    }
}