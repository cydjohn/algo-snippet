//BS
public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        //find whether part of nums the target is located
        boolean inRight = (target <= nums[n-1]);
        while (l < n-1 && nums[l] == nums[n-1]) l++;
        while (l <= r) {
        	int m = l + (r - l)/2;
        	if (nums[m] == target) return m;
        	if (nums[m] > target) {
        		//[4,5,6,7|0,1,2] 1
        		if (inRight && nums[m] > nums[n-1]) l = m + 1;
        		else r = m - 1;
        	}
        	else {
        		//[4,5,6,7|0,1,2] 5
        		if (!inRight && nums[m] <= nums[n-1]) r = m - 1;
        		else  l = m + 1;
        	}
        }
        return -1;
    }
}

//recurssive BS
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        int end = nums[hi];
        if (target > end) return binarySearchLeft(nums, lo, hi, end, target);
        else return binarySearchRight(nums, lo, hi, end, target);
    }
    private int binarySearchLeft(int[] nums, int lo, int hi, int end, int target) {
    	if (lo > hi) return -1;
    	int mid = (lo + hi)/2;
    	if (nums[mid] == target) return mid;
    	else if (nums[mid] > target) hi = mid - 1;
    	else if (nums[mid] > end) lo = mid + 1;
    	else hi = mid - 1;
    	return binarySearchLeft(nums, lo, hi, end, target);
    }
    private int binarySearchRight(int[] nums, int lo, int hi, int end, int target) {
    	if (lo > hi) return -1;
    	int mid = (lo + hi)/2;
    	if (nums[mid] == target) return mid;
    	else if (nums[mid] < target) lo = mid + 1;
    	else if (nums[mid] > end) lo = mid + 1;
    	else hi = mid - 1;
    	return binarySearchRight(nums, lo, hi, end, target);
    }
}



