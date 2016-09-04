//two pointers o(n)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int p1 = 0, p2 = 0, sum = 0, len = 0;
        int minLen = Integer.MAX_VALUE;
        while (p1 < nums.length) {
        	sum += nums[p1];
        	p1++; len++;
        	while (sum - nums[p2] >= s) {
        		sum -= nums[p2];
        		p2++; len--;
        	}
        	if (sum >= s && len < minLen) minLen = len;
        }
        return (minLen == Integer.MAX_VALUE ? 0 : minLen); //the minLen might not exit.
    }
}

//BS O(nlogn)
//search if a window of size k exists that satisfy the condition
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 1, r = nums.length, min = 0;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (windowOK(nums, s, m)) {
                r = m - 1; //decrease window size
                min = m;
            }
            else l = m + 1; //incrementwindow size
        }
        return min;
    }
    private boolean windowOK(int[] nums, int target, int size) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= size) sum -= nums[i - size];
            if (sum >= target) return true;
        }
        return false;
    }
}

//Another O(NLogN) solution that first calculate cumulative sum and then for each starting point binary search for end position. This uses O(N) space to store cumulative sum