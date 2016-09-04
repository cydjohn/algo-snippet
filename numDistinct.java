/*题目给定两个字符串，选择只可以用删除字符的方法从第一个字符串变换到第二个字符串，求出一共有多少种变换方法；
又是动态规划思想应用的典型题目。
定义二维数组dp[i][j]为字符串s[0,i)变换到t[0,j)的变换方法。
如果S[i]==T[j]，那么dp[i][j] = dp[i-1][j-1] + dp[i-1][j]。意思是：如果当前S[i]==T[j]，那么当前这个字母即可以保留也可以抛弃，所以变换方法等于保留这个字母的变换方法加上不用这个字母的变换方法。
如果S[i]!=T[i]，那么dp[i][j] = dp[i-1][j]，意思是如果当前字符不等，那么就只能抛弃当前这个字符。
递归公式中用到的dp[0][0] = 1，dp[i][0] = 0（把任意一个字符串变换为一个空串只有一个方法） */
public class Solution {
    public int numDistinct(String s, String t) {
        /*+1的原因是避免复杂初始讨论,如果dp[i][j]表示s[0,i]映射到t[i,j]，为使用dp loop，必须先计算dp[i][0], dp[0][j],后者为0，而前者则需要知道s是否包含t的第一个元素以及在哪些index包含该元素，比较麻烦，所以这里dp[i][j]为字符串s[0,i)，即长度为i,变换到t[0,j),即长度为j, 的变换方法。*/
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            /*把任意一个字符串变换为一个空串只有一个方法*/
            dp[i][0] = 1; 
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) ==  t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}

