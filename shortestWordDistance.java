public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
    	int min = Integer.MAX_VALUE, p1 = -1, p2 = -1;
    	for (int i = 0; i < words.length; i++) {
    		if (words[i].equals(word1)) p1 = i;
    		else if (words[i].equals(word2)) p2 = i;
    		if (p1 != -1 && p2 != -1 && p1 != p2) {
    			min = Math.min(min, Math.abs(p1-p2));
    		}
    		if (word1.equals(word2)) p2 = p1;
    	}
    	return min;        
    }
}