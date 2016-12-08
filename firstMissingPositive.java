/*思路：交换数组元素，使得数组中第i位存放数值(i+1)。最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)。*/
public class Solution {
    public int firstMissingPositive(int[] nums) {
    	int i = 0;
        while (i < nums.length) {
        	if (nums[i] != i+1 && nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
        		swap(nums, i, nums[i]-1);
        	} else {
        		i++;
        	}
        }
        for (i = 0; i < nums.length; i++) {
        	if (nums[i] != i+1) return i+1;
        }
        return i+1;
    }
    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}