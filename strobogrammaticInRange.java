public class Solution {
	char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
	int cnt = 0;
    public int strobogrammaticInRange(String low, String high) {
        for (int len = low.length(); len <= high.length(); len++) {
        	backtrack(low, high, 0, len - 1, new char[len]);
        }
        return cnt;
    }
    private void backtrack(String low, String high, int left, int right, char[] c) {
    	if (left > right) {
    		String s = new String(c);
    		if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) return;
    		cnt++;
    		return;
    	}
    	for (char[] p : pairs) {
    		c[left] = p[0];
    		c[right] = p[1];
    		if (c.length != 1 && c[0] == '0') continue;
    		if (left < right || (left == right && p[0] == p[1])) {
    			backtrack(low, high, left+1, right-1, c);
    		}
    	}
    }
}