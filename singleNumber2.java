//https://discuss.leetcode.com/topic/22821/an-general-way-to-handle-all-this-sort-of-questions
public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
        	ones = (ones ^ nums[i]) & (~twos);
        	twos = (twos ^ nums[i]) & (~ones);
        }
        return ones;
    }
}