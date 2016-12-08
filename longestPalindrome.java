//dynamic programming O(n^2)
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int n = s.length(), ss = 0, max = 1;
        boolean[][] dp = new boolean[n][n];//if substring from i to j is palindrom
        //循环的顺序有很多种，只要保证dp[i][j]计算前,dp[i+1][j-1]被计算过即可
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if ((i+1 >= j-1 || dp[i+1][j-1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        ss = i;
                    }
                }
            }
        }
        return s.substring(ss, ss + max);
    }
}

//brute force O(n^3) -- TLE
public class Solution {
    public String longestPalindrome(String s) {
    	int len = 0;
    	String res = new String();
        for (int i = 0; i < s.length(); i++) {
        	for (int j = s.length()-1; j >= i; j--) {
        		if (len > j-i+1) break;
        		if (isPalindrome(s, i, j)) {
        			len = j-i+1;
        			res = s.substring(i, j+1);
        			break;
        		} 
        	}
        }
        return res;
    }
    private boolean isPalindrome(String s, int i, int j) {
    	while (i < j) {
    		if (s.charAt(i++) != s.charAt(j--)) return false;
    	}
    	return true;
    }
}

