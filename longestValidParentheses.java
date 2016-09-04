public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        s = ")" + s;
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
        	if (s.charAt(i) == ')' && s.charAt(i-dp[i-1]-1) == '(') {
        		dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2];
        	    max = Math.max(max, dp[i]);
        	}
        }
        return max;
    }
}
//https://discuss.leetcode.com/topic/2426/my-dp-o-n-solution-without-using-stack