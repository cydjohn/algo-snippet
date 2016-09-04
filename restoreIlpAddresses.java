public class Solution {
	List<String> res = new ArrayList();
	String[] a = new String[4];
    public List<String> restoreIpAddresses(String s) {
        search(s, 0, 0);
        return res;
    }
    private void search(String s, int cur, int start) {
    	if (cur == 4) {
    		if (start == s.length()) res.add(a[0] + "." + a[1] + "." + a[2] + "." + a[3]);
    		return;
    	}
    	else {
    		for (int i = start+1; i <= s.length() && i < start+4; i++) {
    		    a[cur] = s.substring(start, i);
    		    int num = Integer.parseInt(a[cur]);
    		    if (hasExtraZeros(a[cur], num)) return;
    		    if (num <= 255) search(s, cur+1, i);
    	    }
    	}
    }
    private boolean hasExtraZeros(String s, int num) {
    	if (num != 0 && s.charAt(0) == '0') return true;
    	else if (num == 0 && s.length() > 1) return true;
    	else return false;
    }
}