//注意hashmap的结构以及返回姓氏
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for (String s : strs) {
        	char[] ch = s.toCharArray();
        	Arrays.sort(ch);
        	String str = String.valueOf(ch);
        	if (!map.containsKey(str)) map.put(str, new ArrayList<String>());
        	map.get(str).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}