public class Solution {
	List<String> res = new ArrayList();
	char[] a;
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) return res;
        a = new char[n];
        search(0, n, digits);
        return res;
    }
    private void search(int cur, int n, String digits) {
    	if (cur == n) res.add(String.valueOf(a));
    	else {
    		int num = Character.getNumericValue(digits.charAt(cur));
    		int end = 3;
    		if (num == 7 || num == 9) end = 4;
    		for (int i = 0; i < end; i++) {
    			if (num > 7) a[cur] = (char)((num - 2) * 3 + i + 'a' + 1);
    			else a[cur] = (char)((num - 2) * 3 + i + 'a');
    			search(cur+1, n, digits);
    		}
    	}
    }
}

//use hashmap to store the mappings
public class Solution {
	List<String> res = new ArrayList();
    HashMap<Integer, char[]> map = new HashMap();
    char[] letter;
    public List<String> letterCombinations(String digits) {
    	if (digits.length() == 0) return res;
        letter = new char[digits.length()];
        int incre = 0;
        for (int i = 2; i <= 9; i++) {
        	int size = 3;
        	if (i == 7 || i == 9) size = 4;
        	char[] temp = new char[size];
        	for (int j = 0; j < size; j++) temp[j] = (char)('a' + incre++);
        	map.put(i, temp);           
        }
        backcheck(0, digits.length(), digits);
        return res;
    }
    private void backcheck(int cur, int n, String digits) {
    	if (cur == n) {
    		res.add(String.valueOf(letter));
    		return;
    	}
    	char[] curMap = map.get(digits.charAt(cur) - '0');
    	for (int i = 0; i < curMap.length; i++) {
    		letter[cur] = curMap[i];
    		backcheck(cur+1, n, digits);
    	}
    }
}

