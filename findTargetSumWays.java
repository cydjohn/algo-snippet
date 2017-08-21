/*
要想到DP方法需要再分析一下题目了，乍一看似乎看不出有求最优解的痕迹。
我所熟悉的使用DP场景都是需要求最优解，找最优子结构的。这个问题不明显。
但可以往0-1背包问题上想一想，每个数字为正或为负，同时增一倍，则变为了，每个数字不选，或选2倍。
这就靠到0-1背包上了。则基数就不再是0，而是nums数组中所有数字之和为基数，在此基础上进行选2倍或不选，
目标数字S也相应变为S+Sum。依靠数学公式推论为：设最后选择为正的之和为in，为负的之和为out,则有公式：
in - out = S
in + out = sum
推出：2*in = S + sum
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] *= 2;
        }
        if (sum < S) return 0;
        S += sum;
        int[] dp = new int[S+1];
        dp[0] = 1;
        for (int n : nums) {
        //注意j必须倒序遍历，因为同一个n 不能使用两次在一个序列中，比如有个3，可以获得dp[3]=dp[0],但是不能再次使用使得当前dp[6]=dp[3].
            for (int j = S; j >= 0; j--) {
                if (j >= n) {
                    dp[j] += dp[j-n];
                }
            }
        }
        return dp[S];
    }
}
