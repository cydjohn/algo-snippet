public class Solution {
    public boolean wordPattern(String pattern, String str) {
    	String[] word = str.split(" ");
    	if (pattern.length() != word.length) return false;
        HashMap<Character, String> map = new HashMap();
        for (int i = 0; i < pattern.length(); i++) {
        	char p = pattern.charAt(i);
        	String w = word[i];
        	if (!map.containsKey(p)) {
        		if (map.containsValue(w)) return false;
        		else map.put(p, w);
        	}
        	else if (!map.get(p).equals(w)) return false;
        }
        return true;
    }
}