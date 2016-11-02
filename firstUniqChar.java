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

//wrong answer:
//原因：最后被记录为first的数字可能在后面不断重复，因为没有其他unique数字，这个first会被当成结果。"aadadaad"
public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;
        Set<Character> set = new HashSet();
        char[] chs = s.toCharArray();
        int first = chs.length - 1;
        for (int i = chs.length - 1; i >= 0; i--) {
            if (!set.contains(chs[i])) first = i;
            set.add(chs[i]);
        }
        //如果first停留在最后一位，说明没有找到unique的数字，返回－1
        return first == chs.length - 1 ? -1 : first;
    }
}