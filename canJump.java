//Greedy O(n^2)
public class Solution {
    public boolean canJump(int[] nums) {
	    for (int i = 0; i < nums.length-1; i++) {
	    	if (nums[i] > 0) continue;
	    	boolean ok = false;	
	    	for (int j = 1; j <= i; j++) {
	    		if (nums[i-j] > j) {
	    			ok = true;
	    			break;
	    		}
	    	}
	    	if (!ok) return false; 
	    }
	    return true;
    }
}

//Backtracking (Time Limit Exceeded)
public class Solution {
    boolean ok = false;
    public boolean canJump(int[] nums) {
        search(nums, 0);
        return ok;
    }
    private void search(int[] nums, int cur) {
        if (cur >= nums.length - 1) {
            ok = true;
            return;
        }
        for (int i = nums[cur]; i > 0; i--) {
            search(nums, cur + i);
            if (ok) return;
        }
    }
}

