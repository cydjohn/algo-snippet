//backtrack
public class Solution {
    List<String> res = new ArrayList();
    public List<String> generateAbbreviations(String word) {
        backtrack(word, 0, 0, "");
        return res;
    }
    private void backtrack(String s, int cur, int cnt, String tmp) {
    	if (cur == s.length()) {
    		if (cnt > 0) tmp += cnt;
    		res.add(tmp);
    		return;
    	}
    	backtrack(s, cur+1, cnt+1, tmp);//abbreviate this element.
    	backtrack(s, cur+1, 0, tmp + (cnt > 0 ? cnt : "") + s.charAt(cur));//keep this element.
    }
}