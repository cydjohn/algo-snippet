//https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
/*思路：考虑分治法来处理的时候，如果选择以某个气球为分割点，那么其左边部分和右边部分都要依赖与那个气球，因此我们不能让这个气球先爆．也就是说我们选择分割点的时候不是选择先爆的气球，而是最后爆的气球，这样分成的左右两个部分将相互独立．即如果最后只剩下气球i，那么其最后只依赖与第０和ｎ－１个气球，而在[0, i] 和 [i, n-1]两个区间是相互独立的，这样我们就可以将问题分割为相互独立的子集．这样时间复杂为O(n^n). 但是在枚举各个分割点的时候会有很多重复的计算，因此我们可以保存已经计算过的区间．这样时间复杂度可以优化到O(n^3).*/
//dp bottom to up
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
        			dp[left][right] = Math.max(dp[left][right], a[left]*a[i]*a[right] + dp[left][i] + dp[i][right]);
        		}
        	}
        }
        return dp[0][n-1];
    }
}

//point:子问题是每个区段内的maxcoins，子问题组合成大问题的方式是a[left]*a[i]*a[right] + dp[left][i] + dp[i][right]
//子问题不能是每次删除的哪一个数使当前收益最大化（greedy），因为之前的结果可以不是之前的最大可能结果。