public class Solution {
    public String getHint(String secret, String guess) {
    	int size = secret.length();
        HashMap<Character, Integer> nums = new HashMap<Character, Integer>(); 
        List<Character> temp = new ArrayList(); 
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < size; i++) {
        	char s = secret.charAt(i);
        	char g = guess.charAt(i);
        	if (s == g) bull++;
        	else {
        		if (nums.containsKey(s)) nums.put(s, nums.get(s)+1);
        		else nums.put(s, 1);
        		temp.add(g);
        	}
        }

        for (int i = 0; i < temp.size(); i++) {
        	char ch = temp.get(i);
        	if (nums.containsKey(ch)) {
        		cow++;
        		nums.put(ch, nums.get(ch)-1);
        		if (nums.get(ch) == 0) nums.remove(ch);
        	}
        }
        return String.valueOf(bull)+"A"+String.valueOf(cow)+"B";

    }
}


