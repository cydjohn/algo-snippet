//backtrack (TLE)
public class Solution {
	List<String> res = new ArrayList();
	List<String> list = new ArrayList();
	Map<String, List<String>> map = new HashMap();
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
    	if (set.contains(s.substring(cur))) return false;
    	set.add(s.substring(cur));
    	for (int i = cur; i < s.length(); i++) {
    		String tmp = s.substring(cur, i+1);
    		if (wordDict.contains(tmp)) {
    		    list.add(tmp);
    			if (backtract(s, wordDict, i+1)) ok = true;
    			list.remove(list.size()-1);
    		}
    	}
    }
}