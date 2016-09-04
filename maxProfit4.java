//309. Best Time to Buy and Sell Stock with Cooldown
//allow one transition per day
//After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int len = prices.length;
        int[] sell = new int[len];//sell[i] means must sell at day i
        int[] cooldown = new int[len];//cooldown[i] means day i is cooldown day
        sell[1] = prices[1] - prices[0];
        for (int i = 2; i < len; i++) {
        	cooldown[i] = Math.max(sell[i-1], cooldown[i-1]);
        	sell[i] = prices[i] - prices[i-1] + Math.max(sell[i-1], cooldown[i-2]);
        }
        return Math.max(sell[len-1], cooldown[len-1]);
    }
}