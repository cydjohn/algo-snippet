//return the minimum removal to form a palinrome string
/*Let dp[i, j] = minimum number of removals needed to convert the substring [i, j] to a palindrome. We have:

dp[i, i] = 0 for all i (every single character is a palindrome)
To find dp[i, j], let's consider a random string. We have two possibilities:

The first and last characters are equal: a[i] == a[j]. In this case, we can reduce the problem to finding the minimum number of characters that need to be deleted in order to make the substring [i+1, j-1] a palindrome.
The first and last characters are not equal: a[i] != a[j]. In this case, we need to remove one of them. We'll remove that which leads us to a better solution.*/
public class Solution {
	public static int removeToPalindrome(String s) {
		if (s == null || s.length() < 2) return 0;
		char[] chs = s.toCharArray();
		int[][] dp = new int[s.length()][s.length()];
		for (int i = s.length()-2; i >= 0; i--) {
			for (int j = i+1; j < s.length(); j++) {
				if (chs[i] == chs[j]) dp[i][j] = dp[i+1][j-1];
				else dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) + 1;
			}
		}
		return dp[0][s.length()-1];
	}
	public static void main(String[] args) {
		String s = "acbbc";
		System.out.println(removeToPalindrome(s));
	}
}