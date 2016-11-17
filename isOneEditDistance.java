public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || s.equals(t) || Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        boolean hasEdited = false;
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
        	if (s.charAt(i) == t.charAt(j)) continue;
        	if (hasEdited) return false;
        	hasEdited = true;
        	if (s.length() < t.length()) i--;
        }
        return true;
    }
}