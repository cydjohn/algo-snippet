public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
        	for (int n : nums) {
        		if (i - n >= 0) {
        			dp[i] += dp[i - n];
        		} 
        		else break;
        	}
        }
        return dp[target];
    }
}