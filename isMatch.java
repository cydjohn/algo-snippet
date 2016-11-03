//如果p的第二位为＊，且s,p的第一位相同或者P的第一位为.，则遮两位可以跳过；
//如果后续的位不match，则可能s存在多个相同的位，则将s的后续位与p继续比较；
//如果如果s p的第一位不match，则可以用＊跳过该位，直接比较s+2与p+2；
//找个方法时间复杂度高，因为在不断地创建substring
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (p.length() == 0) return false;
        int slen = s.length(), plen = p.length();
        if (plen > 1 && p.charAt(1) == '*') {
            while (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                if (isMatch(s, p.substring(2))) return true;
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        } else if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }
}

//DP
/*1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*': 
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (p.length() == 0) return false;
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen+1][plen+1];
        dp[0][0] = true;
        for (int i = 0; i <= p.length(); i++) {
        	if (p.charAt(i) == '*' && dp[0][i-1]) dp[0][i] = true;
        	else break;
        }
        for (int i = 0; i < slen; i++) {
        	for (int j = 0; j < plen; j++) {
        		if (p.charAt(j) == '*') {
        			if (p.charAt(i-1) == '.' || s.charAt(i-1) == p.charAt(i-1)) {
        				dp[i+1][j+1] = dp[i][j+1];
        			} else {
        				dp[i+1][j+1] = dp[i+1][j-1];
        			}
        		} else if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)){
        			dp[i+1][j+1] = dp[i][j];
        		} else {
        			dp[i+1][j+1] = false;
        		}
        	}
        }     
        return dp[slen][plen];    
    }
}

//dp
/*关键在于如何处理这个'*'号。

状态：和Mininum Edit Distance这类题目一样。
dp[i][j]表示s[0:i-1]是否能和p[0:j-1]匹配。

递推公式：由于只有p中会含有regular expression，所以以p[j-1]来进行分类。
p[j-1] != '.' && p[j-1] != '*'：dp[i][j] = dp[i-1][j-1] && (s[i-1] == p[j-1])
p[j-1] == '.'：dp[i][j] = dp[i-1][j-1]

而关键的难点在于 p[j-1] = '*'。由于星号可以匹配0，1，乃至多个p[j-2]。
1. 匹配0个元素，即消去p[j-2]，此时p[0: j-1] = p[0: j-3]
dp[i][j] = dp[i][j-2]

2. 匹配1个元素，此时p[0: j-1] = p[0: j-2]
dp[i][j] = dp[i][j-1]

3. 匹配多个元素，此时p[0: j-1] = { p[0: j-2], p[j-2], ... , p[j-2] }
dp[i][j] = dp[i-1][j] && (p[j-2]=='.' || s[i-2]==p[j-2])
*/

























