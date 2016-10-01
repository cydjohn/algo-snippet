//backtrack 
//time complexity?
public class Solution {
    Set<String> set = new HashSet();
    public boolean wordBreak(String s, Set<String> wordDict) {
         if (s.length() == 0) return false;
         return backtract(s, wordDict, 0);
    }
    private boolean backtract(String s, Set<String> wordDict, int cur) {
    	if (cur == s.length()) return true;
    	//the only trick is to memorize already checked strings, return false when you meet them in the second time since they didn't have a right answer in the first time.
    	if (set.contains(s.substring(cur))) return false;
    	set.add(s.substring(cur));
    	for (int i = cur; i < s.length(); i++) {
    		String tmp = s.substring(cur, i+1);
    		if (wordDict.contains(tmp) && backtract(s, wordDict, i+1)) {
    			return true;
    		}
    	}
    	return false;
    }
}