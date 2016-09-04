public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int[] sub = new int[3];
        sub[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] > sub[len-1]) sub[len++] = nums[i];
        	else {
        		for (int j = 0; j < len; j++) {
        			if (nums[i] <= sub[j]) {
        				sub[j] = nums[i];
        				break;
        			}
        		}
        	}
        	if (len == 3) return true;
        }
        return false;
    }
}