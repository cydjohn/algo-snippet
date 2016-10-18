public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
        	if (words[i].equals(word1)) {
        		if (!word1.equals(word2)) p1 = i;
        	}
        	if (words[i].equals(word2)) {
        		if (word1.equals(word2)) p1 = p2;
        		p2 = i;
        	}
        	if (p1 != -1 && p2 != -1) {
        		min = Math.min(min, Math.abs(p1 - p2));
        	}
        }
        return min;
    }
}