//http://blog.csdn.net/fly_yr/article/details/50408287
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3) return false;
        if (l1 == 0 && !s2.equals(s3)) return false;
        if (l2 == 0 && !s1.equals(s3)) return false;
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
        	if (s1.charAt(i-1) == s3.charAt(i-1)) dp[i][0] = true;
        	else break;
        }
        for (int i = 1; i <= l2; i++) {
        	if (s2.charAt(i-1) == s3.charAt(i-1)) dp[0][i] = true;
        	else break;
        }
        for (int i = 0; i < l1; i++) {
        	for (int j = 0; j < l2; j++) {
        		if (s1.charAt(i) == s3.charAt(i+j+1))//2+2-1 = 1+1+1
        			dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j+1];
        		if (s2.charAt(j) == s3.charAt(i+j+1))
        			dp[i+1][j+1] = dp[i+1][j] || dp[i+1][j+1];    
        	}
        }
        return dp[l1][l2];
    }
}
