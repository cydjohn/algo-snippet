public class Solution {
    public String longestPalindrome(String s) {
    	int len = 0;
    	String res = new String();
        for (int i = 0; i < s.length(); i++) {
        	for (int j = s.length()-1; j >= i; j--) {
        		if (len > j-i+1) break;
        		if (isPalindrome(s, i, j)) {
        			len = j-i+1;
        			res = s.substring(i, j+1);
        			break;
        		} 
        	}
        }
        return res;
    }
    private boolean isPalindrome(String s, int i, int j) {
    	while (i < j) {
    		if (s.charAt(i++) != s.charAt(j--)) return false;
    	}
    	return true;
    }
}