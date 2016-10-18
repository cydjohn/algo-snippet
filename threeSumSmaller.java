//two pointers 
//这道题不考虑重复的组合
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
        	if (i > 0 && nums[i] == nums[i-1]) continue;
        	int j = i+1, k = nums.length-1;
        	while (j < k) {
        		if (nums[i] + nums[j] + nums[k] < target) {
        			res += j - i;
        			i++;
        		} 
        		else j--;
        	}
        }
        return res;
    }
}