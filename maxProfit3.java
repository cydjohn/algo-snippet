//123. Best Time to Buy and Sell Stock III
//at most two transactions for all days
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        int[] dp = new int[n];
        int max = prices[n-1], min = prices[0];
        /* Get the maximum profit with only one transaction
       allowed. After this loop, profit[i] contains maximum
       profit from price[i..n-1] using at most one trans. */
        for (int i = n-2; i >= 0; i--) {
            if (prices[i] > max) max = prices[i];
            // we can get profit[i] by taking maximum of:
            // a) previous maximum, i.e., profit[i+1]
            // b) profit by buying at price[i] and selling at
            //    max_price
            dp[i] = Math.max(dp[i+1], max - prices[i]);
        }
        /* Get the maximum profit with two transactions allowed
       After this loop, profit[n-1] contains the result */
        for (int i = 1; i < n; i++) {
            if (prices[i] < min) min = prices[i];
            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and add
            //    profit of other trans. stored in profit[i]
            dp[i] = Math.max(dp[i-1], dp[i] + prices[i] - min);
        }
        return dp[n-1];
    }
}



//https://leetcode.com/discuss/91739/my-explanation-for-o-n-solution
/*buy1 and *sell1 *are for the first transaction. buy2 and *sell2 *are for the second transaction.
Transition relation:
buy1[i] = max( - prices[i], buy1[i - 1])
sell1[i] = max(buy1[i - 1] + price[i], sell1[i - 1])
buy2[i] = max( sell1[i -1] - prices[i], buy2[i - 1])
sell2[i] = max(buy2[i - 1] + price[i], sell2[i - 1])
use the second equation as a example, 
if (buy1[i] == -prices[i]) buy1[i] + price[i] = -2*prices[i] < 0 <= sell1[i - 1], so sell1[i-1] is selected;
else if (buy1[i] == buy1[i-1]) buy1[i] + price[i] = buy1[i-1] + price[i], it make no difference here.
so it's safe to use
sell1 = Math.max(sell1, buy1 + prices[i]); */
public class Solution {
    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}