//44. Wildcard Matching
public class Solution {
    public boolean isMatch(String s, String p) {
    	char[] a = s.toCharArray();//a lot of charAt is time-comsuming
    	char[] b = p.toCharArray();
        boolean[][] dp = new boolean[a.length+1][b.length+1];
        dp[0][0] = true;
        for (int j = 1; j <= b.length; j++) {
        	dp[0][j] = dp[0][j-1] && b[j-1] == '*';
        }
        for (int i = 1; i <= a.length; i++) {
        	for (int j = 1; j <= b.length; j++) {
        		if (b[j-1] != '*') {
        			dp[i][j] = (a[i-1] == b[j-1] || b[j-1] == '?') && dp[i-1][j-1];
        		} else {//* could represent 0 char or one or more chars
        			dp[i][j] = dp[i][j-1] || dp[i-1][j];
        		}
        	}
        }
        return dp[a.length][b.length];
    }
}