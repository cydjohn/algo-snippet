//insertion
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int j = 1, len = 1;
        while (j < nums.length) {
        	if (nums[j] != nums[j-1]) {
        		nums[len] = nums[j];
        		len++; 
        	}
        	j++;
        }
        return len;
    }
}

//window moving
//不要用swap的方法，因为交换后可能会产生满足nums[j] != nums[j-1]但实际上已经重复的数据，例如［1，1，2，2］