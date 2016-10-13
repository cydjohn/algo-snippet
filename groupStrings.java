public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList();
        if (strings == null || strings.length == 0) return res;
        Map<String, List<String>> map = new HashMap();
        for (String s : strings) {
        	char[] ch = s.toCharArray();
        	int gap = ch[0] - 'a';
        	for (int i = 0; i < ch.length; i++) { //注意这里不能用 for (char c : ch)，因为对c的修改不会影响ch
        		ch[i] -= gap;
        		if (ch[i] < 'a') ch[i] += 26;
        	}
        	String pat = String.valueOf(ch);
            if (!map.containsKey(pat)) map.put(pat, new ArrayList<String>());
            map.get(pat).add(s);
        }
        return new ArrayList(map.values());
    }
}