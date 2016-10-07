public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) return 0;
        int prev = 0; int max = 0;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
            if (map.size() <= k && max < i - prev + 1) max = i - prev + 1;
            while (map.size() > k) {
                if (map.get(s.charAt(prev)) == 1) map.remove(s.charAt(prev));
                else map.put(s.charAt(prev), map.get(s.charAt(prev)) - 1);
                prev++;
            } 
        }
        return max;
    }
}