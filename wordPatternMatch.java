//a more readerable backtracking version
public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        return backtrack(pattern, str, map, 0, 0);
    }
    public boolean backtrack(String pattern, String str, Map<Character, String> map, int cp, int cs) {
        if (cp == pattern.length() || cs == str.length()) {
            if (cp == pattern.length() && cs == str.length()) return true;
            else return false;
        }
        char p = pattern.charAt(cp);
        for (int i = cs; i < str.length(); i++) {
            String substr = str.substring(cs, i+1);
            int matchType = match(p, substr, map);
            if (matchType > 0) {
                if (backtrack(pattern, str, map, cp+1, i+1)) return true;
                if (matchType == 1) map.remove(p);
            }
        }
        return false;
    }
    public int match(char p, String substr, Map<Character, String> map) {
        if (!map.containsKey(p)) {
            if (map.containsValue(substr)) return 0;
            map.put(p, substr);
            return 1;
        } else {
            if (!map.get(p).equals(substr)) return 0;
            else return 2;
        }
    }
}


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











