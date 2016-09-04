//198. House Robber
//a straight street 
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
}


//213. House Robber II
//all houses at this place are arranged in a circle
//分类讨论第一个house是否被rob
public class Solution {
    public int rob(int[] nums) {
    	if (nums.length == 0) return 0;
    	if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[] ydp = new int[len];
        int[] ndp = new int[len];
        ydp[0] = nums[0]; ydp[1] = nums[0];
        ndp[0] = 0; ndp[1] = nums[1];
        for (int i = 2; i < len; i++) {
        	if (i == len - 1) ydp[i] = ydp[i-1]; 
        	else ydp[i] = Math.max(nums[i] + ydp[i-2], ydp[i-1]);
        	ndp[i] = Math.max(nums[i] + ndp[i-2], ndp[i-1]);
        }  
        return Math.max(ndp[len-1], ydp[len-1]);
    }
}