//dp O(n)
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        /*以当前元素为数组终点的解*/
        int[] dp = new int[n];
        dp[0] = 1; 
        dp[1] = (nums[1] == nums[0]) ? 1 : 2;
        /*前一对元素的符号*/
        int ps = nums[1] - nums[0];
        for (int i = 2; i < n; i++) {
        	/*当前一对元素的符号*/
        	int cs = nums[i] - nums[i-1];
        	/*相邻符号相异*/
        	if ((ps >= 0 && cs < 0) || (ps <= 0 && cs > 0)) {
        		dp[i] = dp[i-1] + 1;
        		ps = cs;
        	}
        	else {
        		/*相邻符号相等或者nums[i] == nums[i-1]*/
        		dp[i] = dp[i-1];
        	}
        }
        return dp[n-1];
    }
}