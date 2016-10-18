/*
本题考查字典序排列： O(n)
把升序的排列（当然，也可以实现为降序）作为当前排列开始，然后依次计算当前排列的下一个字典序排列。 
算法思想： 
对当前排列从后向前扫描，找到一对为升序的相邻元素，记为i和j（i < j）。如果不存在这样一对为升序的相邻元素，则所有排列均已找到，算法结束；否则，重新对当前排列从后向前扫描，找到第一个大于i的元素k，交换i和k，然后对从j开始到结束的子序列反转，则此时得到的新排列就为下一个字典序排列。这种方式实现得到的所有排列是按字典序有序的，这也是C++ STL算法next_permutation的思想。
*/
//case: [2,3,1]
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int i = nums.length-2;
        for (; i >= 0; i--) {
        	if (nums[i] < nums[i+1]) break; //找到最右的可以翻转的数
        }
        if (i < 0) {
        	reverse(nums, 0, nums.length-1);
        	return;
        }
        int j = nums.length-1;
        for (; j > i; j--) {
        	if (nums[j] > nums[i]) break;
        }
        swap(nums, i, j);
        reverse(nums, i+1, nums.length-1); //无需排序O(nlogn)，因为这部分是降序排序，只需逆转即可得到升序
        return;
    }
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}