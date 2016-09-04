public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('X', 10);
        map.put('C', 100);
        map.put('M', 1000);
        map.put('V', 5);
        map.put('L', 50);
        map.put('D', 500);
        int res = 0;
        for (int i = s.length()-1; i >= 0; i--) {
        	if (i < s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
        		res -= map.get(s.charAt(i));
        	}else {
        		res += map.get(s.charAt(i));
        	}
        }
        return res;
    }
}