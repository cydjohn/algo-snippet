public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
        	if (!map.containsKey(c)) {
        		map.put(c, 1);
        	}else {
        		map.put(c, map.get(c) + 1);
        	}
        }
        int cnt = 0;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
        	if ((int)(it.next()) % 2 != 0) {//the type of it.next() is Integer.
        		cnt++;
        		if (cnt > 1) return false;
        	}
        }
        return true;
    }
}