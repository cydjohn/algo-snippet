public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap();
        for (char i : magazine.toCharArray()) {
        	if (!map.containsKey(i)) map.put(i, 1);
        	else map.put(i, map.get(i)+1);
        }
        for (char j : ransomNote.toCharArray()) {
        	if (!map.containsKey(j) || map.get(j) == 0) return false;
        	else map.put(j, map.get(j)-1);
        }
        return true;
    }
}