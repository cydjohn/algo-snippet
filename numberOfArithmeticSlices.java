//dp O(n)
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int[] dp = new int[A.length];//dp[i]表示以第i位为结尾时答案
        int[] len = new int[A.length];//len[i]表示以第i位为结尾时的最长的slice长度
        if (A[2] - A[1] == A[1] - A[0]) {//初始化
        	dp[2] = 1;
        	len[2] = 3;
        } else {
            len[2] = 2;
        }
        for (int i = 3; i < A.length; i++) {
        	if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
        		dp[i] = dp[i-1] + len[i-1] - 1;
        		len[i] = len[i-1] + 1;
        	} else {
        		dp[i] = dp[i-1];
        		len[i] = 2;
        	}
        }
        return dp[A.length-1];
    }
}