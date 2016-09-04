public class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	int cloest = Integer.MAX_VALUE;
    	int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
        	if (i>0 && nums[i] == nums[i-1]) continue;
        	for (int j = i+1, k = nums.length-1; j < k;) {
        		int sum = nums[i] + nums[j] + nums[k];
        		if (Math.abs(sum - target) < cloest) {
        			cloest = Math.abs(sum - target);
        			res = sum;
        		}
        		if (sum > target) k--;
        		else if (sum < target) j++;
        		else return res;
        	} 
        }
        return res;
    }
}