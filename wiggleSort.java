//https://leetcode.com/discuss/92421/average-time-space-solution-using-quick-select-find-median
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length == 0) return;
        int median = findKthLargest(nums, (nums.length+1)/2); //O(N)
    }
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums.length == 0) return 0;
        return getKth(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    private int getKth(int[] nums, int start, int end, int k) {
    	int pivot = nums[end];
    	int left = start;
    	int right = end;
    	while (true) {
    		while (left < right && nums[left] < pivot) {
    			left++;
    		}
    		while (left < right && nums[right] >= pivot) {
    			right--;
    		}
    		if (left == right) break;
    		swap(nums, left, right);
    	}
    	swap(nums, left, end);
    	if (k == left + 1) return pivot; //why left+1 here?
    	else if (k < left + 1) return getKth(nums, start, left-1, k);
    	else return getKth(nums, left+1, end, k);
    }
    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}