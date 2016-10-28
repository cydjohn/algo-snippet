//DFS + memorization
public class Solution {
    Map<String, List<String>> map = new HashMap();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String w : wordDict) {
            if (s.startsWith(w)) {
                List<String> sublist = wordBreak(s.substring(w.length()), wordDict);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

//backtrack (TLE)
public class Solution {
	List<String> res = new ArrayList();
	List<String> list = new ArrayList();
	Set<String> set = new HashSet(); 
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0) return res;
        backtract(s, wordDict, 0);
        return res;
    }
    private boolean backtract(String s, Set<String> wordDict, int cur) {
    	if (cur == s.length()) {
    		StringBuilder sb = new StringBuilder();
    		for (String l : list) {
    		    sb.append(l);
    		    sb.append(" ");
    		}
    		res.add(sb.toString().trim());
    		return true;
    	}
        if (cur > s.length()) return false;
    	if (set.contains(s.substring(cur))) return false;
    	for (int i = cur; i < s.length(); i++) {
    		String tmp = s.substring(cur, i+1);
    		if (wordDict.contains(tmp)) {
    		    list.add(tmp);
    			if (!backtract(s, wordDict, i+1)) set.add(s.substring(i+1));
    			list.remove(list.size()-1);
    		}
    	}
        return true;
    }
}


































