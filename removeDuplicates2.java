//insertion + cnt记录重复的次数
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int count = 1, i = 1, len = 1;
        while (i < nums.length) {
        	if (nums[i] != nums[i-1]) {
        		nums[len] = nums[i];
        		len++; count = 1;
        	}else {
        		count++;
        		if (count < 3) {
        			nums[len] = nums[i];
        		    len++;
        		}
        	}
        	i++;
        }
        return len;
    }
}

