//dp
//利用数组dp[i]记录和为i的子数组是否存在，初始令dp[0] = 1
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return true;
        int sum = 0;
        for (int n : nums) {
        	sum += n;
        }
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
        	//j必须逆序遍历，可以保证小的数不会被重复使用，因为每个数只能使用一次
        	for (int j = sum; j >= nums[i]; j--) {
        		dp[j] = dp[j] || dp[j - nums[i]];
        	}
        	if (dp[sum]) break;
        }
        return dp[sum];
    }
}