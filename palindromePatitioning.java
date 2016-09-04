//所谓Palindrome,是指从其正反两个方向看都一样,且不区分大小写。
public class Solution {
    public List<List<String>> partition(String s) {
        return search(s, 0);
    }
    private List<List<String>> search(String s, int cur) {
    	List<List<String>> res = new ArrayList();
    	if (cur == s.length()) {
    		List<String> temp = new ArrayList();
    		res.add(temp);
    		return res;
    	}
    	for (int i = cur+1; i <= s.length(); i++) {
    		String str = s.substring(cur, i);
    		if (isParlindrome(str)) {
    			List<List<String>> next = search(s, i);
    			if (next != null) {
    			    for (List<String> t : next) t.add(0, str);
    			    res.addAll(next);
    		    }
    		}
    	}
    	return res;
    }
    private boolean isParlindrome(String s) {
    	int n = s.length();
    	for (int i = 0; i < n/2; i++) {
    		if (s.charAt(i) != s.charAt(n-1-i)) return false;
    	}
    	return true;
    }
}