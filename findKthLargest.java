//quick select O(n)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums.length == 0) return 0;
        return getKth(nums, 0, nums.length - 1, nums.length - k);//转化为求从小到达的第kth个数，k从0开始计数
    }
    private int getKth(int[] nums, int start, int end, int k) {
    	int pivot = nums[end];
    	int left = start;
    	int right = end;
    	while (left < right) {
    		while (left < right && nums[left] < pivot) {
    			left++;
    		}
    		while (left < right && nums[right] >= pivot) {
    			right--;
    		}
    		swap(nums, left, right);
    	}
    	swap(nums, left, end);
    	if (k == left) return pivot; 
    	else if (k < left) return getKth(nums, start, left-1, k);
    	else return getKth(nums, left+1, end, k);
    }
    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}