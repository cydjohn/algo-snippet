//two pointer + array hashtable O(n)
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0, cnt = 2;
        int[] map = new int[128];
        for (int i = 0, j = 0; i < s.length(); i++) {
        	if (map[s.charAt(i)] == 0) cnt--;
        	map[s.charAt(i)]++;
        	while (cnt < 0) {
        		if (--map[s.charAt(j++)] == 0) {
        			cnt++;
        		}
        	}
        	max = Math.max(max, i - j + 1);
        }
        return max;
    }
}