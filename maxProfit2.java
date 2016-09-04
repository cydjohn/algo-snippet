//122. Best Time to Buy and Sell Stock II
//allow one transition per day
public class Solution {
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
    	int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
        	/*if sell at (i-1), we could simply change the selling date to (i) and increase the profit; if buy at (i-1), and sell at (i), the function still valid.*/
        	if (prices[i] > prices[i-1]) dp[i] = dp[i-1] + prices[i] - prices[i-1]; //sell
        	else dp[i] = dp[i-1]; //buy 
        	/*the above two lines could be also written as
        	dp[i] = Math.max(dp[i-1], prices[i]-prices[i-1]+dp[i-1]);
        	the first part is buy, and second part is sell.*/
        	if (max < dp[i]) max = dp[i];
        }
        return max;
    }
}

//Followup Question
//允许sell无限多次，但是每次sell都要给3$的代价，问说如何获得最大的profit
