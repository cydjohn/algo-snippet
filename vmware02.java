/*balance array:   找一个数组中某个数， 使得左边和等于右边和   找不到return -1 。  之前那个帖子说用DP 感觉没必要我也没想到呢·· 直接做O（n）的能过*/
public class Solution {
    public int merger(int[] nums) {
    	if (nums.length == 0) return -1;
    	if (nums.length == 1) return 0;
    	int[] sumRight = new int[nums.length];
    	int[] sumLeft = new int[nums.length];
    	for (int i = nums.length - 2; i >= 0; i--) {
    		sumRight[i] = sumRight[i+1] + nums[i+1];
    	}
    	for (int i = 1; i < nums.length; i++) {
    		sumLeft[i] = sumLeft[i-1] + nums[i-1];
    		if (sumLeft[i] == sumRight[i]) return i;
    	}
    	return -1;
    }
}