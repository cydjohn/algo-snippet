// Just go through the numbers and include those in the result that haven't been included twice already.
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) {
                nums[i++] = n; 
            }
        }
        return i;
    }
}

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

