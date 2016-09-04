//BS
public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] > nums[nums.length-1]) l = m + 1;
            else r = m - 1;
        }
        return nums[l];
    }
}

//uniquitous BS
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int start = 0; 
        int end = nums.length-1;
        while (start+1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] < nums[end]) end = mid;
            else start = mid;
        }
        return Math.min(nums[start], nums[end]);
    }
}


//recurssive BS
public class Solution {
    public int findMin(int[] nums) {
    	if (nums.length == 1) return nums[0];
    	int ret = binarySearch(nums, 0, nums.length-1);
        return ret;
    }
    private int binarySearch(int[] nums, int start, int end) {
    	if (start+1 >= end) return Math.min(nums[start], nums[end]);
    	int mid = start + (end - start)/2;
    	if (nums[mid] < nums[end]) end = mid;
    	else start = mid;
    	return binarySearch(nums, start, end);
    }
}



