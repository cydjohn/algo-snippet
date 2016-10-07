public class Solution {
    public int longestPalindrome(String s) {
    	if (s == null) return 0;
        HashMap<Character, Integer> map = new HashMap();
        for (char ch : s.toCharArray()) {
        	if (map.containsKey(ch)) {
        		map.put(ch, map.get(ch) + 1);
        	}else {
        		map.put(ch, 1);
        	}
        }
        List<Integer> list = new ArrayList(map.values());
        int len = 0;
        boolean hasOdd = false;
        for (int l : list) {
        	if (l % 2 == 0) len += l;
        	else {
        		hasOdd = true;
        		len += (l - 1);
        	}
        }
        return (hasOdd ? (len + 1) : len);
    }
}




