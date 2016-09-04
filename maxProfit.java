//121. Best Time to Buy and Sell Stock
//only one transition for all days
public class Solution {
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
    	int maxProfit = 0;
    	int min = Integer.MAX_VALUE; 
    	for (int i = 0; i < prices.length; i++) {
    		if (prices[i] < min) min = prices[i];
    		else if (prices[i] - min > maxProfit) maxProfit = prices[i] - min;
    	}
    	return maxProfit;	       		
    }
}


//309. Best Time to Buy and Sell Stock with Cooldown is at maxProfix4.java