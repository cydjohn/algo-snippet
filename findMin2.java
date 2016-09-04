//BS
public class Solution {
    public int findMin(int[] nums) {
    	int n = nums.length;
        int l = 0, r = n-1;
       /* skip the duplicate num with the same value with nums[n-1], be careful to avoid going out of the right bound of nums.*/
        while (l < n-1 && nums[l] == nums[n-1]) l++; 
        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] > nums[n-1]) l = m + 1;
            else r = m - 1;
        }
        return nums[l];
    }
}

//ubiquitous BS 
public class Solution {
    public int findMin(int[] nums) {
    	if (nums.length == 1) return nums[0];
    	int start = 0; 
    	int end = nums.length-1;
    	while (start < end && nums[start] == nums[end]) start++;
    	while (start+1 < end) {
    		int mid = start + (end - start)/2;
    		if (nums[mid] <= nums[end]) end = mid;
    		else start = mid;
    	}
    	return Math.min(nums[start], nums[end]);
    }
}