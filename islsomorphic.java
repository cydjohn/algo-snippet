public class Solution {
    public boolean isIsomorphic(String s, String t) {
    	if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
        	char ss = s.charAt(i), tt = t.charAt(i);
        	if (map.get(ss) == null) {
        		if (map.containsValue(tt)) return false;
        		else map.put(ss, tt); 
        	} 
        	else if (map.get(ss) != tt) return false;
        }
        return true;
    }
}