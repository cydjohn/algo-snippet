/*编辑距离问题： 
编辑距离（Edit Distance），又称Levenshtein距离，是指两个字串之间，由一个转成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。一般来说，编辑距离越小，两个串的相似度越大。

例如将kitten一字转成sitting：
sitten （k→s）
sittin （e→i）
sitting （→g）

俄罗斯科学家Vladimir Levenshtein在1965年提出这个概念。
首先定义这样一个函数——edit(i, j)，它表示第一个字符串的长度为i的子串到第二个字符串的长度为j的子串的编辑距离。
显然可以有如下动态规划公式：
if i == 0 且 j == 0，edit(i, j) = 0
if i == 0 且 j > 0，edit(i, j) = j
if i > 0 且j == 0，edit(i, j) = i
if i ≥ 1  且 j ≥ 1 ，edit(i, j) == min{ edit(i-1, j) + 1, edit(i, j-1) + 1, edit(i-1, j-1) + f(i, j) }
当第一个字符串的第i个字符不等于第二个字符串的第j个字符时，f(i, j) = 1；否则，f(i, j) = 0。*/
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;//dp[i][j]中i, j表示个数，否则难以初始化dp[i][0]，如果表示从第0个数映射成为第i个数，因为第0个数有可能与i+1个数有重叠，需要O(n)的搜索时间。
        for (int i = 0; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {//i,j表示个数
        	for (int j = 1; j <= n; j++) {
        		if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
        		else dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1] + 1);
        	}
        }
        return dp[m][n];
    }
}