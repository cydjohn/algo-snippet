public class Solution {
    public boolean isIsomorphic(String s, String t) {
    	if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
        	char ss = s.charAt(i), tt = t.charAt(i);
        	if (map.get(ss) == null) {
                /*No two characters may map to the same character, such as "bar" -> "foo"*/
        		if (map.containsValue(tt)) return false;
        		else map.put(ss, tt); 
        	} 
        	else if (map.get(ss) != tt) return false;
        }
        return true;
    }
}

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i), tt = t.charAt(i);
            if (map.containsKey(ss) && map.get(ss) == tt) continue;
            /*No two characters may map to the same character, such as "bar" -> "foo"*/
            if (!map.containsKey(ss) && !map.containsValue(tt)) map.put(ss, tt);
            else return false;
        }
        return true;
    }
}