public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.equals(abbr)) return true;
        int p1 = 0, p2 = 0;
        while (p1 < word.length() && p2 < abbr.length()) {
        	if (abbr.charAt(p2) >= 'a' && abbr.charAt(p2) <= 'z') {
        		if (word.charAt(p1) != abbr.charAt(p2)) return false;
        		else {
        			p1++; p2++;
        		}
        	} else {
        		int n = 0;
        		if (abbr.charAt(p2) == '0') return false;
        		while (p2 < abbr.length() && abbr.charAt(p2) >= '0' && abbr.charAt(p2) <= '9') {
        			n = n * 10 + abbr.charAt(p2++) - '0';
        		}
        		p1 += n;
        	}
        }
        if (p1 != word.length() || p2 != abbr.length()) return false;
        else return true;
    }
}