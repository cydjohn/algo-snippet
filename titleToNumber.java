public class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        for (char ch : s.toCharArray()) {
            ans *= 26;//先乘以26，因为最高次为s.length()-1，而起始为0，第一次0*26=0
            ans += ch - 'A' + 1;
        }
        return ans;
    }
}