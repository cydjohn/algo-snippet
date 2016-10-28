public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        Arrays.sort(nums);//sort is not essential here, but using it will enable us to get out of the loop in line 12, which improve performance
        for (int i = 1; i <= target; i++) {
        	for (int n : nums) {
        		if (i - n >= 0) {
        			dp[i] += dp[i - n];
        		} 
        		else break;
        	}
        }
        return dp[target];
    }
}

//Wrong Answer:
//注意循环的顺序
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int n : nums) {
            for (int i = n; i <= target; i++) {
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }
}

