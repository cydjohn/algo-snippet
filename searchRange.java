public class Solution {
	int left = -1;
	int right = -1;
    public int[] searchRange(int[] nums, int target) {
        binarySearch(nums, 0, nums.length-1, target);
        return (new int[]{left, right});
    }
    private void binarySearch(int[] nums, int start, int end, int target) {
    	if (start > end) return;
    	int mid = start + (end - start)/2;
    	if (target == nums[mid] && (mid == 0 || target > nums[mid-1])) left = mid;
    	if (target == nums[mid] && (mid == nums.length-1 || target < nums[mid+1])) right = mid;
    	if (target <= nums[mid]) binarySearch(nums, start, mid-1, target);
    	if (target >= nums[mid]) binarySearch(nums, mid+1, end, target);
    }
}

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = leftEnd(nums, target, 0, nums.length-1);
        int r = rightEnd(nums, target, 0, nums.length-1);
        if (l >=0 && l < nums.length && r >=0 && r < nums.length && nums[l] == target && nums[r] == target) return (new int[]{l, r}); //range might not be found in nums, and l, r might go out of the size of nums due to "r = m - 1" and "l = m + 1"
        else return (new int[]{-1, -1});
    }
    private int leftEnd(int[] a, int t, int l, int r) {
    	while (l <= r) {
    		int m = l + (r - l)/2;
    		if (a[m] >= t) r = m - 1;
    		else l = m + 1;
    	}
    	return l;
    }
    private int rightEnd(int[] a, int t, int l, int r) {
    	while (l <= r) {
    		int m = l + (r - l)/2;
    		if (a[m] <= t) l = m + 1;
    		else r = m - 1;
    	}
    	return r;
    }   
}

//ubiquitous BS version
public class Solution {
    public int[] searchRange(int[] nums, int target) {
    	/* the boundary conditions here are:
    	1) what if the left-most element is the same as the key
        2) what if the right-most element is the same as the key
        to give correct output in the 1st condition, the getLeftPosition method needs to be passed the second parameter as "-1". If we'd pass l = 0 and r = size - 1, then the getLeftPosition will come down to l=0 and r=1 and will return index 1 as output, where it should've returned 0, this is due to the while loop condition (r - l > 1)similarly, to meet the second boundary condition mentioned above, we need to pass r = size instead of size-1 in getRightPosition method.*/
        int l = leftEnd(nums, target, -1, nums.length-1);
        int r = rightEnd(nums, target, 0, nums.length);
        if (nums[l] == target && nums[r] == target) return (new int[]{l, r}); //l, r won't go out the size of nums, since l, r are changed only by assign mid to them.
        else return (new int[]{-1, -1});
    }
    //Invariant: A[r] >= key and A[l] < key
    private int leftEnd(int[] a, int t, int l, int r) {
    	while (r - l > 1) {
    		int m = l + (r - l)/2;
    		if (a[m] >= t) r = m;
    		else l = m;
    	}
    	return r;
    }
    //Invariant: A[l] <= key and A[r] > key
    private int rightEnd(int[] a, int t, int l, int r) {
    	while (r - l > 1) {
    		int m = l + (r - l)/2;
    		if (a[m] <= t) l = m;
    		else r = m;
    	}
    	return l;
    }   
}