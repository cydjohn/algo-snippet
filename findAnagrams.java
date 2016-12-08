public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> res = new ArrayList();
        Map<Character, Integer> map = new HashMap();
        int cnt = 0;
        for (char c : p.toCharArray()) {
        	if (!map.containsKey(c)) {
        	    map.put(c, 1);
        	    cnt++;
        	}
        	else map.put(c, map.get(c)+1);
        }
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (i >= p.length() && map.containsKey(s.charAt(i-p.length()))) {
        		map.put(s.charAt(i-p.length()), map.get(s.charAt(i-p.length()))+1);
        		if (map.get(s.charAt(i-p.length())) == 1) cnt++;
        	}
        	if (!map.containsKey(c)) continue;
        	map.put(c, map.get(c)-1);
        	if (map.get(c) == 0) cnt--;
        	if (cnt == 0) res.add(i - p.length()+1);
        }
        return res;
    }
}