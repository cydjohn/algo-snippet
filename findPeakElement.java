//BS O(logn)
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        /*discuss corner cases first to ensure nums[m], nums[m+1], nums[m-1] always make sense in BS loop.*/
        if (n == 1) return 0; 
        if (nums[0] > nums[1]) return 0;
        if (nums[n-1] > nums[n-2]) return n-1;
        int l = 1, r = n - 2;
        while (l <= n) {
            int m = l + (r - l)/2;
            if (nums[m] > nums[m+1] && nums[m] > nums[m-1]) return m;
            if (nums[m] < nums[m+1]) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}



