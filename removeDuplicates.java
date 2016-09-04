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