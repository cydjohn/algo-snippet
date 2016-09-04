//https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
// Time Limit Exceeded
public class Solution {
    public String minWindow(String s, String t) {
    	String res = new String();
    	int ls = s.length(), lt = t.length();
        if (ls < lt) return res;
        if (ls == lt) {
        	if (containsALL(s, t)) return s;
        	else return res;
        }
        for (int i = 0; i < ls-lt+1; i++) {
        	int start = i+lt-1, end = ls-1;
        	while (start <= end) {
        		int mid = (start + end)/2;
        		String str = s.substring(i, mid+1);
        		if (containsALL(str, t)) {
        			end = mid - 1;
        			if (res.length() == 0 || res.length() > str.length()) res = str;
        		}
        		else start = mid + 1;
        	}
        }
        return res;
    }
    private boolean containsALL(String s, String t) {
    	String copy = s;
        for (int i = 0; i < t.length(); i++) {
        	int idx = copy.indexOf(t.charAt(i));
        	if ( idx < 0) return false; 
        	else copy = copy.substring(0, idx) + copy.substring(idx+1);
        }
        return true;
    }
}