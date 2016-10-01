/*Re-use the array given as input for storing the tails. Always replace larger elements in achieved dp array with smaller elements, because if the larger elements are valid for building a increasing subsequence, then the smaller one must also be valid, and it also provide more possibility for future uses. It is like greedy.*/
public class Solution {
    public int lengthOfLIS(int[] nums) {
    	if (nums.length == 0) return 0;
        int maxLen = 1, idx;
        int[] sub = new int[nums.length];
        sub[0] = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > sub[maxLen-1]) {
                sub[maxLen++] = nums[i];
            }
            /*As this statement is executed only if idx variable is negative (meaning there is no such tail in our DP part of the array at the moment), we use -(idx + 1) to convert it to the right position.*/ 
            else if ((idx = Arrays.binarySearch(sub, 0, maxLen, nums[i])) < 0) {
                sub[-(idx + 1)] = nums[i];//invalid for [2,1,5,7,3]
            }
        }
        return maxLen;
    }
}