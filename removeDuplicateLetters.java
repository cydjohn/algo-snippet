//https://discuss.leetcode.com/topic/32259/java-solution-using-stack-with-comments/3
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] res = new int[26];
        boolean[] present = new boolean[26];
        char[] ch = s.toCharArray();
        for (char c : ch) res[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
        	int idx = c - 'a';
        	res[idx]--;
        	if (present[idx]) continue;
        	while (sb.length() > 0 && c < sb.charAt(sb.length()-1) && res[sb.charAt(sb.length()-1) - 'a'] > 0) {
        		present[sb.charAt(sb.length()-1) - 'a'] = false;
        		sb.deleteCharAt(sb.length()-1);
        	}
        	sb.append(c);
        	present[idx] = true;
        }
        return sb.toString();
    }
}