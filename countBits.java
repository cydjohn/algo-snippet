public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 1; i <= num; i++) {
        	res[i] = res[i >> 1] + (i & 1); //f[i] = f[i / 2] + i % 2
        }
        return res;
    }
}

public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0; 
        if (num > 0) dp[1] = 1;
        int e = 2;
        for (int i = 2; i <= num; i++) {
        	if (i - e == e) e = i; 
        	dp[i] = dp[i - e] + 1;
        }
        return dp;
    }
}