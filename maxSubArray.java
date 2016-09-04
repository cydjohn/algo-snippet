//intuitive version O(n)
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0, max = Integer.MIN_VALUE;
        for (int n : nums) {
        	sum += n;
        	if (sum > max) max = sum;
        	/*if current sum is negative, we could always a subarray with larger sum by ignoring the negative part.*/
        	if (sum < 0) sum = 0; 
        }
        return max;
    }
}

//dp version
public class Solution {
    public int maxSubArray(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        	if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}

//devide and conquer O(nlogn)
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        return daq(nums, 0, nums.length-1);
    }
    private int daq(int[] nums, int l, int r) {
    	if (l >= r) return nums[l]; 
    	int m = l + (r - l)/2;
    	int left = daq(nums, l, m);
    	int right = daq(nums, m+1, r);
    	int sum = 0;
    	int maxL = Integer.MIN_VALUE, maxR = Integer.MIN_VALUE;
    	/*2-pass traversal to find the left and right end of the mid maxSubArray*/
    	for (int i = m; i >= l; i--) {
    		sum += nums[i]; 
    		if (sum > maxL) maxL = sum;
    	}
    	sum = 0;
    	for (int i = m+1; i <= r; i++) {
    		sum += nums[i];
    		if (sum > maxR) maxR = sum;
    	}
    	int mid = maxL + maxR;
    	return Math.max(mid, Math.max(left, right));	
    }
}

