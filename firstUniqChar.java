public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Boolean> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
        	char cur = s.charAt(i);
        	if (!map.containsKey(cur)) {
        		map.put(cur, true);
        	}else {
        		map.put(cur, false);
        	}
        }
        for (int i = 0; i < s.length(); i++) {
        	if (map.get(s.charAt(i))) return i;
        }
        return -1;
    }
}