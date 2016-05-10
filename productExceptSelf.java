public class Solution {
    public int[] productExceptSelf(int[] nums) {
    	int[] output = new int[nums.length];
    	output[0] = 1;
    	for (int i = 1; i < nums.length; i++) {
    		output[i] = nums[i-1] * output[i-1];    		
    	} 
    	int proRight = 1;
    	for (int k = nums.length-2; k >= 0; k--) {
    	    output[k] *= nums[k+1] * proRight;
    	    proRight *= nums[k+1];	
    	}
        return output;
    }
}