public class Solution {
	HashMap<Character, String> hm = new HashMap();
    HashSet<String> hs = new HashSet();
    public boolean wordPatternMatch(String pattern, String str) {
        return backtrack(pattern, str, 0, 0, 0);
    }
    private boolean backtrack(String pattern, String str, int s, int e, int cnt) {
    	if (e == str.length() && cnt == pattern.length()) return true;
    	if (e == str.length() || cnt == pattern.length()) return false;
    	char curPat = pattern.charAt(cnt);
    	String curStr = str.substring(s, e+1);
    	if (!hm.containsKey(curPat)) {
    		if (!hs.contains(curStr)) {
    			hm.put(curPat, curStr);
    			hs.add(curStr);
    			if (backtrack(pattern, str, e+1, e+1, cnt+1)) return true;
    			hm.remove(curPat);
    			hs.remove(curStr);
    		}
    	} else {
    		if (hm.get(curPat).equals(curStr)) {
    			if (backtrack(pattern, str, e+1, e+1, cnt+1)) return true;
    		}
    	}
    	return backtrack(pattern, str, s, e+1, cnt);
    }
}