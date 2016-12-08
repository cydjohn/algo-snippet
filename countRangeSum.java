public class Solution {
	long[] sum;
	int lo, hi;
    public int countRangeSum(int[] nums, int lower, int upper) {
    	if (nums.length == 0) return 0;
    	sum = new long[nums.length];
    	sum[0] = nums[0];
    	lo = lower; hi = upper;
        for (int i = 1; i < nums.length; i++) {
        	sum[i] = sum[i-1] + nums[i];
        }
        return countNum(nums, 0, nums.length-1);
    }
    private int countNum(int[] nums, int left, int right) {
    	if (left == right) {
    		if (nums[left] >= lo && nums[left] <= hi) return 1;
    		return 0;
    	}
    	int res = 0;
    	int mid = left + (right - left)/2;
    	for (int i = left; i <= mid; i++) {
    		for (int j = mid+1; j <= right; j++) {
    			long curSum = sum[j] - sum[i] + nums[i];
    			if (curSum >= lo && curSum <= hi) res++;
    		}
    	}
    	return res + countNum(nums, left, mid) + countNum(nums, mid+1, right);
    }
}