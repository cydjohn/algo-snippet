//HashMap + Two Pointers O(n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, maxLen = 0;
        /*use hashmap for the purpose of quickly restoring the index of previous chars*/
        HashMap<Character, Integer> map = new HashMap();
        for (int r = 0; r < s.length(); r++) {
        	char cur = s.charAt(r);
        	/*only consider the duplicates happened int current substring*/
        	if (map.containsKey(cur) && map.get(cur) >= l) {
        		l = map.get(cur) + 1;
        		/*rewrite the index of duplicate num*/
        		map.put(cur, r);
        	}
        	else {
        		map.put(cur, r);
        		if (maxLen < r-l+1) maxLen = r-l+1;
        	}
        }
        return maxLen;
    }
}

//substring O(n^2) ?
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, i = 0, j = 0;
        for (; j < s.length(); j++) {
        	String str = s.substring(i, j);
        	/*check if a substring contains the jth char*/
        	if (str.indexOf(s.charAt(j)) >= 0) {
        		while (s.charAt(i) != s.charAt(j)) i++;
        		i++;
        	}else {
        		maxLen = Math.max(maxLen, str.length()+1);
        	}
        }
        return maxLen;
    }
}

