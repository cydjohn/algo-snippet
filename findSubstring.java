//O(qn) q = s.length(),n = words.length
//HashMap count + two Pointers
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
    	int n = words.length, m = words[0].length();
    	List<Integer> res = new ArrayList();
        /*Store string array with hashtable.*/
        HashMap<String, Integer> map = new HashMap();
        for (String str : words) {
        	if (map.containsKey(str)) map.put(str, map.get(str)+1);
        	else map.put(str, 1);
        }
        /*each time get a substring of length m to check if it exits in words*/
        for (int i = 0; i <= s.length()-n*m; i++) {
            HashMap<String, Integer> copy = new HashMap(map);
        	/*if it exits, use another hashset to avoid duplicate and count the number to reach n, the number of words in array words*/
        	int k = n, j = i;
        	while (k > 0) {
        		String str = s.substring(j, j+m);
        		if (!copy.containsKey(str) || copy.get(str) < 1) break;
        		//don't use remove() when str's count is less than 1, it's time consuming and will cause Time Limit Exceeded
        		copy.put(str, copy.get(str)-1);
        		k--; j+=m;
        	}
        	if (k == 0) res.add(i);
        }
        return res;
    }
}