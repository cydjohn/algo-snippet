public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //当k >=n/2时候，相当于第122题。Best Time to Buy and Sell Stock II
        if (k >= n/2) return maxProfit2(prices);
        //dp,设dp[i][j]为第J天进行第i次交易能获取的最大值。
        int[][] dp = new int[k+1][n];
        for (int i = 1; i < k+1; i++) {
        	int maxTemp = -prices[0];
        	for (int j = 1; j < n; j++) {
        		//我们能获取的最大利润，当我们在第j天进行抛售时。由于maxTemp已经算了买进时的价格，所以直接加上即可。
        		dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxTemp);
        		//可以理解为已获得的最大利润，即如果买进第j天的，那么用之前一轮的买卖，前一天的的利润即（dp[i-1][j-1]）减去prices[j]
        		maxTemp = Math.max(maxTemp, dp[i-1][j-1] - prices[j]);
        	}
        }
        return dp[k][n-1];
    }
    private int maxProfit2(int[] prices) {
    	int ans = 0;
    	for (int i = 1; i < prices.length; i++) {
    		if (prices[i] > prices[i-1]) {
    			ans += prices[i] - prices[i-1];
    		}
    	}
    	return ans;
    }
}

































