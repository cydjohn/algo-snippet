public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    	if (s.length() == 0) return 0;
    	int max = 0, len = 0;
        Set<Character> set = new HashTable();
        for (int i = 0; i < s.length(); i++) {
        	if (!set.contains(s.charAt(i))) {
        		if (k > 0) {
        			set.add(s.charAt(i));
        			k--; len++;
        		} else {

        		}
        	}
        }

    }
}