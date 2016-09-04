//dp O(n)
//负负得正使得负的minProduct在乘以一个负数之后有可能变成maxProduct，所以对每一个i当前的maxProduct是minProduct[i-1]*num[i], maxProct[i-1]*num[i], num[i]三者中最大的一个。前两者再过去的product上加入当前num,后一者则抛弃过去的product，已当前num作为subarray的起点，对于有0的数组来说这点很重要。
public class Solution {
    public int maxProduct(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];
        int max = nums[0];
        maxdp[0] = nums[0];
        mindp[0] = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
        	maxdp[i] = Math.max(nums[i], Math.max(maxdp[i-1]*nums[i], mindp[i-1]*nums[i]));
        	mindp[i] = Math.min(nums[i], Math.min(maxdp[i-1]*nums[i], mindp[i-1]*nums[i]));
        	if (maxdp[i] > max) max = maxdp[i];
        }
        return max;      
    }
}

