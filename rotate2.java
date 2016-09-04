//189. Rotate Array
//two-pass reverse O(n)time O(1)space
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1); //garentee the first kth elements are put at the end of array
        reverse(nums, 0, k-1); //reverse the first kth elemnet to original order
        reverse(nums, k, nums.length-1);
    }
    private void reverse(int[] nums, int start, int end) {
    	int p1 = start, p2 = end;
    	while (p1 < p2) {
    		int temp = nums[p1];
    		nums[p1] = nums[p2];
    		nums[p2] = temp;
    		p1++; p2--;
    	}
    }
}

//solution2 : O(n)time O(n)space -->on-pass traversal starting from k
//solution3 : 
