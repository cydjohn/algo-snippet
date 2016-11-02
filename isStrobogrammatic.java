public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return false;
        int n = num.length();
        for (int i = 0; i <= num.length()/2; i++) {
            char ch = num.charAt(i);
            if ((ch == '0' || ch == '1' || ch == '8') && num.charAt(n-1-i) == ch) continue;
            else if (ch == '6' && num.charAt(n-1-i) == '9') continue;
            else if (ch == '9' && num.charAt(n-1-i) == '6') continue;
            else return false;
        }
        return true;
    }
}