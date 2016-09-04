//O(n^2)
//use a & b == 0 to check if two string contains the same chars.
public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length, max = 0;
        int[] strBit = new int[n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < words[i].length(); j++) {
        		strBit[i] |= 1 << (words[i].charAt(j) - 'a');
        	}
        	for (int j = 0; j < i; j++) {
        		if ((strBit[j] & strBit[i]) == 0) max = Math.max(max, words[i].length()*words[j].length());
        	}
        }
        return max;
    }
}