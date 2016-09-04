//https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
public class Solution {
    public int maxCoins(int[] nums) {
        int[] a = new int[nums.length+2];
        int n = 1;
        for (int x : nums) a[n++] = x;
        a[0] = a[n++] = 1;
        int[][] dp = new int[n][n]; //exclusive range (left, right)
        for (int k = 2; k < n; k++) { //间隔长度
        	for (int left = 0; left < n-k; left++) {
        		int right = left + k;
        		for (int i = left + 1; i < right; i++) { //断点
        			dp[left][right] = Math.max(dp[left][right], a[left]*a[i]*a[right] + dp[left][i] + dp[i][right]);//why not dp[left][i-1]
        		}
        	}
        }
        return dp[0][n-1];
    }
}

//point:子问题是每个区段内的maxcoins，子问题组合成大问题的方式是a[left]*a[i]*a[right] + dp[left][i] + dp[i][right]
//子问题不能是每次删除的哪一个数使当前收益最大化（greedy），因为之前的结果可以不是之前的最大可能结果。