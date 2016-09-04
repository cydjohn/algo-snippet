/*This class determines whether two strings are anagram.
1. sort + check string's equivalency. O(nlogn)
2. hashmap<character, count>. O(n)*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        int p1 = 0, p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
        	if (sc[p1] != tc[p2]) return false;
        	p1++; p2++;
        }
        return true;
    }
}

/*Update 1(20%): Use map.get(ch) == 0 instead of map.remove(ch);
Update 2(98%): Use array instead of hashmap, but this change could not be apply to other unicode characters.*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch) + 1);
        }
        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) return false;
            else map.put(ch, map.get(ch) - 1);
        }
        return true;
    }
}