public class Solution {
	List<List<String>> res = new ArrayList<>();
	List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return res;
        backtrack(s, 0);
        return res;
    }
    private void backtrack(String s, int cur) {
    	if (cur == s.length()) {
    		res.add(new ArrayList<String>(list));
    		return;
    	}
    	for (int i = cur; i < s.length(); i++) {
    		String sub = s.substring(cur, i+1);
    		if (!isPalindrome(sub)) continue;
    		list.add(sub);
    		backtrack(s, i+1);
    		list.remove(list.size()-1);
    	}
    }
    private boolean isPalindrome(String s) {
    	int i = 0, j = s.length()-1;
    	while (i < j) {
    		if (s.charAt(i++) != s.charAt(j--)) return false;
    	}
    	return true;
    }
}