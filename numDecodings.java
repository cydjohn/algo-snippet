//dp ver2
public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        /*改进1：dp的长度变为length+1，由于dp loop过程中需要dp[i-2]，但是dp[1]的讨论规则与loop中相同，如果在loop外重复则代码重复，所以在前面加上一个dummy node，dp[i]表示以s[i-1]为终点的答案，例如对于“12”，dp[2] = dp[1] + dp[0] = 1 + 1 = 2 */
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
        	String str = s.substring(i-2, i);
        	int num = Integer.parseInt(str);
        	if (num == 10 || num == 20) dp[i] = dp[i-2]; //只有一种分解： "1210"，10与20只有一种表示，因为0没有对应code
        	else if (num % 10 == 0) return 0; //无解："1230"
        	else if (num > 10 && num <= 26) dp[i] = dp[i-1] + dp[i-2]; //存在两种分解：dp("1223") = dp("122+3") + dp("12+23")
        	else  dp[i] = dp[i-1];//只有一种分解：dp("1207") = dp("120+7") 
        }
        return dp[s.length()];
    }
}

//dp ver1
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = (s.charAt(0) == '0') ? 0 : 1;
        if (s.length() == 1) return dp[0];
        int num = Integer.parseInt(s.substring(0, 2));
        if (num > 9 && num < 27 && s.charAt(1) != '0') dp[1] = dp[0] + 1;
        else if (num > 9 && num < 27) dp[1] = 1;
        else if (s.charAt(1) != '0') dp[1] = dp[0];
        else dp[1] = 0;
        
        for (int i = 2; i < s.length(); i++) {
        	num = Integer.parseInt(s.substring(i-1, i+1));
        	if (num > 9 && num < 27 && s.charAt(i) != '0') dp[i] = dp[i-1] + dp[i-2];
        	else if (num > 9 && num < 27) dp[i] = dp[i-2];
            else if (s.charAt(i) != '0') dp[i] = dp[i-1];
            else dp[i] = 0;
        }
        return dp[s.length()-1];
    }
}

