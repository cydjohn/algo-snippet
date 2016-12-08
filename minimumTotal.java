public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[] prev = new int[n];
        prev[0] = triangle.get(0).get(0);
        if (n == 1) return prev[0];
        int min = Integer.MAX_VALUE;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
        	for (int j = 0; j <= i; j++) {
        		int cur = triangle.get(i).get(j);
        		if (j == 0) dp[j] = prev[j] + cur;
        		else if (j == i) dp[j] = prev[j-1] + cur;
        		else dp[j] = cur + Math.min(prev[j-1], prev[j]);
        		if (i == n-1 && dp[j] < min) min = dp[j]; 
        	}
        	prev = dp.clone();
        }
        return min;
    }
}