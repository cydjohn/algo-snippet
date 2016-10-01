public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        int idx = (a >= 0 ? j : i);
        while (i <= j) {
        	if (a >= 0) {
        		res[idx--] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
        	} else {
        		res[idx++] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[j--], a, b, c) : quad(nums[i++], a, b, c);
        	}
        }
        return res;
    }
    private int quad(int x, int a, int b, int c) {
    	return a * x * x + b * x + c;
    }
}