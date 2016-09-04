//One-pass O(n)
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int ptr = 0;
        while (ptr < nums.length) {
        	if (nums[ptr] == target) return ptr;
        	else if (target > nums[ptr]) ptr++;
        	else return ptr;
        }
        return nums.length;
    }
}

//interative BinarySearch O(nlogn)
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
        	int m = l + (r - l)/2;
        	if (nums[m] == target) return m;
        	if (nums[m] < target) l = m + 1;
        	else r = m - 1;
        }
        return l;
    }
}

//recurssive BS
public class Solution {
    public int searchInsert(int[] nums, int target) {
    	int idx = binarySearchInsert(nums, 0, nums.length-1, target);
    	return idx >= 0 ? idx : -idx;
    }
    private int binarySearchInsert(int[] nums, int start, int end, int target) {
    	if (start > end) return -start;
    	int mid = start + (end - start)/2;
    	if (target == nums[mid]) return mid;
    	if (target < nums[mid]) return binarySearchInsert(nums, start, mid-1, target);
    	else return binarySearchInsert(nums, mid+1, end, target);
    }
}


